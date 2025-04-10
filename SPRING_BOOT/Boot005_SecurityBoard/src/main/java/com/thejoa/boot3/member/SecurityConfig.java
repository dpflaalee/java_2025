package com.thejoa.boot3.member;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration // 스트링부트 환경설정파일
@EnableWebSecurity //url 스프링 시큐리티 제어 SecurityFilterChain
public class SecurityConfig {
	//1. url
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//1-1. 로그인을 안하더라도 모든페이지 접근가능
		// /admin/** /user/** 등등등
		http.authorizeHttpRequests(
				(authorizeHttpRequests) -> authorizeHttpRequests
//											.requestMatchers(new AntPathRequestMatcher("/admin/**"))
//											.hasRole("ROLE_ADMIN")				
											//admin만 접근가능
//											.requestMatchers(new AntPathRequestMatcher("/member/**"))
//											.hasRole("ROLE_MEMBER")				
											//member만 접근가능
											.requestMatchers(new AntPathRequestMatcher("/**"))
											.permitAll()
											//모든사용자 접근가능
		).formLogin(//1-2. form 만든폼 
				(formLogin)-> formLogin
								.loginPage("/member/login")
								.defaultSuccessUrl("/member/member")
		).logout( //1-3. logout
				(logout)-> logout
							.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
							.logoutSuccessUrl("/member/login")
							.invalidateHttpSession(true)
		);
		return http.build();} 
	
	//2. manager  사용인증 시 Service와 PasswordEncoder 사용
	@Bean 
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) 
	throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	} 
	
	//3. PasswordEncoder 비번 암호화
	
	@Bean PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
// Bena 스프링이 관리하는 객체