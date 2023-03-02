package com.example.mybatissetting.mapper;

import com.example.mybatissetting.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IProductMapper {
    public UserDto selectUserByEmail(String userEmail);
    public List<UserDto> selectUserList();
}
