package com.zootopia.bear.User.controller;

import com.zootopia.bear.User.domain.User;
import com.zootopia.bear.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/test")
@RestController
public class AllController {

    private final UserService userService;

    @Autowired
    public AllController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/kakaoLogin")
    public ResponseEntity<?> home(@RequestParam(value = "code", required = false) String code) throws Exception{
        String accessToken = userService.getAccessToken(code);
        Long user_id = userService.getUserId(accessToken);
        User user = userService.getUser(user_id).get();
        if(user!=null){
            // session 할당
        } else {
            user = userService.getKakaoInfo(accessToken);
            userService.joinUser(user);
            // session 할당
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


}