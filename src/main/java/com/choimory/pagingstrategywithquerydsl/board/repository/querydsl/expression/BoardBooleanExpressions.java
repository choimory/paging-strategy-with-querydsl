package com.choimory.pagingstrategywithquerydsl.board.repository.querydsl.expression;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.sun.xml.bind.v2.model.core.EnumLeafInfo;
import org.springframework.util.StringUtils;

import static com.choimory.pagingstrategywithquerydsl.board.entity.QBoard.board;

public class BoardBooleanExpressions {
    public static BooleanExpression likeTitle(String title){
        return StringUtils.hasText(title) ? board.title.containsIgnoreCase(title) : null;
    }

    public static BooleanExpression eqNickname(String nickname){
        return StringUtils.hasText(nickname) ? board.user.nickname.containsIgnoreCase(nickname) : null;
    }
}
