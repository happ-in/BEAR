package com.zootopia.bear.User.controller;

import com.zootopia.bear.Search.service.SearchService;
import com.zootopia.bear.User.domain.User;
import com.zootopia.bear.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final SearchService searchService;


    @GetMapping(value="/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        userService.kakaoLogout((String)session.getAttribute("accessToken"));  //access_Token 부여
        session.removeAttribute("accessToken");
        session.removeAttribute("userId");
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        if(userService.updateUser(user)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam long userId){
        if(userService.deleteUser(userId)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/share")
    public ResponseEntity<?> shareFeed(@RequestParam long userid){
        User user = searchService.getUser(userid).get();
        int origin = user.getShareCount();
        user.setShareCount(origin+1);
        userService.updateUser(user);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
