package com.zootopia.bear.User.controller;

import com.zootopia.bear.Search.service.SearchService;
import com.zootopia.bear.User.domain.User;
import com.zootopia.bear.User.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Optional;

@RequestMapping("/api/login")
@RestController
@RequiredArgsConstructor
public class LoginController {

	private final UserService userService;
	private final SearchService searchService;

	@GetMapping("/kakao")
	public ModelAndView login(@RequestParam(value = "code", required = false) String code
	) throws Exception {
		String accessToken = userService.getAccessToken(code);
		long userId = userService.getUserId(accessToken);
		Optional<User> user = searchService.getUser(userId);
		if (!user.isPresent()) {
			userService.joinUser(userService.getKakaoInfo(accessToken));
		} else {
			String image = userService.getUserImage(accessToken);
			userService.setImage(userId,image);
		}

		HashMap<String, String> map = new HashMap<>();
		map.put("userId", String.valueOf(userId));
		map.put("accessToken", accessToken);
		String projectUrl = "https://i5a403.p.ssafy.io/";
		ModelAndView modelAndView = new ModelAndView("redirect:" + projectUrl);
		modelAndView.addObject("userId", userId);
		modelAndView.addObject("accessToken", accessToken);
		return modelAndView;
	}

}