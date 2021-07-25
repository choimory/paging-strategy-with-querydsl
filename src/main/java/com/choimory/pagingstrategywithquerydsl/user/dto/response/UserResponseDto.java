package com.choimory.pagingstrategywithquerydsl.user.dto.response;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Long idx;
    private String id;
    private String nickname;
}
