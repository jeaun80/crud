package com.example.crud.dto.board;


import com.example.crud.domain.board.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BoardUpdateRequestDto {

    private String content;
    private String title;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }

}
