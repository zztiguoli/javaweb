package cn.edu.zzti.servlet.manage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
 * Created by guoli on 17/5/14.
 */
@WebServlet(name = "AuctionListServlet",urlPatterns = { PathConstence.M_SERVLET_BASE+"/AuctionListServlet"})
public class AuctionListServlet extends HttpServlet {
    AuctionDAO auctionDAO =  (AuctionDAO) DAOFactory.getDAO(DAOFactory.AUCTION_DAO_CLASS_NAME);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        List<AuctionDO> list = new ArrayList<AuctionDO>();
		try {
			list = auctionDAO.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        req.setAttribute("auctionList",list);
        req.getRequestDispatcher(PathConstence.JSP_MANAGE_BASE+"/auction/auctionList.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
