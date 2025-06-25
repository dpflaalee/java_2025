package com.company.project001.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.company.project001.domain.Member;
import com.company.project001.member.MemberService;

public class JwtTokenFilter extends OncePerRequestFilter { // Filter에서는 Autowired 사용하지 않기... 대신 private final
	private final MemberService memberService;
	private final JwtUtil jwtUtil;

	// 토큰 가져오기
	public JwtTokenFilter(MemberService memberService, JwtUtil jwtUtil) {
		this.memberService = memberService;
		this.jwtUtil = jwtUtil; } 

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String uri = request.getRequestURI();

		//1. JWT 필터제외경로 - PC제외
		if ( !uri.startsWith("/api/") ) {
			filterChain.doFilter(request, response);
			return; }

		// 인증 있는지 확인
		String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

		// 쿠키에서 토큰 추출 시도
		if (authorizationHeader == null && request.getCookies() != null) {
			Cookie jwtTokenCookie = Arrays.stream(request.getCookies())
					.filter(cookie -> cookie.getName().equals("jwtToken")).findFirst().orElse(null);

			if (jwtTokenCookie != null) {
				authorizationHeader = "Bearer " + jwtTokenCookie.getValue(); }
			//                         인증용 r뒤에 공백 하나 둬야함
		}

		// Bearer  헤더없음 → 필터 통과
		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;		}

		String token = authorizationHeader.substring(7); // Bearer(공백포함 7자) 뒤쪽부터 토큰 가져와

		//토큰만료검사
		if (jwtUtil.isExpired(token)) {
			filterChain.doFilter(request, response);
			return;		}

		//사용자 이름추출
		String username = jwtUtil.getLoginId(token);

		Member member = memberService.findByUsername(username);
		if (member == null) {
			filterChain.doFilter(request, response);
			return;
		}

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				member.getUsername(), null, List.of(new SimpleGrantedAuthority(member.getRole().name())));

		authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);

		filterChain.doFilter(request, response);
	}

}
