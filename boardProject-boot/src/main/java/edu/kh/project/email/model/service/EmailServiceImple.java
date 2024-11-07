package edu.kh.project.email.model.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.spring6.SpringTemplateEngine;

import edu.kh.project.email.model.mapper.EmailMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailServiceImple implements EmailService {
	
	// 필드 의존성 주입될 객체들
	private final EmailMapper mapper; // EmailMapper 의존성주입
	private final JavaMailSender mailSender; // JavaMailSender : 실제 메일 발송을 담당하는 객체(EmailConfig 설정이 적용된 객체)
	private final SpringTemplateEngine STemplateEngine; // SpringTemplateEngine : 타임리프(템플릿 엔진)를 이용해서 html 코드 -> java 코드 변환
	
	@Override
	public String sendEmail(String string, String email) {
		
		// 1. 인증키 생성 및 DB 저장 준비
		String authKey = createAuthKey();
		log.debug("authKey : " + authKey);
		
		Map<String, String> map = new HashMap<>();
		map.put("authKey", authKey);
		map.put("email", email);
		
		log.debug("map : " + map);
		
		storeAuthKey(map);
		
		
		return null;
	}

	// 인증키와 이메일을 DB에 저장하는 메서드
	@Transactional(rollbackFor = Exception.class) // 메서드 레벨에서도 이용 가능(해당 메서드에서만 트랜잭션 커밋/롤백)
	private void storeAuthKey(Map<String, String> map) {
		
		// 1 . 기존 이메일에 대한 인증키 update 수행
		int result = mapper.updateAuthKey(map);
		
		// 2. update 실패 (== 기존 데이터 없음) 시 insert 수행
		
		
		
	}

	// 인증번호 발급 메서드
	// UUID를 사용하여 인증키 생성
	// Universally Unique IDentifier : 전세계에서 고유한 식별자를 생성하기 위한 표준
	// 매우 낮은 확률로 중복되는 식별자를 생성
	// 주로 데이터베이스 기본 키, 고유한 식별자를 생성해야 할 때 사용
	private String createAuthKey() {
		return UUID.randomUUID().toString().substring(0, 6);
	}
	
	
	
	
	
	
	
	
	
















}
