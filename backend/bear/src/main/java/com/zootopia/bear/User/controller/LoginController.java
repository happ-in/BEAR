package com.zootopia.bear.User.controller;

import com.zootopia.bear.Search.service.SearchService;
import com.zootopia.bear.User.domain.User;
import com.zootopia.bear.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Optional;


@RequestMapping("/login")
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;
    private final SearchService searchService;

    @GetMapping("/kakao")
    public String home(@RequestParam(value = "code", required = false) String code, HttpSession session ) throws Exception{
        String accessToken = userService.getAccessToken(code);
        long userId = userService.getUserId(accessToken);
        Optional<User> user = searchService.getUser(userId);
        if(!user.isPresent()) {
            user = Optional.of(userService.getKakaoInfo(accessToken));
            userService.joinUser(user.get());
        }
        session.setAttribute("userId",userId);
        session.setAttribute("accessToken",accessToken);
        return "/";
    }


}