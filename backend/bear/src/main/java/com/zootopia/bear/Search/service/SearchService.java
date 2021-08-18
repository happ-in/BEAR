package com.zootopia.bear.Search.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zootopia.bear.Badge.domain.Badge;
import com.zootopia.bear.Badge.domain.UserBadge;
import com.zootopia.bear.Badge.domain.UserBadgeId;
import com.zootopia.bear.Badge.dto.GainBadge;
import com.zootopia.bear.Badge.repository.BadgeRepository;
import com.zootopia.bear.Badge.repository.UserBadgeRepository;
import com.zootopia.bear.Bookmark.domain.Bookmark;
import com.zootopia.bear.Bookmark.repository.BookmarkRepository;
import com.zootopia.bear.Follow.domain.Follow;
import com.zootopia.bear.Follow.dto.FollowDto;
import com.zootopia.bear.Follow.repository.FollowRepository;
import com.zootopia.bear.Review.repository.ReviewRepository;
import com.zootopia.bear.User.domain.User;
import com.zootopia.bear.User.dto.UserInfoDto;
import com.zootopia.bear.User.dto.UserDto;
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
	private final FollowRepository followRepository;
	private final UserBadgeRepository userBadgeRepository;
	private final BadgeRepository badgeRepository;
	private final ReviewRepository reviewRepository;

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

	public List<UserDto> searchUser(String customId) {
		List<User> users = userRepository.findByCustomIdContains(customId);
		List<UserDto> userDtos = new ArrayList<>();
		for (User user : users) {
			UserDto userDto = UserDto.builder()
				.userId(user.getUserId())
				.customId(user.getCustomId())
				.userImage(user.getUserImage())
				.nickname(user.getNickname())
				.build();
			userDtos.add(userDto);
		}
		return userDtos;
	}

	public List<BeerDto> searchBookmark(Long userId){
		List<Bookmark> bookmarkList = bookmarkRepository.findAllByBookmarkId_UserId(userId);
		List<BeerDto> beerDtoList = new ArrayList<>();
		for(Bookmark bookmark : bookmarkList) {
			int beerId = bookmark.getBookmarkId().getBeerId();
			Beer beer = beerRepository.findById(beerId);
			BeerDto beerDto = new BeerDto(beer.getBeerId(),beer.getBeerName(),beer.getBeerImage());
			beerDtoList.add(beerDto);
		}
		return beerDtoList;
	}

	public Optional<User> getUser(long userId) {
		return userRepository.findById(userId);
	}

	public UserInfoDto getUserInfoDto(long userId) {
		User user = userRepository.findById(userId).get();
		int reviewCount = reviewRepository.findAllByUserId(userId).size();
		int followCount = followRepository.findAllByFollowerId_UserId(userId).size();
		int followerCount = followRepository.findAllByFollowerId_FollowUserId(userId).size();

		return UserInfoDto.builder()
				.userId(user.getUserId())
				.customId(user.getCustomId())
				.userImage(user.getUserImage())
				.nickname(user.getNickname())
				.sex(user.getSex())
				.shareCount(user.getShareCount())
				.reviewCount(reviewCount)
				.followCount(followCount)
				.followerCount(followerCount)
				.build();
	}

	public List<FollowDto> getFollowList(long userId){
		List<Follow> list = followRepository.findAllByFollowerId_UserId(userId);
		List<FollowDto> followList = new ArrayList<>();
		for(Follow follower : list) {
			long followUserId = follower.getFollowerId().getFollowUserId();
			User followUser = userRepository.findById(followUserId).get();
			followList.add(new FollowDto(followUserId,followUser.getNickname(), followUser.getUserImage(),followUser.getCustomId()));
		}
		return followList;
	}

	public List<FollowDto> getFollowerList(long followUserId){
		List<Follow> list = followRepository.findAllByFollowerId_FollowUserId(followUserId);
		List<FollowDto> followerList = new ArrayList<>();
		for(Follow follower : list) {
			long followerId = follower.getFollowerId().getUserId();
			User followerUser = userRepository.findById(followerId).get();
			followerList.add(new FollowDto(followerId,followerUser.getNickname(),followerUser.getUserImage(),followerUser.getCustomId()));
		}
		return followerList;
	}

	public List<GainBadge> getGainBadgeList(long userId) {
		List<GainBadge> gainBadgeList = new ArrayList<>();
		List<Integer> userBadgeList = new ArrayList<>();
		for(UserBadge userBadge : userBadgeRepository.findAllByUserBadgeId_UserId(userId)) {
			userBadgeList.add(userBadge.getUserBadgeId().getBadgeId());
		}
		List<Badge> badgeList = badgeRepository.findAll();

		for(Badge badge : badgeList) {
			int badgeId = badge.getBadgeId();
			if(userBadgeList.contains(badgeId)) {
				UserBadgeId userBadgeId = new UserBadgeId(badgeId,userId);
				String localDateTime = userBadgeRepository.findByUserBadgeId(userBadgeId).getAcquisitionDate().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));;
				gainBadgeList.add(new GainBadge(badge,localDateTime,true));
			} else {
				gainBadgeList.add(new GainBadge(badge,null,false));
			}
		}
		return gainBadgeList;
	}


}
