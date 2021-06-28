package com.hojae.spring.board.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hojae.spring.board.model.vo.Board;


@Repository
public interface BoardDao {

	List<Board> selectBoardList();
	
}
