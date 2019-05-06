package cn.edu.zzti.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zzti.dao.AuctionDAO;
import cn.edu.zzti.dao.impl.constance.AuctionDAOImplConstance;
import cn.edu.zzti.entity.Auction;

/**
 * Created by guoli on 17/5/14.
 */
@WebServlet("/AuctionListServlet")
public class AuctionListServlet extends HttpServlet {
    AuctionDAO auctionDAO = new AuctionDAOImplConstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
        List<Auction> list  = auctionDAO.getAll();
        req.setAttribute("auctionList",list);
        req.getRequestDispatcher("/AuctionListView").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
