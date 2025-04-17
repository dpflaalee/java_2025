package com.example.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

	@Scheduled(fixedRate=5000) //5초마다 실행
	public void runTask() {
		System.out.println("스케줄러 실행중:"+System.currentTimeMillis());
	}
	
	@Scheduled(cron = "0 0 10 * * ?")
	public void runTask2() {
		System.out.println("스케줄러 실행중+cron:"+System.currentTimeMillis());
	}
	
}
/*
1. @Scheduled
	fixedRate=5000 5초마다 실행
	fixedDelay = 12000 어떤 작업이 끝난 후 지정된 시간에 실행 : 비추천
	cron = "0 0 0 * * ?" 크론표현식 : 초 분 시 날짜 월 요일 :: 매일 자정
		cron = "0 0 0 1 * ?" : 매월 자정 
		cron = "0 0 0 ? * Mon" : 매주 월요일 자정 - 날짜와 요일이 영향주지 않게
		* 제한없는 모든 값 | ? 특정 값 없음(대신 다른 필드를 기준으로 실행) 
2. 

*/