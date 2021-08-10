package com.zootopia.bear.HashTag.repository;

import java.util.List;

import com.zootopia.bear.HashTag.dto.HashTagNameDto;
import com.zootopia.bear.HashTag.dto.HashTagTotalDto;

public interface HashTagRepositoryCustom {

	List<HashTagNameDto> searchHashTagTop4(int beerId);
	List<HashTagTotalDto> searchHashTagToTal(int beerId);
}
