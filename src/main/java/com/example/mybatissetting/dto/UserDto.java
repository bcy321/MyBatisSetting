package com.example.mybatissetting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int userId;
    private String userEmail;
    private int userAge;
    private String userPassword;
    private String userGrade;
}
