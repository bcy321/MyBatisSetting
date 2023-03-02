package com.example.mybatissetting.service.board;

import com.example.mybatissetting.dto.BoardDto;
import com.example.mybatissetting.dto.UserDto;
import com.example.mybatissetting.mapper.IBoardMapper;
import com.example.mybatissetting.mapper.IUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImp implements IBoardMapper {

    private final IBoardMapper boardMapper;
    private IUserMapper userMapper;


    @Override
    public List<BoardDto> selectByUserEmail(String userEmail) {
        System.out.println("******************************************************");
        System.out.println("BOARD selectByUserEmail(String userEmail) call : " + userEmail);
        System.out.println("******************************************************");
        return boardMapper.selectByUserEmail(userEmail);
    }

    @Override
    public List<BoardDto> selectByBoardTitle(String title) {
        System.out.println("******************************************************");
        System.out.println("BOARD selectByBoardTitle(String title) call : " + title);
        System.out.println("******************************************************");
        return boardMapper.selectByBoardTitle(title);
    }

    @Override
    public List<BoardDto> selectBoardListDto(int page, int size) {
        System.out.println("******************************************************");
        int offset = page;
        int limit = size;
        if(page > 0) {
            offset = page * size;
            limit = size * (page + 1);
        }
        System.out.println("BOARD boardListDto(int page, int size) call : " + page +" , "+ size);
        System.out.println("******************************************************");
        return boardMapper.selectBoardListDto(offset,limit);
    }

    @Override
    public BoardDto selectBoardById(int boardId) {
        System.out.println("******************************************************");
        System.out.println("BOARD boardById(int boardId) call : " + boardId);
        System.out.println("******************************************************");
        return boardMapper.selectBoardById(boardId);
    }

    @Override
    public void write(BoardDto board) {
        System.out.println("******************************************************");
        boardMapper.write(board);
        System.out.println("BOARD write(BoardDto board) call : " + board);
        System.out.println("******************************************************");
    }

    @Override
    public void update(BoardDto board) {
        System.out.println("******************************************************");
        boardMapper.update(board);
        System.out.println("BOARD update(BoardDto board) call : " + board);
        System.out.println("******************************************************");

    }

    @Override
    public void delete(int boardId) {
        System.out.println("******************************************************");
        boardMapper.delete(boardId);
        System.out.println("BOARD delete(int boardId) call : " + boardId);
        System.out.println("******************************************************");
    }
}
