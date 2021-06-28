package com.hojae.spring.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hojae.spring.board.model.vo.Board;

@Service
public interface BoardService {

	List<Board> selectBoardList();

	
	
	
}
