package cn.edu.zzti.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zzti.dao.UserDAO;
import cn.edu.zzti.entity.UserDO;
import cn.edu.zzti.util.DAOFactory;
import cn.edu.zzti.util.PathConstence;

@WebServlet(name="LoginServletDemo",urlPatterns = {"/servlet/LoginServlet"})
public class LoginServlet extends HttpServlet {

	UserDAO userDAO = (UserDAO) DAOFactory.getDAO(DAOFactory.USER_DAO_CLASS_NAME);
	public String checkLogin(UserDO user) throws SQLException{
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
		UserDO user = new UserDO(username,password,new Date());
		String type = request.getParameter("type");

		String error = "";
		try {
			error = checkLogin(user);
			String targetPath = request.getContextPath();
			if(error==null){
				request.getSession().setAttribute("user", user);
				targetPath = PathConstence.M_SERVLET_BASE + "/AuctionListServlet";
				request.getRequestDispatcher(targetPath).forward(request, response);
			}else{

				targetPath += PathConstence.getBasePath(request.getParameter(type)) + "/login.jsp?error="+ URLEncoder.encode(error,"UTF-8");
				response.sendRedirect(targetPath);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
