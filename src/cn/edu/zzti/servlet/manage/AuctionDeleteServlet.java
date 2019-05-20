package cn.edu.zzti.servlet.manage;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zzti.dao.AuctionDAO;
import cn.edu.zzti.util.DAOFactory;
import cn.edu.zzti.util.PathConstence;

/**
 * Servlet implementation class AuctionDeleteServlet
 */
@WebServlet(name = "AuctionDeleteServlet",urlPatterns = { PathConstence.M_SERVLET_BASE+"/AuctionDeleteServlet"})
public class AuctionDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AuctionDAO auctionDAO =  (AuctionDAO) DAOFactory.getDAO(DAOFactory.AUCTION_DAO_CLASS_NAME);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String id = req.getParameter("id");
       
        try {
			auctionDAO.deleteAuction(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
        resp.sendRedirect(this.getServletContext().getContextPath()+PathConstence.M_SERVLET_BASE+"/AuctionListServlet");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
