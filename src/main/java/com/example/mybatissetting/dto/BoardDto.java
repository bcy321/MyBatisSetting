package com.example.mybatissetting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    private int boardId;
    private String boardTitle;
    private int boardViewsCount;
    private String boardContent;
    private String boardWriter;
}
