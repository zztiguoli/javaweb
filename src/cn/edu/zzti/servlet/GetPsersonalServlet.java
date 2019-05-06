package cn.edu.zzti.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zzti.dao.PersonalDAO;
import cn.edu.zzti.dao.impl.constance.PersonalDAOImplConstance;
import cn.edu.zzti.entity.PersonalInfo;
import cn.edu.zzti.entity.User;

/**
 * Servlet implementation class GetPsersonalServlet
 */
@WebServlet("/GetPsersonalServlet")
public class GetPsersonalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PersonalDAO personalDAO = new PersonalDAOImplConstance();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		User u= null;
		if(request.getSession().getAttribute("user")!=null){
			u = (User)request.getSession().getAttribute("user");
			PersonalInfo personal = personalDAO.getPersonalInfo(u.getUsername());
			request.setAttribute("personalInfo", personal);
			request.getRequestDispatcher( "/PersonalInfoView").forward(request, response);
		}else{
			response.sendRedirect(request.getContextPath() + "/LoginPageView");
		}
	}

}
