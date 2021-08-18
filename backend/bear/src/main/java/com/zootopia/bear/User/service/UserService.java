package com.zootopia.bear.User.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.zootopia.bear.User.domain.User;
import com.zootopia.bear.User.dto.UserUpdateDto;
import com.zootopia.bear.User.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Optional;

@Service
public class UserService {

	private final static String kakaoRESTApiKey = "15e7887e87b724b15605d38adf95cf84";
	private final static String redirectURL = "https://i5a403.p.ssafy.io/api/login/kakao";

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public String getAccessToken(String authorizeCode) {
		String accessToken = "";
		String reqURL = "https://kauth.kakao.com/oauth/token";

		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();

			//    POST 요청을 위해 기본값이 false인 setDoOutput을 true로
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);

			//    POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append("grant_type=authorization_code");
			sb.append("&client_id=" + kakaoRESTApiKey);  //Kakao REST API Key
			sb.append("&redirect_uri=" + redirectURL);     // Access Token 전달 경로
			sb.append("&code=" + authorizeCode);
			bw.write(sb.toString());
			bw.flush();

			//    요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}

			//    Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);

			accessToken = element.getAsJsonObject().get("access_token").getAsString();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return accessToken;
	}

	public User getKakaoInfo(String accessToken) {
		User user = new User();
		String reqURL = "https://kapi.kakao.com/v2/user/me";
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");

			//    요청을 위한 Header 설정
			conn.setRequestProperty("Authorization", "Bearer " + accessToken);

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}

			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);

			JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
			JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

			// properties 정보 -> 필수 동의 사항
			long userId = element.getAsJsonObject().get("id").getAsLong();
			String nickname = properties.getAsJsonObject().get("nickname").getAsString();
			String profile_image = properties.getAsJsonObject().get("profile_image").getAsString();
			user.setUserId(userId);
			user.setNickname(nickname);
			user.setUserImage(profile_image);

			//kakao_account -> 선택 동의 여부 확인
			boolean hasEmail = kakao_account.getAsJsonObject().get("has_email").getAsBoolean();
			boolean hasGender = kakao_account.getAsJsonObject().get("has_gender").getAsBoolean();

			if (hasEmail) {
				String customId = kakao_account.getAsJsonObject().get("email").getAsString().split("@")[0];
				user.setCustomId(customId);
			}
			if (hasGender) {
				String sex = kakao_account.getAsJsonObject().get("gender").getAsString();
				if (sex.equals("male")) {
					user.setSex("M");
				} else {
					user.setSex("F");
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	public String getUserImage(String accessToken) {
		String image = null;
		String reqURL = "https://kapi.kakao.com/v2/user/me";
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");

			//    요청을 위한 Header 설정
			conn.setRequestProperty("Authorization", "Bearer " + accessToken);

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}

			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);

			JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();

			image = properties.getAsJsonObject().get("profile_image").getAsString();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return image;
	}


	public long getUserId(String accessToken) {
		long userId = 0;
		String reqURL = "https://kapi.kakao.com/v2/user/me";
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");

			//    요청을 위한 Header 설정
			conn.setRequestProperty("Authorization", "Bearer " + accessToken);

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}

			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);

			userId = element.getAsJsonObject().get("id").getAsLong();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userId;
	}

	public boolean joinUser(User user) {
		Long userId = user.getUserId();
		if (!userRepository.findById(userId).isPresent()) {
			userRepository.save(user);
			return true;
		}
		return false;
	}

	public boolean updateUser(UserUpdateDto userUpdateDto) {
		Long userId = userUpdateDto.getUserId();
		String nickname = userUpdateDto.getNickname();
		String customId = userUpdateDto.getCustomId();

		if (!userRepository.findById(userId).isPresent()) {
			return false;
		}
		User user = userRepository.findById(userId).get();
		if (!user.getCustomId().equals(customId)) {
			if(userRepository.findAllByCustomId(customId).size()>=1) {
				return false;
			}
			user.setCustomId(customId);
		}
		user.setNickname(nickname);
		userRepository.save(user);
		return true;
	}

	public boolean deleteUser(long userId) {
		Optional<User> user = userRepository.findById(userId);

		if (!user.isPresent()) {
			return false;
		} else {
			userRepository.deleteById(userId);
			return true;
		}
	}

	public void kakaoLogout(String accessToken) {
		String reqURL = "https://kapi.kakao.com/v1/user/logout";
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Authorization", "Bearer " + accessToken);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setImage(long userId,String image){
		User user = userRepository.findById(userId).get();
		user.setUserImage(image);
		userRepository.save(user);
	}

	public void increaseShareCount(long userId){
		User user = userRepository.findById(userId).get();
		int count = user.getShareCount();
		user.setShareCount(count+1);
		userRepository.save(user);
	}

}
