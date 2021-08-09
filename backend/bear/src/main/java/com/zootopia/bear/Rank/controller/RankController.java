package com.zootopia.bear.Rank.controller;

import static com.zootopia.bear.utils.StringUtils.*;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zootopia.bear.Rank.dto.RankDto;
import com.zootopia.bear.Rank.service.RankService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/rank")
@RequiredArgsConstructor
public class RankController {

	private final RankService rankService;

	@GetMapping
	public ResponseEntity<?> rankAll() {
		List<RankDto> rank = rankService.rankAll();
		return new ResponseEntity<>(rank, HttpStatus.OK);
	}

	@GetMapping("/lager")
	public ResponseEntity<?> rankByLager() {
		List<RankDto> rank = rankService.rankByCategory(LAGER);
		return new ResponseEntity<>(rank, HttpStatus.OK);
	}

	@GetMapping("/ale")
	public ResponseEntity<?> rankByAle() {
		List<RankDto> rank = rankService.rankByCategory(ALE);
		return new ResponseEntity<>(rank, HttpStatus.OK);
	}

	@GetMapping("/wheat")
	public ResponseEntity<?> rankByWheat() {
		List<RankDto> rank = rankService.rankByCategory(WHEAT);
		return new ResponseEntity<>(rank, HttpStatus.OK);
	}

	@GetMapping("/stout")
	public ResponseEntity<?> rankByStout() {
		List<RankDto> rank = rankService.rankByCategory(STOUT);
		return new ResponseEntity<>(rank, HttpStatus.OK);
	}

	@GetMapping("/rtd")
	public ResponseEntity<?> rankByRtd() {
		List<RankDto> rank = rankService.rankByCategory(RTD);
		return new ResponseEntity<>(rank, HttpStatus.OK);
	}
}
