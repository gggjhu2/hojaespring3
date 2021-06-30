package com.hojae.spring.board.model.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.hojae.spring.board.model.vo.Board;


@Repository
public interface BoardDao {

	List<Board> selectBoardList();
	
	Board selectOne(int no);

	int insertBoard(Board board);

	int updateBoard(Board board);

	int deleteBoard(Board board);

	int boardEnroll(Board board);



}
