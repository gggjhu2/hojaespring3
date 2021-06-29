package com.hojae.spring.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hojae.spring.board.model.vo.Board;

@Repository
public class BoardDaoImpl implements BoardDao {

	
	
	@Autowired
	private SqlSessionTemplate session;

	@Override
	public List<Board> selectBoardList() {
		return session.selectList("board.selectBoardList");
	}

	
	
	@Override
	public  Board selectOne(int no) {
		return session.selectOne("board.selectOne", no);
	

}



	@Override
	public int insertBoard(Board board) {
		return session.insert("board.insertBoard", board);
	}



	
	@Override
	public int updateBoard(Board board) {
		return session.update("board.updateBoard", board);
	}



	


}
	
