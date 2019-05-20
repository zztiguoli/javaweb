package cn.edu.zzti.servlet.manage;

import cn.edu.zzti.dao.AuctionDAO;
import cn.edu.zzti.entity.AuctionDO;
import cn.edu.zzti.util.DAOFactory;
import cn.edu.zzti.util.PathConstence;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 商品添加控制层代码
 * Created by guoli on 17/5/14.
 */
@WebServlet(name = "AuctionAddServlet",urlPatterns = { PathConstence.M_SERVLET_BASE+"/AuctionAddServlet"})
public class AuctionAddServlet extends HttpServlet {
    AuctionDAO auctionDAO = (AuctionDAO) DAOFactory.getDAO(DAOFactory.AUCTION_DAO_CLASS_NAME);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String title = req.getParameter("title");
        String auctionDescription = req.getParameter("auctionDescription");
        String price = req.getParameter("price");
        AuctionDO auc = new AuctionDO(title,auctionDescription,Float.parseFloat(price));
        try {
			auctionDAO.addAuction(auc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        resp.sendRedirect(this.getServletContext().getContextPath()+PathConstence.M_SERVLET_BASE+"/AuctionListServlet");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
