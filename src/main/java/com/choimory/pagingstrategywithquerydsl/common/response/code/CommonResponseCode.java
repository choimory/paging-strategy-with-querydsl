package com.choimory.pagingstrategywithquerydsl.common.response.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonResponseCode {
    INVALID(100, "잘못된 요청입니다")
    , EMPTY(101, "데이터가 없습니다")
    , OK(200, "정상 처리되었습니다")
    , NOT_FOUND(404, "경로를 찾을 수 없습니다")
    , INTERNAL_SERVER_ERROR(500, "서버 오류입니다");

    private final Integer code;
    private final String message;
}
