package com.zootopia.bear.Search.service;

import java.util.ArrayList;
import java.util.List;

import com.zootopia.bear.Bookmark.domain.Bookmark;
import com.zootopia.bear.Bookmark.repository.BookmarkRepository;
import com.zootopia.bear.Follower.domain.Follower;
import com.zootopia.bear.Follower.dto.FollowDto;
import com.zootopia.bear.Follower.repository.FollowerRepository;
import com.zootopia.bear.User.domain.User;
import com.zootopia.bear.User.repository.UserRepository;
import org.springframework.stereotype.Service;

import com.zootopia.bear.Beer.domain.Beer;
import com.zootopia.bear.Beer.dto.BeerDto;
import com.zootopia.bear.Beer.repository.BeerRepository;
import com.zootopia.bear.HashTag.domain.HashTag;
import com.zootopia.bear.HashTag.dto.HashTagDto;
import com.zootopia.bear.HashTag.repository.HashTagRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchService {

	private final BeerRepository beerRepository;
	private final HashTagRepository hashTagRepository;
	private final BookmarkRepository bookmarkRepository;
	private final UserRepository userRepository;
	private final FollowerRepository followerRepository;

	public List<HashTagDto> searchHashTag(String hashTagName) {
		List<HashTag> hashTags = hashTagRepository.findByHashTagNameContains(hashTagName);
		List<HashTagDto> hashTagNameDtos = new ArrayList<>();
		for (HashTag hashTag : hashTags) {
			hashTagNameDtos.add(new HashTagDto(hashTag.getHashTagId(), hashTag.getHashTagName()));
		}
		return hashTagNameDtos;
	}

	public List<BeerDto> searchBeer(String beerName) {
		List<Beer> beers = beerRepository.findByBeerNameContains(beerName);
		List<BeerDto> beerDtos = new ArrayList<>();
		for (Beer beer : beers) {
			beerDtos.add(new BeerDto(beer.getBeerId(), beer.getBeerName(), beer.getBeerImage()));
		}
		return beerDtos;
	}

	public List<BeerDto> searchBookmark(Long userId){
		List<Bookmark> bookmarkList = bookmarkRepository.findAllByBookmarkId_UserId(userId);
		List<BeerDto> beerDtoList = new ArrayList<>();
		for(Bookmark bookmark : bookmarkList) {
			int beerId = bookmark.getBookmarkId().getBeerId();
			Beer beer = beerRepository.getById(beerId);
			BeerDto beerDto = new BeerDto(beer.getBeerId(),beer.getBeerName(),beer.getBeerImage());
			beerDtoList.add(beerDto);
		}
		return beerDtoList;
	}

	public List<FollowDto> getFollowList(Long userId){
		List<Follower> list = followerRepository.findFollowersByFollowerId_UserId(userId);
		List<FollowDto> followList = new ArrayList<>();
		for(Follower follower : list) {
			Long followUserId = follower.getFollowerId().getFollowUserId();
			User followUser = userRepository.getById(followUserId);
			followList.add(new FollowDto(followUserId,followUser.getNickname()));
		}
		return followList;
	}

	public List<FollowDto> getFollowerList(Long followUserId){
		List<Follower> list = followerRepository.findFollowersByFollowerId_FollowUserId(followUserId);
		List<FollowDto> followerList = new ArrayList<>();
		for(Follower follower : list) {
			Long followerId = follower.getFollowerId().getUserId();
			User followerUser = userRepository.getById(followerId);
			followerList.add(new FollowDto(followerId,followerUser.getNickname()));
		}
		return followerList;
	}


}
