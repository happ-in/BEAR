package com.zootopia.bear.User.controller;

import com.zootopia.bear.User.domain.User;
import com.zootopia.bear.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        userService.kakaoLogout((String)session.getAttribute("access_Token"));  //access_Token 부여
        //session 초기화 설정
        session.removeAttribute("access_Token");
        session.removeAttribute("user_id");
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> userUpdate(@RequestParam User user){
        if(userService.updateUser(user)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> userDelete(@RequestParam User user){
        if(userService.deleteUser(user)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
    }

}
