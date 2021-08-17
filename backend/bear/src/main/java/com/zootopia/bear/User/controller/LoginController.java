package com.zootopia.bear.User.controller;

import com.zootopia.bear.Search.service.SearchService;
import com.zootopia.bear.User.domain.User;
import com.zootopia.bear.User.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Optional;

@RequestMapping("/login")
@RestController
@RequiredArgsConstructor
public class LoginController {

	private final UserService userService;
	private final SearchService searchService;

	@GetMapping("/kakao")
	public ResponseEntity<HashMap<String, String>> login(@RequestParam(value = "code", required = false) String code
														 ) throws Exception {
		String accessToken = userService.getAccessToken(code);
		long userId = userService.getUserId(accessToken);
		Optional<User> user = searchService.getUser(userId);
		if (!user.isPresent()) {
			user = Optional.of(userService.getKakaoInfo(accessToken));
			userService.joinUser(user.get());
		} else {
			User userObject = user.get();
			String image = userService.getUserImage(accessToken);
			userObject.setUserImage(image);
			userService.updateUser(userObject);
		}
//		session.setAttribute("userId", userId);
//		session.setAttribute("accessToken", accessToken);

		HashMap<String, String> map = new HashMap<>();
		map.put("userId", String.valueOf(userId));
		map.put("accessToken", accessToken);
//
//		model.addAttribute("userId" ,userId);
//		model.addAttribute("accessToken",accessToken);

		return ResponseEntity.ok().body(map);
	}

}