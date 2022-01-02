package com.example.crud.controller.api;


import com.example.crud.config.auth.PrincipalDetail;
import com.example.crud.dto.board.BoardSaveReqeustDto;
import com.example.crud.dto.board.BoardUpdateRequestDto;
import com.example.crud.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardApiController {
    private final BoardService boardService;

    /**
     * 글작성 API
     */
    @PostMapping("/api/v1/board")
    public Long save(@RequestBody BoardSaveReqeustDto boardSaveRequestDto, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        return boardService.save(boardSaveRequestDto, principalDetail.getUser());
    }

    @DeleteMapping("/api/v1/board/{id}")
    public Long deleteById(@PathVariable Long id) {
        boardService.deleteById(id);
        return id;
    }

    @PutMapping("/api/v1/board/{id}")
    public Long update(@PathVariable Long id, @RequestBody BoardUpdateRequestDto boardUpdateRequestDto) {
        return boardService.update(id, boardUpdateRequestDto);
    }
}
