package com.ssafy.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.member.model.service.MemberService;
import com.ssafy.member.model.service.MemberServiceImpl;

@WebServlet("/user")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberService memberService;
    @Override
    public void init() throws ServletException {
    	super.init();
    	memberService =MemberServiceImpl.getMemberService();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act= request.getParameter("act");
		String path = "/index.jsp";
		if ("mvjoin".equals(act)) {
			path = "/user/join.jsp";
			redirect(request,response,path);
		}
		else if("idcheck".equals(act)) {
			int cnt = idCheck(request,response);
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println(cnt);
		}
		else {
			redirect(request,response,path);
		}
	}

	private int idCheck(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userid");
		int count;
		try {
			count = memberService.idCheck(userId);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 500;
	}

	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		System.out.println(request.getContextPath()+path);
		response.sendRedirect(request.getContextPath()+path);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
