package cn.edu.zzti.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zzti.dao.UserDAO;
import cn.edu.zzti.dao.impl.constance.UserDAOImplConstance;
import cn.edu.zzti.entity.User;
@WebServlet("/servlet/LoginServlet")
public class LoginServlet extends HttpServlet {

	UserDAO userDAO = new UserDAOImplConstance();
	public String checkLogin(User user){
		String errorInfo=null;
		if(user.getUsername()==null||"".equals(user.getUsername().trim())
				||user.getPassword()==null||"".equals(user.getPassword().trim())){
			errorInfo = "用户名或者密码不能为空";
		}else if(userDAO.findUser(user.getUsername(), user.getPassword())==null){
			errorInfo = "用户名或者密码不正确";
			
		}
		
		return errorInfo;
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(username,password,new Date());
		String error = checkLogin(user);
		
		String targetPath = request.getContextPath();
		if(error==null){
			request.getSession().setAttribute("user", user);
			targetPath = "/IndexView";;
			request.getRequestDispatcher(targetPath).forward(request, response);
		}else{
			request.setAttribute("error", error);
			targetPath = request.getContextPath() + "/admin/LoginPageView";
			response.sendRedirect(targetPath);
		}
		
		
	}

}
