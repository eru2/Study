package com.kh.mybatis.member.controller;

import java.io.IOException;

import com.kh.mybatis.member.model.vo.Member;
import com.kh.mybatis.member.service.MemberService;
import com.kh.mybatis.member.service.MemberServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/update.me")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String email = request.getParameter("email"); // "hjsbdv@nave~" || ""
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone"); // "010~~" || "" 
		String address = request.getParameter("address"); // "경기도~" || ""
		
		Member m = new Member();
		m.setUserId(userId);
		m.setEmail(email);
		m.setBirthday(birthday);
		m.setGender(gender);
		m.setPhone(phone);
		m.setAddress(address);
		
		MemberService mService = new MemberServiceImpl();
		Member updateMember = mService.updateMember(m);
		
		if(updateMember == null) {
			request.setAttribute("errorMsg", "회원 정보 수정 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", updateMember);
			response.sendRedirect(request.getContextPath() + "/myPage.me");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
