package cn.edu.zzti.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zzti.dao.AuctionDAO;
import cn.edu.zzti.dao.impl.constance.AuctionDAOImplConstance;
import cn.edu.zzti.entity.Auction;

/**
 * 商品添加控制层代码
 * Created by guoli on 17/5/14.
 */
public class AuctionAddServlet extends HttpServlet {
    AuctionDAO auctionDAO = new AuctionDAOImplConstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String title = req.getParameter("title");
        String auctionDescription = req.getParameter("auctionDescription");
        String price = req.getParameter("price");
        Auction auc = new Auction(title,auctionDescription,Float.parseFloat(price));
        auctionDAO.addAuction(auc);
        resp.sendRedirect(this.getServletContext().getContextPath()+"/auction/list");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
