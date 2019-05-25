package cn.edu.zzti.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zzti.dao.AuctionDAO;
import cn.edu.zzti.dao.impl.constance.AuctionDAOImpl;
import cn.edu.zzti.entity.AuctionDO;
import cn.edu.zzti.util.DAOFactory;
import cn.edu.zzti.util.PathConstence;

/**
 * Created by guoli on 17/5/14.
 * 当前Servlet是从数据访问层获取所有商品数据
 * @return 会将所有的商品（List<AuctionDO>）存放到request作用域中
 * param: type 要求请求该功能时必须传入参数type：1代表响应前台页面，2代表响应后台页面
 */
@WebServlet(name="AuctionListServletDemo",urlPatterns = {"/servlet/AuctionListServlet"})
public class AuctionListServlet extends HttpServlet {
    AuctionDAO auctionDAO = (AuctionDAO) DAOFactory.getDAO(DAOFactory.AUCTION_DAO_CLASS_NAME);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<AuctionDO> list =null;
		try {
			list = auctionDAO.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        req.setAttribute("auctionList",list);
        String uri = PathConstence.getBasePath(req.getParameter("type"));//获取响应的跟路径是前台还是后台
        req.getRequestDispatcher(uri+"/auction/auctionList.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
