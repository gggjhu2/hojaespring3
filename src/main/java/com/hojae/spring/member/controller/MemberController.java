package com.hojae.spring.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hojae.spring.member.model.service.MemberService;
import com.hojae.spring.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member")
@Slf4j
@SessionAttributes({ "loginMember" })
//"loginMember" 라는걸로 모델에저장을한다면 세
public class MemberController {

	@Autowired
	public MemberService memberService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	//로그인기능 구현
	
//	==============================================
	//로그인페이지 요청
	@GetMapping("/memberLogin.do")
	public void memberLogin() {
		
	}
	
	
	//로그인기능구현
	@PostMapping("/memberLogin.do")
	public String memberLogin(@RequestParam String id, @RequestParam String password,Model model, RedirectAttributes redirectAttr) {
		log.info("아이디는={}",id);
		log.info("비번은={}",password);
		
		//1.업무로직
		Member member = memberService.selectOneMember(id);
		//로그	
		log.info("==============1.업무로직log시작========================");
		log.info("member에뭐가있냐={}",member);
		log.info("member.password가뭐냐={}",member.getPassword());
		log.info("모델은뭐냐={}",model );
		log.info("=============1.업무로직log끗====================");
		
		//2.로그인여부 분기처리
		
		if(member !=null &&bcryptPasswordEncoder.matches(password, member.getPassword())) 
		{	
			//로그
		log.info("==================2로그인기능LOG====================");
		log.info("member는뭐냐={}",member.getPassword());
		log.info("==================2로그인기능LOG끗====================");
		
				//로그인성공시
			model.addAttribute("loginMember",member);
			
		}else {
			
			redirectAttr.addFlashAttribute("msg","아이디 또는 비밀번호가 틀렸씁니다.");
			return "redirect:/member/memberLogin.do";
		}
		
		return "redirect:/";

	}
		
	//로그아웃 기능구현하기
		@GetMapping("/memberLogout.do")
		public String memberLogout(SessionStatus status) {
			if(!status.isComplete())
				status.setComplete();
			return "redirect:/";
		}
	
	}
	
	
	
	
	
	
	

