package com.zootopia.bear.HashTag.repository;

import java.util.List;

import com.zootopia.bear.HashTag.dto.HashTagNameDto;

public interface HashTagRepositoryCustom {

	List<HashTagNameDto> searchHashTagTop4(int beerId);
}
