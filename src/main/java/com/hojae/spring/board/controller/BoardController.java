package com.hojae.spring.board.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hojae.spring.board.model.service.BoardService;
import com.hojae.spring.board.model.vo.Board;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {

	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/board/selectBoardList.do")
	public String board(Model model) {
		
		log.info("board/selectBoardList.do !호출성공");
		List<Board> list= boardService.selectBoardList();
		model.addAttribute("list",list);
		return "board/selectBoardList";
		
	}
	
	
	
//	@Autowired
//	private BoardService boardService;
//
//	@RequestMapping("/board/selectBoardList.do")
//	public String board(Model model) {
//		
//		log.info("board/selectBoardList.do!!호출!");
//		List<Board> list = boardService.selectBoardList();
//		
//		model.addAttribute("list", list);
//		return "board/selectBoardList";
//	}


	@RequestMapping("/board/selectOne.do")
	public void selectOne(@RequestParam int no) {
		log.info("board/selectOne호출!넘어온값=" + no);
		log.info("");
		Board board = boardService.selectOne(no);
		log.info("\nboard = {}", board);

	}

	@RequestMapping("/board/insertBoard.do")
	public String insertBoard(Board board, RedirectAttributes redirectAttr) {
		log.info("board = {}", board);
		
		//1. db에 insert
		int result = boardService.insertBoard(board);
		//2. 새로 발급된 pk 출력
		log.info("=======================");
		log.info("insert 이후 board = {}", board);
		log.info("insert 이후 result = {}", result);
		return "redirect:/board/selectOne.do?no=" + board.getNo();
	}
	//인서트 보드
	
	@RequestMapping("/board/updateBoard.do")
	public String updateBoard(Board board, RedirectAttributes redirectAttr) {
		log.info("board = {}", board);
		
		
		int result = boardService.updateBoard(board);
		
		
		log.info("=======================");
		log.info("update 이후 board = {}", board);
		log.info("update 이후 result = {}", result);
		return "redirect:/board/selectOne.do?no=" + board.getNo();
	}
	//업데이트보드
	
	
	

	
	
	
	@RequestMapping("/board/deleteBoard.do")
	public String deleteBoard(Board board, RedirectAttributes redirectAttr) {
		log.info("board = {}", board);
		
		
		int result = boardService.deleteBoard(board);
		
		
		log.info("=======================");
		log.info("update 이후 board = {}", board);
		log.info("update 이후 result = {}", result);
		return "redirect:/board/selectOne.do?no=" + board.getNo();
	}
	//딜리트완성
	
//	@GetMapping("/selectBoardList.do")
//	public String boardList(
//				@RequestParam(required = true, defaultValue = "1") int cpage,
//				HttpServletRequest request,
//				Model model
//			) {
//		try {
//			log.debug("cpage = {}", cpage);
//			final int limit = 10;
//			final int offset = (cpage - 1) * limit;
//			Map<String, Object> param = new HashMap<>();
//			param.put("limit", limit);
//			param.put("offset", offset);
//			//1.업무로직 : content영역 - Rowbounds
//			List list = (List) boardService.selectBoardList(param);
//			
//			String url = request.getRequestURI();
//			
//			//2. jsp에 위임
//			model.addAttribute("list", list);
//		} catch(Exception e) {
//			log.error("게시글 조회 오류!", e);
//			throw e;
//		}
//		return "board/selectBoardList";
//	}
	
	
	
	
}

