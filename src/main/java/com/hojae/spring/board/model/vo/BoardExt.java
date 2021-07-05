package com.hojae.spring.board.model.vo;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@NoArgsConstructor
public class BoardExt extends Board {
	
	private boolean hasAttachment;
	private List<Attachment> attachList;
	
	public BoardExt(Board board) {
		super(board.getNo(), board.getTitle(), board.getMemberId(), board.getContent(), board.getRegDate(), board.getReadCount());
	}
	
}
