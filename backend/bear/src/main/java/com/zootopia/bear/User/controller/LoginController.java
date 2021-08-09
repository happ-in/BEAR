package com.zootopia.bear.User.controller;

import com.zootopia.bear.User.domain.User;
import com.zootopia.bear.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RequestMapping("/login")
@RestController
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/kakao")
    public ResponseEntity<?> home(@RequestParam(value = "code", required = false) String code, HttpSession session) throws Exception{
        String access_Token = userService.getAccessToken(code);
        Long user_id = userService.getUserId(access_Token);
        User user = userService.getUser(user_id).get();
        if(user==null) {
            user = userService.getKakaoInfo(access_Token);
            userService.joinUser(user);
        }
        session.setAttribute("user_id",user_id);
        session.setAttribute("access_Token",access_Token);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


}