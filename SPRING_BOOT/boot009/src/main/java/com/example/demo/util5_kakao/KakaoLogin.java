package com.example.demo.util5_kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@Component
public class KakaoLogin {
	@Value("${kakao_redirect_url}") 
	private String kakao_redirect_url;

	@Value("${kakao_api}") 
	private String kakao_api;
	
	//1. login : 인증(사용자 신원확인) , 인가(접근권한)
	public String step1() {
		return "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id="
				+ kakao_api
				+ "&redirect_uri="
				+ kakao_redirect_url;
	}
	
	//2. code 인가코드를 토큰
	public List<String> step2(String code) { 
		System.out.println("..........step1)"+code);
		String tokenUrl="https://kauth.kakao.com/oauth/token";
		tokenUrl+= "?grant_type=authorization_code"
				   +"&client_id="+kakao_api
				   + "&redirect_uri=" + kakao_redirect_url
				   +"&code="+code;
		//post
		//Content-Type: application/x-www-form-urlencoded;charset=utf-8
		
		URL url = null;
		HttpURLConnection conn = null;
		BufferedReader br=null;
		String line = ""; StringBuffer buffer=new StringBuffer();
		String resultToken="";
		
		try {
			url= new URL(tokenUrl);
			conn=(HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoInput(true); conn.setDoOutput(true);
			conn.addRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
			
			if(conn.getResponseCode()==200) {
				br= new BufferedReader(new InputStreamReader(conn.getInputStream()));
			}else {br=new BufferedReader(new InputStreamReader(conn.getErrorStream()));}
			
			while( (line=br.readLine())!=null ) { buffer.append(line); }
			br.close();
			conn.disconnect();
			resultToken=buffer.toString();
			System.out.println(".............."+resultToken);
		} catch (MalformedURLException e) { e.printStackTrace();
		}catch(IOException e) {e.printStackTrace();}
		
//	..........step1)FhBKch-znLfgvXvMXQaLi-bc60JDQxm3vzghQqcnWaVqiHE7vHDTFAAAAAQKFxBvAAABlkbUbn7Nsk3jZ7dWzg
//..............{"access_token":"FkNv7-rCBjEe0_b9dslB7Nx44j6WZvVsAAAAAQoNIFoAAAGWRtRuzpQkbXeV0h_w","token_type":"bearer","refresh_token":"wBvx0AlkTG1AEH9udErRpthz384LyJ-MAAAAAgoNIFoAAAGWRtRuyJQkbXeV0h_w","expires_in":7199,"scope":"profile_image profile_nickname","refresh_token_expires_in":5183999}
		//com.google.gson
		JsonObject job = JsonParser.parseString(resultToken).getAsJsonObject();
		String token=job.get("access_token").getAsString();
		System.out.println(".............."+token);
		
		return step3(token); //마지막 수정
	}
	
	//step3) 사용자 정보 가져오기 --> username, profile img
	public List<String> step3(String token) { 
		System.out.println("..........step2)"+token);
		List<String> userInfos = new ArrayList<>();
		
		String userUrl="https://kapi.kakao.com/v2/user/me";
		URL url = null; HttpURLConnection conn = null;
		BufferedReader br=null; String line = ""; StringBuffer buffer=new StringBuffer();
		String result="";
		try {
			url= new URL(userUrl);			
			conn=(HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.addRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
			conn.addRequestProperty("Authorization", "Bearer " + token);
			
			if(conn.getResponseCode()==200) {
				br= new BufferedReader(new InputStreamReader(conn.getInputStream()));
			}else {br=new BufferedReader(new InputStreamReader(conn.getErrorStream()));}
			while( (line=br.readLine())!=null ) { buffer.append(line); }
			br.close();
			conn.disconnect();
			
		} catch (MalformedURLException e) { e.printStackTrace();
		}catch(IOException e) {e.printStackTrace();}
		
		/*
		curl -v -X POST "https://kapi.kakao.com/v2/user/me" \
    -H "Content-Type: application/x-www-form-urlencoded;charset=utf-8" \
    -H "Authorization: Bearer ${ACCESS_TOKEN}" \
    --data-urlencode 'property_keys=["kakao_account.email"]'
		*/
		
		result=buffer.toString(); System.out.println(".........."+result);
		JsonObject job = JsonParser.parseString(result).getAsJsonObject();
		userInfos.add(job.getAsJsonObject("properties").get("nickname").getAsString());
		userInfos.add(job.getAsJsonObject("properties").get("profile_image").getAsString());
		System.out.println("............"+userInfos);
/*
..........step2)di2nGGMjyvFTFg7CVbAgrQpvA43ug5suAAAAAQoXEC8AAAGWRwashZQkbXeV0h_w
..........{"id":4221820916,"connected_at":"2025-04-18T02:54:38Z","properties":{"nickname":"예림","profile_image":"http://k.kakaocdn.net/dn/bkS9lC/btrt7riDkrS/Kxl3xJ4VkUWqId9PplhgFk/img_640x640.jpg","thumbnail_image":"http://k.kakaocdn.net/dn/bkS9lC/btrt7riDkrS/Kxl3xJ4VkUWqId9PplhgFk/img_110x110.jpg"},"kakao_account":{"profile_nickname_needs_agreement":false,"profile_image_needs_agreement":false,"profile":{"nickname":"예림","thumbnail_image_url":"http://k.kakaocdn.net/dn/bkS9lC/btrt7riDkrS/Kxl3xJ4VkUWqId9PplhgFk/img_110x110.jpg","profile_image_url":"http://k.kakaocdn.net/dn/bkS9lC/btrt7riDkrS/Kxl3xJ4VkUWqId9PplhgFk/img_640x640.jpg","is_default_image":false,"is_default_nickname":false}}}
*/
		
		return userInfos; //마지막 수정
	}		
	
}
/*
curl -v -X POST "https://kauth.kakao.com/oauth/token" \
    -H "Content-Type: application/x-www-form-urlencoded;charset=utf-8" \
    -d "grant_type=authorization_code" \
    -d "client_id=${REST_API_KEY}" \
    --data-urlencode "redirect_uri=${REDIRECT_URI}" \
    -d "code=${AUTHORIZE_CODE}"

*/
