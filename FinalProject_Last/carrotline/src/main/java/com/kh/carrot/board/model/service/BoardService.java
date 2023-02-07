package com.kh.carrot.board.model.service;

import java.util.ArrayList;

import com.kh.carrot.board.model.vo.Board;

public interface BoardService {
	
	int insertBoard(Board b);
	ArrayList<Board> selectList();
	int increaseCount(int boardNo);
	Board selectBoard(int boardNo);
	

}
