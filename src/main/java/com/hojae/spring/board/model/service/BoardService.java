package com.hojae.spring.board.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.hojae.spring.board.model.dao.BoardDao;
import com.hojae.spring.board.model.vo.Board;



@Service
public interface BoardService {

	List<Board> selectBoardList();

	Board selectOne(int no);

	int insertBoard(Board board);
	
	int updateBoard(Board board);

	int deleteBoard(Board board);




	
}
