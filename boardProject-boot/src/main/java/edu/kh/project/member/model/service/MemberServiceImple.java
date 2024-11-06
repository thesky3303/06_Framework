package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;

@Transactional(rollbackFor=Exception.class)
@Service
@Slf4j
public class MemberServiceImple implements MemberService {

	// 등록된 Bean 중에서 같은 타입 or 상속관계인 bean
	@Autowired 	// 의존성 주입 (DI)
	private MemberMapper mapper;

	// Bcrypt 암호화 객체 의존성 주입(SecurityConfig 참고)
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	// 로그인 서비스
	@Override
	public Member login(Member inputMember) {
		
		// 암호화 진행
		
		// bcrypt.encode(문자열) : 문자열을 암호화하여 반환
		String bcryptPassword = bcrypt.encode(inputMember.getMemberPw());
		//log.debug("bcryptPassword : " + bcryptPassword);
		
		//boolean result = bcrypt.matches(inputMember.getMemberPw(), bcryptPassword);
		
		//log.debug("result : " + result );
		
		// 1. 이메일이 일치하면서 탈퇴하지 않은 회원 조회
		Member loginMember = mapper.login(inputMember.getMemberEmail());
		
		// 2. 만약에 일치하는 이메일이 없어서 조회 결과가 null 인 경우
		if(loginMember == null) return null;
		
		// 3. 입력 받은 비밀번호(평문 : inputMember.getMemberPw)와
		//    암호화된 비밀번호(loginMember.getMemberPw())
		//    두 비밀번호가 일치하는지 확인
		
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
}
