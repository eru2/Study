package com.kh.mybatis.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.dao.BoardDao;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.PageInfo;
import com.kh.mybatis.common.Template;

public class BoardServiceImpl implements BoardService{

	private BoardDao bDao = new BoardDao();
	
	@Override
	public int selectListCount() {
		SqlSession sqlSession = Template.getSqlSession();
		int listCount = bDao.selectListCount(sqlSession);
		
		sqlSession.close();
		
		return listCount;
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = bDao.selectList(sqlSession, pi);

		sqlSession.close();
		
		return list;
	}

	public int selectSearchCount(HashMap<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		int selectSearchCount = bDao.selectSearchCount(sqlSession, map);
		
		sqlSession.close();
		return selectSearchCount;
	}

	@Override
	public ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = bDao.selectSearchList(sqlSession, map, pi);
		
		sqlSession.close();
		return list;
	}

	@Override
	public int increaseCount(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		int increaseCount = bDao.increaseCount(sqlSession, boardNo);
		
		sqlSession.close();
		return increaseCount;
	}

	@Override
	public Board selectBoard(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		Board selectBoard = bDao.selectBoard(sqlSession, boardNo);
		
		sqlSession.close();
		return selectBoard;
	}

	@Override
	public int insertReply(Reply r) {
		SqlSession sqlSession = Template.getSqlSession();
		int insertReply = bDao.insertReply(sqlSession, r);
		
		sqlSession.close();
		return insertReply;
	}

	@Override
	public ArrayList<Reply> selectReplyList(int boardNo) {
		// TODO Auto-generated method stub
		return null;
	}

}