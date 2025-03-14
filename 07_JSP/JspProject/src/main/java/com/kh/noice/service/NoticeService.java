package com.kh.noice.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.vo.PageInfo;
import com.kh.noice.model.dao.NoticeDao;
import com.kh.noice.model.vo.Notice;

public class NoticeService {
	
	public int selectListCount(){
		Connection conn = getConnection();
		int result = new NoticeDao().selectListCount(conn);
		
		close(conn);
		return result;
	}
	
	public ArrayList<Notice> selectList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDao().selectList(conn, pi);
		
		close(conn);
		return list;
	}

}
