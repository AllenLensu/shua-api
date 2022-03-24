package com.poindre.shua.error;

import lombok.Value;

@Value(staticConstructor = "of")
public class Response<T> {
    boolean success;
    T data;
}
