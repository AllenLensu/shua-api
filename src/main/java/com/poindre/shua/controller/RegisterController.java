package com.poindre.shua.controller;

import com.poindre.shua.account.UserAccount;
import com.poindre.shua.account.UserAccountService;
import com.poindre.shua.account.info.UserAccountInfo;
import com.poindre.shua.account.info.UserAccountInfoService;
import com.poindre.shua.handler.Response;
import com.poindre.shua.user.User;
import com.poindre.shua.user.UserService;
import com.poindre.shua.user.info.UserInfo;
import com.poindre.shua.user.info.UserInfoService;
import com.poindre.shua.user.role.UserRole;
import com.poindre.shua.user.role.UserRoleService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@RestController
public class RegisterController {
    @Value("${avatar.path}")
    private String imageFilePath;

    @Resource
    private UserService userService;
    @Resource
    private UserAccountService userAccountService;
    @Resource
    private UserAccountInfoService userAccountInfoService;
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private UserRoleService userRoleService;

    @PostMapping("reg")
    public Response<String> registerHandler(RegisterFormData formData) {
        MultipartFile avatar = formData.getFile();
        String fileType = "." + (Objects.requireNonNull(avatar.getOriginalFilename())).split("\\.")[1];
        try (FileOutputStream fileOutputStream = new FileOutputStream(imageFilePath + formData.getUid() + fileType)) {
            fileOutputStream.write(avatar.getBytes());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        String uuid = uniqueUuid();

        User user = new User();
        user.setUid(formData.getUid());
        user.setUuid(uuid);
        userService.insertSelective(user);

        user = userService.selectByUuid(uuid).get(0);
        Long id = user.getId();
        UserAccount userAccount = new UserAccount();
        userAccount.setId(id);
        userAccount.setUuid(uuid);
        userAccount.setPassword(BCrypt.hashpw(formData.getPassword(), BCrypt.gensalt()));
        userAccount.setAvatar(formData.getUid() + fileType);
        userAccountService.insertSelective(userAccount);

        UserInfo userInfo = new UserInfo();
        userInfo.setId(uuid);
        userInfo.setName(formData.lastname + formData.firstname);
        userInfo.setAge(formData.getAge().shortValue());
        userInfo.setBirthday(Date.valueOf(formData.getBirthday()));
        userInfo.setGender(formData.getGender().shortValue());
        userInfoService.insertSelective(userInfo);

        UserAccountInfo userAccountInfo = new UserAccountInfo();
        userAccountInfo.setUuid(uuid);
        Short statu = 1;
        userAccountInfo.setStatus(statu);
        userAccountInfo.setCreatetime(new java.util.Date());
        userAccountInfoService.insertSelective(userAccountInfo);

        UserRole userRole = new UserRole();
        userRole.setUserId(uuid);
        userRole.setRoleId(statu);
        userRoleService.insertSelective(userRole);

        return Response.of(true, formData.getFirstname());
    }

    protected String uniqueUuid() {
        UUID uuid = UUID.randomUUID();
        if (userService.idUuidUnique(uuid.toString()) != 0) {
            return uniqueUuid();
        } else {
            return uuid.toString();
        }

    }

    @Data
    static class RegisterFormData {
        protected MultipartFile file;
        protected String uid;
        protected String password;
        protected Integer gender;
        protected String lastname;
        protected String firstname;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        protected LocalDate birthday;
        protected Integer age;
    }
}
