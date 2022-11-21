package com.hrd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrd.DAO.MemberDAO;
import com.hrd.VO.MemberVO;

/**
 * Servlet implementation class joinAction
 */
@WebServlet("/joinAction")
public class joinAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public joinAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		MemberDAO mdao= new MemberDAO();
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html; charset=UTF-8");

		String custno=(String) request.getParameter("custno");
		String custname=(String) request.getParameter("custname");
		String phone=(String) request.getParameter("phone");
		String address=(String) request.getParameter("address");
		String joindate=(String) request.getParameter("joindate");
		String grade=(String) request.getParameter("grade");
		String city=(String) request.getParameter("city");
		
		System.out.println(custname+"/"+phone+"/"+address+"/"+joindate+"/"+grade+city);//È®ÀÎ¿ë
		
		MemberVO mvo=new MemberVO();
		mvo.setCustno(Integer.parseInt(custno));
		mvo.setCustname(custname);
		mvo.setCity(city);
		mvo.setAddress(address);
		mvo.setGrade(grade);
		mvo.setPhone(phone);
		mvo.setJoindate(joindate);
		
		
		mdao.insert(mvo);
		response.sendRedirect("Index");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
