package com.poindre.shua.handler;

import lombok.Value;

@Value(staticConstructor = "of")
public class Response<T> {
    boolean success;
    T data;
}
