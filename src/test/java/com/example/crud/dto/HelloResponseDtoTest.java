package com.example.crud.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트(){
        String name = "minsu";
        String nickname= "babo";

        HelloResponseDto helloResponseDto = new HelloResponseDto(name,nickname);

        assertThat(helloResponseDto.getName()).isEqualTo(name);
        assertThat(helloResponseDto.getNickname()).isEqualTo(nickname);
    }
}
