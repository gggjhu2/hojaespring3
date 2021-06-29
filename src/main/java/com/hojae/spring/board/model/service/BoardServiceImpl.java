package com.hojae.spring.board.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.hojae.spring.board.model.dao.BoardDao;
import com.hojae.spring.board.model.vo.Board;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;

	@Override
	public List<Board> selectBoardList() {

		return boardDao.selectBoardList();
	}

	@Override
	public Board selectOne(int no) {
		return boardDao.selectOne(no);
	}

	@Override
	public int insertBoard(Board board) {
		return boardDao.insertBoard(board);
	}

	@Override
	public int updateBoard(Board board) {
		// TODO Auto-generated method stub
		return boardDao.updateBoard(board);
	}

	@Override
	public int deleteBoard(Board board) {
		// TODO Auto-generated method stub
		return boardDao.deleteBoard(board);
	}

}
