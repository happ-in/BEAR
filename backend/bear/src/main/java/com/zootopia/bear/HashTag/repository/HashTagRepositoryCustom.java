package com.zootopia.bear.HashTag.repository;

import java.util.List;

import com.zootopia.bear.HashTag.dto.HashTagDto;

public interface HashTagRepositoryCustom {

	List<HashTagDto> searchHashTagTop4(int beerId);
}
