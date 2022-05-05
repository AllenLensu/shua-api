package com.poindre.shua.account;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserPassword {

    private String password;

    private String uuid;

}
