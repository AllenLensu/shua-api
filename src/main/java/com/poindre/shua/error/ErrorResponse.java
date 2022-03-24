package com.poindre.shua.error;

import lombok.Value;

@Value(staticConstructor = "of")
public class ErrorResponse {
    boolean success;
    String errorMessage;
}
