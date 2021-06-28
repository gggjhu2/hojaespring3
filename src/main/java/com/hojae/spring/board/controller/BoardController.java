package com.hojae.spring.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


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
		log.info("board/selectBoardList.do!!여ㅛ청");
		
		List<Board>list=boardService.selectBoardList(); 
		
		return "board/selectBoardList";
	
}
}
