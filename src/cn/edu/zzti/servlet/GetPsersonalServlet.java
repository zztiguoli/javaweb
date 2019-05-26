package cn.edu.zzti.servlet;

import java.io.IOException;
import java.sql.SQLException;

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
@WebServlet(name="GetPersonalServletDemo",urlPatterns ={"/servlet/GetPersonalServlet"} )
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

		String uri = PathConstence.getBasePath(request.getParameter("type"));
		UserDO u= null;
		if(request.getSession().getAttribute("user")!=null){
			u = (UserDO)request.getSession().getAttribute("user");
			PersonalInfoDO personal = null;
			try {
				personal = personalDAO.getPersonalInfo(u.getUsername());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("personalInfo", personal);
			request.getRequestDispatcher( "/PersonalInfoView").forward(request, response);
		}else{
			response.sendRedirect(request.getContextPath() + request.getSession().getAttribute("sessionType")+"/login.jsp");
		}
	}

}
