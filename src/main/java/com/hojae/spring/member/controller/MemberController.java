package com.hojae.spring.member.controller;

import java.beans.PropertyEditor;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import com.hojae.spring.member.model.service.MemberService;
import com.hojae.spring.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/member")
@SessionAttributes({"loginMember"})
public class MemberController {

	@Autowired
	public MemberService memberService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	
	
	
	@GetMapping("/memberLogin.do")
	public void memberLogin() {
		
	}
	
	@PostMapping("/memberLogin.do")
	public String memberLogin(
			@RequestParam String id,
			@RequestParam String password,
			Model model,
			RedirectAttributes redirectAttr
			)
	{
		Member member= memberService.selectOneMember(id);
		
		if(member !=null &&bcryptPasswordEncoder.matches(password, member.getPassword()))
		{
			model.addAttribute("loginMember",member);
			
		}else {
			
			redirectAttr.addFlashAttribute("msg","아이디혹은비번틀림");
			return"redirect:/member/memberLogin.do";
			
		}
		
		return "redirect:/" ;
		
	}

	@GetMapping("memberLogout.do")
	public String memberLogout(SessionStatus status) {
									//invalidate 무효화 
		if(!status.isComplete())//<==컴플렛=끝났다는것을의미.
			//다썻니 물어보고 컴플릿이아니라면 컴플릿 해주세요.
			status.setComplete();
		return "redirect:/";
		
	}
	
	
	@GetMapping("/memberEnroll.do")
	public void memberEnroll() {
		// /WEB-INF/views/member/memberEnroll.jsp 로 자동포워딩됨.
		// DefaultRequestToViewNameTranslator빈이 요청주소에서 viewName을 유추함.
	}

	@PostMapping("/memberEnroll.do")
	public String memberEnroll(Member member, RedirectAttributes redirectAttr) {

		try {
			log.info("member = {}", member);
			//0. 비밀번호 암호화처리
			String rawPassword = member.getPassword();
			String encodedPassword = bcryptPasswordEncoder.encode(rawPassword);
			member.setPassword(encodedPassword);
			log.info("member(암호화처리이후) = {}", member);
			
			//1. 업무로직
			int result = memberService.insertMember(member);
			//2. 사용자피드백
			redirectAttr.addFlashAttribute("msg", "회원가입성공");
		} catch (Exception e) {
			log.error("회원가입 오류!", e);
			throw e;
		}
		return "redirect:/";
	}
	
	/**
	 * java.sql.Date, java.util.Date 필드에 값대입시
	 * 사용자 입력값이 ""인 경우, null로 처리될 수 있도록 설정
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// org.springframework.beans.propertyeditors.CustomDateEditor.CustomDateEditor(DateFormat dateFormat, boolean allowEmpty)
		PropertyEditor editor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	/**
	 * 로그인한 사용자 정보 열람하기
	 */
	@GetMapping("/memberDetail.do")
	public ModelAndView memberDetail(ModelAndView mav, @SessionAttribute(name = "loginMember") Member loginMember) {
		log.info("loginMember = {}", loginMember);
		//속성 저장
		mav.addObject("time", System.currentTimeMillis());
		//viewName 설정
		mav.setViewName("member/memberDetail");
		return mav;
	}
	
	
	@PostMapping("/memberUpdate.do")
	public ModelAndView memberUpdate(
								@ModelAttribute Member member,
								@ModelAttribute("loginMember") Member loginMember,
								ModelAndView mav, 
								HttpServletRequest request
							) {
		log.debug("member = {}", member);
		log.debug("loginMember = {}", loginMember);
		
		try {
			//1. 업무로직
			int result = memberService.updateMember(member);
			
			//2. 사용자 피드백 & 리다이렉트
//			mav.setViewName("redirect:/member/memberDetail.do");
			
			//리다이렉트시 자동생성되는 queryString 방지
			RedirectView view = new RedirectView(request.getContextPath() + "/member/memberDetail.do");
			view.setExposeModelAttributes(false);
			mav.setView(view);
			
			
			//ModelAndView와 RedirectAttributes 충돌시 FlashMap을 직접 사용
			FlashMap flashMap = RequestContextUtils.getOutputFlashMap(request);
			flashMap.put("msg", "사용자 정보 수정 성공!!!!!!");
//			redirectAttr.addFlashAttribute("msg", "사용자 정보 수정 성공!");
			
		} catch (Exception e) {
			log.error("사용자 정보 수정 오류!", e);
			throw e;
		}
		return mav;
	}
	
	
	
}
	
	
	
	
