package com.zootopia.bear.User.controller;

import com.zootopia.bear.Badge.service.UserBadgeService;
import com.zootopia.bear.Search.service.SearchService;
import com.zootopia.bear.User.domain.User;
import com.zootopia.bear.User.dto.UserUpdateDto;
import com.zootopia.bear.User.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	private final UserBadgeService userBadgeService;

	@GetMapping(value = "/logout")
	public ResponseEntity<?> logout(HttpSession session) {
		userService.kakaoLogout((String)session.getAttribute("accessToken"));  //access_Token 부여
		session.removeAttribute("accessToken");
		session.removeAttribute("userId");
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateUser(@RequestBody UserUpdateDto userUpdateDto) {

		if (userService.updateUser(userUpdateDto)) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteUser(@RequestParam long userId) {
		if (userService.deleteUser(userId)) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/share")
	public ResponseEntity<?> shareFeed(@RequestParam long userId) {
		userService.increaseShareCount(userId);
		userBadgeService.addExpertBadge(userId);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}
