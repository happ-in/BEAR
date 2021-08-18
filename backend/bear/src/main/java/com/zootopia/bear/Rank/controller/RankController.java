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
@RequestMapping(value = "/api/rank")
@RequiredArgsConstructor
public class RankController {

	private final RankService rankService;

	@GetMapping("/all")
	public ResponseEntity<?> rankAll() {
		List<RankDto> rank = rankService.rankAll();
		return ResponseEntity.ok(rank);
	}

	@GetMapping("/lager")
	public ResponseEntity<?> rankByLager() {
		List<RankDto> rank = rankService.rankByCategory(LAGER);
		return ResponseEntity.ok(rank);
	}

	@GetMapping("/ale")
	public ResponseEntity<?> rankByAle() {
		List<RankDto> rank = rankService.rankByCategory(ALE);
		return ResponseEntity.ok(rank);
	}

	@GetMapping("/wheat")
	public ResponseEntity<?> rankByWheat() {
		List<RankDto> rank = rankService.rankByCategory(WHEAT);
		return ResponseEntity.ok(rank);
	}

	@GetMapping("/stout")
	public ResponseEntity<?> rankByStout() {
		List<RankDto> rank = rankService.rankByCategory(STOUT);
		return ResponseEntity.ok(rank);
	}

	@GetMapping("/rtd")
	public ResponseEntity<?> rankByRtd() {
		List<RankDto> rank = rankService.rankByCategory(RTD);
		return ResponseEntity.ok(rank);
	}
}
