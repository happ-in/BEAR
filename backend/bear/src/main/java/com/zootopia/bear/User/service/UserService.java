package com.zootopia.bear.User.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.zootopia.bear.User.domain.User;
import com.zootopia.bear.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public String getAccessToken (String authorize_code) {
        String access_Token = "";
        //String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //    POST 요청을 위해 기본값이 false인 setDoOutput을 true로
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //    POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=29af7f847f80be77ed28e6d1c6bee1fd");  //Kakao REST API Key
            sb.append("&redirect_uri=http://localhost:8080/testLogin");     // Access Token 전달 경로
            sb.append("&code=" + authorize_code);
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

            access_Token = element.getAsJsonObject().get("access_token").getAsString();
            //refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return access_Token;
    }

    public User getKakaoInfo (String access_Token) {
        User user = new User();
        String reqURL = "https://kapi.kakao.com/v2/user/me";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            //    요청을 위한 Header 설정
            conn.setRequestProperty("Authorization", "Bearer " + access_Token);

            int responseCode = conn.getResponseCode();

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
            Long user_id = element.getAsJsonObject().get("id").getAsLong();
            String nickname = properties.getAsJsonObject().get("nickname").getAsString();
            String profile_image = properties.getAsJsonObject().get("profile_image").getAsString();
            user.setUser_id(user_id);
            user.setNickname(nickname);
            user.setImage(profile_image);

            //kakao_account -> 선택 동의 여부 확인
            boolean has_email = kakao_account.getAsJsonObject().get("has_email").getAsBoolean();
            boolean has_gender = kakao_account.getAsJsonObject().get("has_gender").getAsBoolean();

            if (has_email) {
                String custom_id = kakao_account.getAsJsonObject().get("email").getAsString();
                user.setCustom_id(custom_id);
            } else {
                user.setCustom_id("empty");
            }

            if (has_gender) {
                String sex = kakao_account.getAsJsonObject().get("gender").getAsString();
                user.setSex(sex);
            } else {
                user.setSex("empty");
            }


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return user;
    }

    public long getUserId(String access_Token){
        long user_id=0;
        String reqURL = "https://kapi.kakao.com/v2/user/me";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            //    요청을 위한 Header 설정
            conn.setRequestProperty("Authorization", "Bearer " + access_Token);

            int responseCode = conn.getResponseCode();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            user_id = element.getAsJsonObject().get("id").getAsLong();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user_id;
    }

    public Optional<User> getUser(long user_id) {
        return userRepository.findById(user_id);
    }

    public boolean joinUser(User user) {
        Long user_id = user.getUser_id();
        if(!userRepository.findById(user_id).isPresent()) {
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public boolean updateUser(User user) {
        Long user_id = user.getUser_id();
        Optional<User> new_user = userRepository.findById(user_id);

        if(!new_user.isPresent()) {
            return false;
        }
        // nickname check
        return true;
    }

    public boolean deleteUser(User user) {
        Long user_id = user.getUser_id();
        Optional<User> new_user = userRepository.findById(user_id);

        if(!new_user.isPresent()) {
            return false;
        } else {
            userRepository.deleteById(user_id);
            return true;
        }
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(u->users.add(u));
        return users;
    }

    public void kakaoLogout(String access_Token) {
        String reqURL = "https://kapi.kakao.com/v1/user/logout";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + access_Token);

            int responseCode = conn.getResponseCode();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



}