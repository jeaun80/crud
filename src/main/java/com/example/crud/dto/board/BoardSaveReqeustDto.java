package com.example.crud.dto.board;


import com.example.crud.domain.board.Board;
import com.example.crud.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardSaveReqeustDto {
    private String title;
    private String content;
    private int count;
    private User user;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .count(0)
                .user(user)
                .build();
    }

    public void setUser(User user) {
        this.user = user;
    }
}
