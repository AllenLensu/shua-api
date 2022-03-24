package com.poindre.shua;

import com.poindre.shua.domain.UserAccount;
import com.poindre.shua.service.UserAccountService;
import com.poindre.shua.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.annotation.Resource;

@SpringBootTest
class ShuaApplicationTests {
    @Resource
    private UserAccountService userAccountService;
    @Resource
    private UserInfoService userInfoService;

    @Test
    void contextLoads() {
        System.out.println(userInfoService.selectByUuid("01969f11-2f28-48ea-93a0-dec97d12a39e"));
    }

    @Test
    void testBCrypt() {
        String password = BCrypt.hashpw("admin", BCrypt.gensalt());
        System.out.println(password);

        Boolean result = BCrypt.checkpw("password", "$2a$10$kfEXDDG4925DsXwleoO.Ou.IgFHaoaj7FJaSabDiVxpeeQknl2n8K");
        System.out.println(result);
    }

    @Test
    void fixDB4BC() {
        long temp = 100L;
        while (temp-- > 0) {
            UserAccount account = userAccountService.selectByPrimaryKey(temp + 1);
            account.setPassword(BCrypt.hashpw(account.getPassword(), BCrypt.gensalt()));
            System.out.println(temp + " " + account.getPassword());
            userAccountService.updateByPrimaryKey(account);
        }
    }

    @Test
    void regex() {
        String a = "123";
        String b = "kj23j";
        String c = "kasdlf-a23jhjk-ds877";
        String regex1 = "^[0-9]+$";
        String regex2 = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[0-9])$";
        System.out.println(b.matches(regex2));
    }

}
