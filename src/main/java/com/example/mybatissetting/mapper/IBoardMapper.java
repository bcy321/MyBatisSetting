package com.example.mybatissetting.mapper;

import com.example.mybatissetting.dto.BoardDto;
import com.example.mybatissetting.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IBoardMapper {
    //사용자 이메일로 게시물 검색
    public List<BoardDto>  selectByUserEmail(String userEmail);
    //게시판 제목으로 게시물 검색
    public List<BoardDto>  selectByBoardTitle(String title);
    //게시판 목록 리스트 가져오기 페이징
    public List<BoardDto> selectBoardListDto(int page, int size);
    //게시판 내용 가져오기
    public BoardDto selectBoardById(int boardId);
    //게시물 작성
    public void write(@Param("board") BoardDto board);
    //게시물 수정
    public void update(@Param("board") BoardDto board);
    //게시물 삭제
    public void delete(int boardId);
}
