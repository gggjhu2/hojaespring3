package com.hojae.spring.board.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hojae.spring.board.model.dao.BoardDao;
import com.hojae.spring.board.model.vo.Attachment;
import com.hojae.spring.board.model.vo.Board;
import com.hojae.spring.board.model.vo.BoardExt;

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
	public int updateBoard(Board board) {
		// TODO Auto-generated method stub
		return boardDao.updateBoard(board);
	}

	@Override
	public int deleteBoard(Board board) {
		// TODO Auto-generated method stub
		return boardDao.deleteBoard(board);
	}

	@Override
	public int boardEnroll(Board board) {
		// TODO Auto-generated method stub
		return boardDao.boardEnroll(board);
	}

	@Override
	public int insertAttachment(Attachment attach) {
		return boardDao.insertAttachment(attach);
	}

	@Override
	public int insertBoard(BoardExt board) {
		int result = 0; 
		//1.board 등록
		//dml실행후 리턴된 후 리턴된 정수는 몇행인지 나타내느것이다. =>인서트후 1이나오면 1행이 들어갔다는뜻이고 0이면 변동있는 행이없다는것
		result = boardDao.insertBoard(board);
		//Logger.debug("board = {}", board);  ==>이거왜 에러나는지모르겠다.주석
		//2.attachment 등록
		if(board.getAttachList().size() > 0) {
			for(Attachment attach : board.getAttachList()) {
				attach.setBoardNo(board.getNo()); // board no fk 세팅
				result = insertAttachment(attach);
			}
		}
				//행
		return result; 
	}
	
}
