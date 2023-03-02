package com.example.mybatissetting.controller.user;

import com.example.mybatissetting.dto.UserDto;
import com.example.mybatissetting.service.user.UserServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserApiController {

    private final UserServiceImp userServiceImp;

    public UserApiController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @PostMapping("/login")
    public UserDto login(@RequestBody UserDto user){
//        System.out.println();
        System.out.println("Controller : " + user);
        return userServiceImp.selectUserByEmail(user.getUserEmail());
    }

    @GetMapping("/userList")
    public List<UserDto> userList(){
//        System.out.println(userServiceImp.selectUserByEmail(userEmail));
        return userServiceImp.selectUserList();
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> userRegister(@RequestBody UserDto user){
        userServiceImp.register(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/modify")
    public ResponseEntity<UserDto> userModify(@RequestBody UserDto user){
        userServiceImp.modify(user);
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserDto> userDelete(@PathVariable int id){
        userServiceImp.delete(id);
        return null;
    }
}
