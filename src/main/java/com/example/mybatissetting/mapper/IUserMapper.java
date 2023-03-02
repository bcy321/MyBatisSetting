package com.example.mybatissetting.mapper;

import com.example.mybatissetting.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IUserMapper {
    public UserDto selectUserByEmail(String userEmail);
    public List<UserDto> selectUserList();
    public UserDto login(String userEmail, String userPassword);
    public void register(@Param("user") UserDto user);
    public void modify(@Param("user") UserDto user);
    public void delete(int userId);
}
