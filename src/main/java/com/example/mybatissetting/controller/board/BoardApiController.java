package com.example.mybatissetting.controller.board;

import com.example.mybatissetting.dto.BoardDto;
import com.example.mybatissetting.dto.UserDto;
import com.example.mybatissetting.service.board.BoardServiceImp;
import com.example.mybatissetting.service.user.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardApiController {

    @Autowired
    private final BoardServiceImp boardServiceImp;

    @Autowired
    private final UserServiceImp userServiceImp;

    public BoardApiController(BoardServiceImp boardServiceImp, UserServiceImp userServiceImp) {
        this.boardServiceImp = boardServiceImp;
        this.userServiceImp = userServiceImp;
    }

    @PostMapping("search-email")
    public ResponseEntity<List<BoardDto>> searchByEmail(@RequestParam String userEmail){
       return ResponseEntity.ok(boardServiceImp.selectByUserEmail(userEmail));
    }

    @GetMapping("search-title")
    public ResponseEntity<List<BoardDto>> searchByTitle(@RequestParam(name = "title") String title){
        return ResponseEntity.ok(boardServiceImp.selectByBoardTitle(title));
    }

    @GetMapping("board-list")
    public ResponseEntity<List<BoardDto>> findBoardList(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size){
        return ResponseEntity.ok(boardServiceImp.selectBoardListDto(page,size));
    }

    @PostMapping("board-detail")
    public ResponseEntity<BoardDto> boardDetail(@RequestParam int boardId){

        UserDto userDto = userServiceImp.selectUserByEmail(boardServiceImp.selectBoardById(boardId).getBoardWriter());
        return ResponseEntity.ok(boardServiceImp.selectBoardById(boardId));
    }

    @PostMapping("board-write")
    public ResponseEntity<BoardDto> boardWrite(@RequestBody BoardDto board){
        boardServiceImp.write(board);
        return ResponseEntity.ok(board);
    }

    @PutMapping("board-update")
    public ResponseEntity<BoardDto> boardUpdate(@RequestBody BoardDto board){
        boardServiceImp.update(board);
        return ResponseEntity.ok(boardServiceImp.selectBoardById(board.getBoardId()));
    }

    @DeleteMapping("board-delete")
    public ResponseEntity<BoardDto> boardDelete(@RequestParam int boardId){
        boardServiceImp.delete(boardId);
        return ResponseEntity.ok(boardServiceImp.selectBoardById(boardId));
    }


}
