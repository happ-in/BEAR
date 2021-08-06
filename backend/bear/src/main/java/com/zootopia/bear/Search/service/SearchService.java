package com.zootopia.bear.Search.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zootopia.bear.HashTag.domain.HashTag;
import com.zootopia.bear.HashTag.dto.HashTagDto;
import com.zootopia.bear.HashTag.repository.HashTagRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchService {

	private final HashTagRepository hashTagRepository;

	public List<HashTagDto> searchHashTag(String hashTag) {
		List<HashTag> hashTags = hashTagRepository.findByHashTagContains(hashTag);
		List<HashTagDto> hashTagDtos = new ArrayList<>();
		for (HashTag tag : hashTags) {
			hashTagDtos.add(new HashTagDto(tag.getHashTagId(), tag.getHashTagName()));
		}
		return hashTagDtos;
	}
}
