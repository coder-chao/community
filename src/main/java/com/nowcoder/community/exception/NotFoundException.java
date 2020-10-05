package com.nowcoder.community.exception;

import org.springframework.stereotype.Component;

@Component
public class NotFoundException extends RuntimeException{

    //定义无参构造方法
    public NotFoundException() {
        super();
    }

    //定义有参构造方法
    public NotFoundException(String message) {
        super(message);
    }
}
