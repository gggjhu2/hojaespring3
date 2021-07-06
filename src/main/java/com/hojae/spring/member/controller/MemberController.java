package com.hojae.spring.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hojae.spring.member.model.service.MemberService;
import com.hojae.spring.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member")
@Slf4j
@SessionAttributes({ "loginMember", "next" })
public class MemberController {

	@Autowired
	public MemberService memberService;

	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	

	@GetMapping("/memberLogin.do")
	public void memberLogin() {
		///WEB-INF/views/member/memberLogin.jsp
	}

	@PostMapping("/memberLogin.do")
	public String memberLogin(@RequestParam String id, @RequestParam String password,
			 Model model, RedirectAttributes redirectAttr) {
		log.info("id={}", id);
		log.info("password={}", password);
		// 1. 업무로직
		Member member = memberService.selectOneMember(id);
		log.info("member = {}", member);
		log.info("member.password = {}", member.getPassword());
//		log.info("encryptedPassword = {}", bcryptPasswordEncoder.encode(password));
		log.info("모델은뭐냐={}",model);
		// 2. 로그인여부 분기처리
		// boolean
		// org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.matches(CharSequence
		// rawPassword, String encodedPassword)
		if (member != null && bcryptPasswordEncoder.matches(password, member.getPassword())) {
			log.info("멤버가모냐={}",member.getPassword());
			
			// 로그인 성공
			// loginMember 세션속성으로 저장하려면, class에 @SessionAttributes로 등록
			model.addAttribute("loginMember", member);
		} else {
			// 로그인 실패
			redirectAttr.addFlashAttribute("msg", "아이디 또는 비밀번호가 틀립니다.");
			return "redirect:/member/memberLogin.do";
		}

		return "redirect:/" ;
	}

}
