package com.choimory.pagingstrategywithquerydsl.board.entity;

import com.choimory.pagingstrategywithquerydsl.boardComment.entity.BoardComment;
import com.choimory.pagingstrategywithquerydsl.common.entity.CommonTimeEntity;
import com.choimory.pagingstrategywithquerydsl.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@SuperBuilder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board extends CommonTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String title;
    private String content;
    @OneToOne
    @JoinColumn(name = "USER_IDX")
    private User user;
    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    private List<BoardComment> boardComments;
}
