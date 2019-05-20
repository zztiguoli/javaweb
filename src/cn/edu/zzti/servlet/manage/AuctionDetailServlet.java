package cn.edu.zzti.servlet.manage;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zzti.dao.AuctionDAO;
import cn.edu.zzti.entity.AuctionDO;
import cn.edu.zzti.util.DAOFactory;
import cn.edu.zzti.util.PathConstence;

/**
 * Servlet implementation class AuctionDetailServlet
 */
@WebServlet(name = "AuctionDetailServlet",urlPatterns = { PathConstence.M_SERVLET_BASE+"/AuctionDetailServlet"})
public class AuctionDetailServlet extends HttpServlet {
	 AuctionDAO auctionDAO =  (AuctionDAO) DAOFactory.getDAO(DAOFactory.AUCTION_DAO_CLASS_NAME);
	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        req.setCharacterEncoding("utf-8");
	        resp.setContentType("text/html;charset=utf-8");
	        String id = req.getParameter("id");
	       
	        AuctionDO auctionDO = null;
			try {
				auctionDO = auctionDAO.getAuction(id);
				req.setAttribute("auctionDO", auctionDO);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       req.getRequestDispatcher(PathConstence.JSP_MANAGE_BASE+"/auction/auctionDetail.jsp").forward(req, resp);
	     //   resp.sendRedirect(this.getServletContext().getContextPath()+"/auctionJSTL/auctionDetail.jsp");

	    }

	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        doGet(req, resp);
	    }

}
