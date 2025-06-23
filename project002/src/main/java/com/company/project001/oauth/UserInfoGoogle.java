package com.company.project001.oauth;

import java.util.Map;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserInfoGoogle implements UserInfoOAuth2 {

	private final Map<String, Object> attributes;
	
	@Override public String getProvierId() {
		Object value = attributes.get("sub"); 
		//구글의 경우 버전마다 String, int 변경되기도 해서 Object로 정의하는 게 오류 덜남
		return value != null ? value.toString() : null ;
	}

	@Override public String getProvier() { return "google"; }
	@Override public String getEmail() { return (String)attributes.get("email"); }
	@Override public String getNickname() { return (String)attributes.get("name"); }

	@Override public String getImage() {
		Object pic = attributes.get("picture");
		return pic != null ? pic.toString() : "/images/thejoa.png";
	}

}

/*
  <google>
		{
		   sub=103058387739722400130, 
		   name=안효정, 
		   given_name=효정, 
		   family_name=안, 
		   picture=https://lh3.googleusercontent.com/a/AEdFTp5SiCyTaOLog9sDPN6QhWwsUj7xPbfj4HQF0fdC=s96-c, email=chb20050@gmail.com, 
		   email_verified=true, 
		   locale=ko
		}
 * */
