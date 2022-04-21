package com.poindre.shua.handler;

import lombok.Value;

@Value(staticConstructor = "of")
public class ErrorResponse {
    boolean success;
    String errorMessage;
}
