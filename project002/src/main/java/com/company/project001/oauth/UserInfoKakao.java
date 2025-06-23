package com.company.project001.oauth;

import java.util.Map;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserInfoKakao implements UserInfoOAuth2 {

	private final Map<String, Object> attributes;
	
	@Override public String getProvierId() {
		Object id = attributes.get("id");
		return id !=null ? id.toString() : null ;
	}

	@Override public String getProvier() { return "kakao"; }
	
	//--------------------------------------------------------------------
	@SuppressWarnings("unchecked") //직접 만들어서 오류날 수 있기 때문에 추가
	private Map<String, Object> getAccount(){
		Object account = attributes.get("kakao_account");
		return account instanceof Map ? (Map<String, Object>) account : null ;
	}

	@SuppressWarnings("unchecked")
	private Map<String, Object> getProperties(){
		Object props = attributes.get("properties");
		return props instanceof Map ? (Map<String, Object>) props : null ;
	}
	//--------------------------------------------------------------------
	
	@Override public String getEmail() { 
		Map<String, Object> account= getAccount();
		return account != null ? (String)account.get("email") : null ; }

	@Override public String getNickname() { 
		Map<String, Object> props= getProperties();
		return props != null ? (String)props.get("nickname") : null ; }

	@Override public String getImage() {
		Map<String, Object> props= getProperties();
		String image = props != null ? (String) props.get("thumbnail_image"):null;
		return image != null ? image:"/images/thejoa.png";
	}
	// account / properties 왔다갔다하면서 위치 변해서 사용 전에 카카오 공식문서에서 체크해야함

}
/*
	<kakao>
		{
		    id=2632890179, 
		    connected_at=2023-01-22T08:17:54Z, 
		    properties = {nickname=효정}, 
		    
		    kakao_account = {
		        profile_nickname_needs_agreement=false, 
		        profile={nickname=효정}, 
		        has_email=true, 
		        email_needs_agreement=false, 
		        is_email_valid=true, 
		        is_email_verified=true, 
		        email=sally03915@naver.com
		    }
		}
*/
