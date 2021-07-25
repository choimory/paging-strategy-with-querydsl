package com.choimory.pagingstrategywithquerydsl.common.exception.custom;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommonCustomException extends RuntimeException{
    private final Integer code;
    private final String message;
}
