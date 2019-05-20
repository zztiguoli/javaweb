package cn.edu.zzti.servlet.web;

import cn.edu.zzti.dao.UserDAO;
import cn.edu.zzti.entity.UserDO;
import cn.edu.zzti.util.DAOFactory;
import cn.edu.zzti.util.PathConstence;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(name="LoginServletWeb",urlPatterns = {PathConstence.W_SERVLET_BASE+"/LoginServlet"})
public class LoginServlet extends HttpServlet {

	UserDAO userDAO = (UserDAO) DAOFactory.getDAO(DAOFactory.USER_DAO_CLASS_NAME);
	public String checkLogin(UserDO userDO){
		String errorInfo=null;
		try {
			if (userDO.getUsername() == null || "".equals(userDO.getUsername().trim()) || userDO.getPassword() == null
					|| "".equals(userDO.getPassword().trim())) {
				errorInfo = "用户名或者密码不能为空";
			} else if (userDAO.findUser(userDO.getUsername(), userDO.getPassword()) == null) {
				errorInfo = "用户名或者密码不正确";

			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
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
		UserDO userDO = new UserDO(username,password,new Date());
		String error = checkLogin(userDO);
		
		String targetPath = request.getContextPath();
		if(error==null){
			request.getSession().setAttribute("user", userDO);
			targetPath = PathConstence.W_SERVLET_BASE+"/getAllAuction";
		}else{
			request.setAttribute("error", error);
			targetPath = PathConstence.JSP_WEB_BASE+"/login.jsp";
		}
		request.getRequestDispatcher(targetPath).forward(request, response);
		
	}

}
