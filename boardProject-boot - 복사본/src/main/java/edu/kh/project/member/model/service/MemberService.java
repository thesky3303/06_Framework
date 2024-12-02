package edu.kh.project.member.model.service;

import java.util.List;

import edu.kh.project.member.model.dto.Member;

public interface MemberService {

	/** 로그인 서비스
	 * @param inputMember
	 * @return loginMember
	 */
	Member login(Member inputMember);

	/** 이메일 중복검사 서비스
	 * @param memberEmail
	 * @return
	 * @author 제작자이름
	 */
	int checkEmail(String memberEmail);

	/** 닉네임 중복검사
	 * @param memberNickname
	 * @return
	 */
	int checkNickname(String memberNickname);

	/** 회원 가입 서비스
	 * @param inputMember
	 * @param memberAddress
	 * @return result
	 */
	int signup(Member inputMember, String[] memberAddress);

	
	//------------------------------------------------------------
	// 비동기 테스트
	
	
	List<Member> selectMemberList();

	int resetPw(int inputNo);

	int restoreMember(int inputNo);

	

}
