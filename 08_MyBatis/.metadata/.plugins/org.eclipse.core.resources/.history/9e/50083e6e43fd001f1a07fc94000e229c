package com.kh.mybatis.board.controller;

import java.io.IOException;

import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.board.service.BoardService;
import com.kh.mybatis.board.service.BoardServiceImpl;
import com.kh.mybatis.member.model.vo.Member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxReplyInsertController
 */
@WebServlet("/rinsert.bo")
public class AjaxReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReplyInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService boardService = new BoardServiceImpl();
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String replyContent = request.getParameter("content");
		int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		
		Reply r = new Reply();
		r.setRefBoardNo(boardNo);
		r.setReplyContent(replyContent);
		r.setReplyWriter(userNo);
		
		int result = boardService.insertReply(r);
		
		response.getWriter().print(result);
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}