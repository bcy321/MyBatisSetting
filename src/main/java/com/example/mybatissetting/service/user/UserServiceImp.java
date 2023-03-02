package com.example.mybatissetting.service.user;

import com.example.mybatissetting.dto.UserDto;
import com.example.mybatissetting.mapper.IUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements IUserMapper {

    private final IUserMapper userMapper;

    @Override
    public UserDto selectUserByEmail(String userEmail) {
        return userMapper.selectUserByEmail(userEmail);
    }

    @Override
    public List<UserDto> selectUserList() {
        return userMapper.selectUserList();
    }

    @Override
    public UserDto login(String userEmail, String userPassword) {
        return userMapper.login(userEmail,userPassword);
    }

    @Override
    public void register(UserDto user) {
        System.out.println("******************************************************");
        userMapper.register(user);
        System.out.println("USER REGISTER register Service Call()" + user);
        System.out.println("******************************************************");

    }

    @Override
    public void modify(UserDto user) {
        System.out.println("******************************************************");
        System.out.println("USER  modify Service Call()" + user);
        userMapper.modify(user);
        System.out.println("******************************************************");
    }

    @Override
    public void delete(int userId) {
        System.out.println("******************************************************");
        System.out.println("USER delete  Service Call()" + userId);
        userMapper.delete(userId);
        System.out.println("******************************************************");
    }


}
