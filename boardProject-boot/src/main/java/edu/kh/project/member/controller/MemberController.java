package edu.kh.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.MemberService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("member")
public class MemberController {

	@Autowired // 의존성 주입(DI)
	private MemberService service;
	
	/*
	 * [로그인]
	 * - 특정 사이트에 아이디/비밀번호 등을 입력해서
	 *   해당 정보가 있으면 조회/서비스 이용
	 *   
	 * - 로그인 한 회원 정보를 session에 기록하여
	 * 	 로그아웃 또는 브라우저 종료(탭 종료X) 시 까지
	 * 	 해당 정보를 계속 이용할 수 있게 함
	 * 
	 * */
	
	
	
	/** 로그인 
	 * @param inputMember : 커맨드 객체 (@ModelAttribute 생략)
	 * 						memberEmail, memberPw 세팅된 상태
	 * @param ra : 리다이렉트 시 requst scope로 데이터 전달하는 객체(request -> session -> request)
	 * @param model : 데이터 전달용 객체 (기본 request scope 
	 * 				/ @SessionAttributes 어노테이션과 함께 사용시 session scope 이동)
	 * @param saveId
	 * @param resp
	 * @return
	 */
	@PostMapping("login")
	public String login(/* @ModelAttribute */ Member inputMember,
						RedirectAttributes ra,
						Model model,
						@RequestParam(value="saveId", required = false) String saveId,
						HttpServletResponse resp) {
		
		
		// 로그인 서비스 호출
		Member loginMember = service.login(inputMember);
			 
		// 로그인 실패 시
		if(loginMember == null) {
			ra.addFlashAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		
		
		return "redirect:/"; // 메인페이지 재요청
	}
	
}
