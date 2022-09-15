package com.ssafy.hello;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifeCycleTest")
public class LifeCycleTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LifeCycleTest() {
        super();
        System.out.println("객체 생성");
    }
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
        System.out.println("객체 제거");
	}


	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
        System.out.println("객체 초기화");
	}

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("클라이언트 요청 서비스");
    }





}
