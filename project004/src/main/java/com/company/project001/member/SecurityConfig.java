package com.company.project001.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

import com.company.project001.oauth.PrincipalOAuth2UserService;
import com.company.project001.util.JwtTokenFilter;
import com.company.project001.util.JwtUtil;

@Configuration      //스프링부트 설정파일
@EnableWebSecurity  //url 스프링시큐리티 제어 - SecurityFilterChain
public class SecurityConfig {
	
	//1. url
	@Autowired PrincipalOAuth2UserService principalOAuth2UserService;
	
	@Autowired JwtUtil jwtUtil; // jwt 토큰 발급1
	
	@Bean  SecurityFilterChain  filterChain(HttpSecurity http, MemberService memberService) throws Exception {
		
		JwtTokenFilter  jwtTokenFilter = new JwtTokenFilter(memberService, jwtUtil);  // jwt 토큰 발급2
		
		http
		.csrf().disable() // 개발용 (보호기능 비활성화) 
		.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)//세션 필요할때만
		.and()
		.authorizeRequests()
		.antMatchers("/api/member/login" , "/api/member/join" ).permitAll()  // mobile-jwt
		.antMatchers("/member/login" , "/member/join" , "/resources/**"  ).permitAll()  // pc-security만 접근가능
		.antMatchers("/board**" , "/member/member").authenticated()  // 로그인된 사용자만 접근가능
		.anyRequest().permitAll()  //지정하지 않은 다른 모든요청은 허용
		.and()
		.formLogin()
			.loginPage("/member/login")  // 커스텀로그인폼 
			.loginProcessingUrl("/member/login")  // 사용자입력한값 처리 url
			.defaultSuccessUrl("/member/member", true)  // 로그인 성공시 경로 -  true : 사용자가 로그인전 요청이 있더라도 무시하고 이 url로 이동
			.failureUrl("/member/login?error=true")	
		.and()
		.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout" ))  // 로그아웃 경로
			.logoutSuccessUrl("/member/login")  // 로그아웃 성공경로
			.invalidateHttpSession(true)  // 로그아웃시 세션무효
		.and()
		.oauth2Login() // oauth2 - kakao naver google
			.loginPage("/member/login")
			.defaultSuccessUrl("/member/member")
			.userInfoEndpoint()
			.userService(principalOAuth2UserService)
		.and()			
		.and()	
		.exceptionHandling()
			.authenticationEntryPoint( (request, response, authException)->{
				if(!request.getRequestURI().startsWith("/api/")) { // PC session 체크
					response.sendRedirect("/member/login?error=true");
				}else{ // 모바일
					response.setStatus(401); //인증되지 않음 : 로그인부터
					response.setContentType("application/json");
					response.getWriter().write("{\"error\":\"Unauthorized\"}"); 
					//{"error":"Unauthorized"}
					}
			} )
			.accessDeniedHandler( (request, response, authException)->{
				if(!request.getRequestURI().startsWith("/api/")) { // PC 체크
					response.sendRedirect("/member/login?error=true");
				}else{ // 모바일
					response.setStatus(403); // 인증되었지만 접근권한 없음 : 일반인 관리자 페이지 
					response.setContentType("application/json");
					response.getWriter().write("{\"error\":\"Unauthorized\"}"); 
					//{"error":"Unauthorized"}
				}
			} );

		http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class); // jwt 토큰 발급3
		
		return http.build();
	}
	
	
	//2. AuthenticationManager
	//사용자 인증시 Service와 PasswordEncoder를 사용
	@Bean AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws Exception {
		return auth.getAuthenticationManager();
	}
	
	//3. PasswordEncoder
//	@Bean PasswordEncoder   passwordEncoder() { return new BCryptPasswordEncoder(); }
}



 