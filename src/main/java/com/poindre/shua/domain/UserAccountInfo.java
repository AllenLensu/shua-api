package com.poindre.shua.domain;

import java.util.Date;
import lombok.Data;

@Data
public class UserAccountInfo {
    private Long id;

    private String uuid;

    private Long experience;

    private Integer grade;

    private Integer score;

    private String email;

    private Boolean isemailverify;

    private String phone;

    private Boolean isphoneverify;

    private Short status;

    private Date createtime;

    private Date lastactivetime;

    private Long followers;

    private Long following;

    private Boolean isbanned;

    private String banreason;

    private Date bandeadline;
}