package cn.edu.zzti.servlet.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zzti.dao.PersonalDAO;
import cn.edu.zzti.entity.PersonalInfoDO;
import cn.edu.zzti.entity.UserDO;
import cn.edu.zzti.util.DAOFactory;
import cn.edu.zzti.util.PathConstence;

/**
 * Servlet implementation class GetPsersonalServlet
 */
@WebServlet(name="GetPsersonalServlet",urlPatterns = {PathConstence.W_SERVLET_BASE+"/GetPsersonalServlet"})
public class GetPsersonalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PersonalDAO personalDAO = (PersonalDAO) DAOFactory.getDAO(DAOFactory.PERSONAL_DAO_CLASS_NAME);
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
		UserDO u= null;
		if(request.getSession().getAttribute("user")!=null){
			u = (UserDO)request.getSession().getAttribute("user");
			try {
				PersonalInfoDO personal = personalDAO.getPersonalInfo(u.getUsername());
				request.setAttribute("personalInfo", personal);
			} catch (Exception e) {
				// TODO: handle exception
			}
			request.getRequestDispatcher( PathConstence.JSP_WEB_BASE+"/personal/personalInfo.jsp").forward(request, response);
		}else{
			response.sendRedirect(request.getContextPath() + PathConstence.JSP_WEB_BASE+"/login.jsp");
		}
	}

}
