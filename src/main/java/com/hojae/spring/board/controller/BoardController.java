package com.hojae.spring.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String board() {
		log.info("board/selectBoardList.do!!호출!");

		return "board/selectBoardList";
	}

	@Autowired
	private BoardService selectOne;

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
	
	
	

	
	//딜리트는
}

