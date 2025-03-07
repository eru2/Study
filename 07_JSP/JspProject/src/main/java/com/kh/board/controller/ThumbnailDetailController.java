package com.kh.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.board.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ThumbnailDetailController
 */
@WebServlet("/detail.th")
public class ThumbnailDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThumbnailDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int boardNo = Integer.parseInt(request.getParameter("bno"));

		 	BoardService bService = new BoardService();
//	        Board b = new BoardService().selectThumbnail(boardNo);
	        int result = bService.increaseCount(boardNo);
	        if(result > 0) {
	        	Board b = bService.selectBoard(boardNo);
	        	ArrayList<Attachment> list = bService.selectAttachmentList(boardNo);
	        	
	        	request.setAttribute("list", list);
	        	request.setAttribute("b", b);
	        	
	        	request.getRequestDispatcher("views/board/thumbnailDetailView.jsp").forward(request, response);
	        	
	        }
	        else {
	        	request.setAttribute("errorMsg", "사진게시글 상세 조회에 실패했습니다.");
	            request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
	        }
//	        if (b != null) {
//	            request.setAttribute("board", b);
//	            request.getRequestDispatcher("views/board/thumbnailDetailView.jsp").forward(request, response);
//	        } else {
//	            request.setAttribute("errorMsg", "게시글 상세 조회에 실패했습니다.");
//	            request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
//	        }
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
