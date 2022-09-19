package com.ssafy.board.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.board.model.BoardDto;
import com.ssafy.util.DBUtil;

public class BoardDaoImpl implements BoardDao {

	private static BoardDao boardDao = new BoardDaoImpl();
	private DBUtil dbUtil;
	
	private BoardDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}

	public static BoardDao getBoardDao() {
		return boardDao;
	}
	
	@Override
	public int writeArticle(BoardDto boardDto) throws SQLException {
		return 0;
	}

	@Override
	public List<BoardDto> listArticle(Map<String, String> map) throws SQLException {
		return null;
	}

	@Override
	public int totalArticleCount(Map<String, String> map) throws SQLException {
		return 0;
	}

	@Override
	public BoardDto getArticle(int articleNo) throws SQLException {
		return null;
	}

	@Override
	public void updateHit(int articleNo) throws SQLException {
		
	}

	@Override
	public void modifyArticle(BoardDto boardDto) throws SQLException {
		
	}

	@Override
	public void deleteArticle(int articleNo) throws SQLException {
		
	}

}
