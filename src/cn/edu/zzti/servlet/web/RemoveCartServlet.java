package cn.edu.zzti.servlet.web;

import cn.edu.zzti.dao.TemporaryCartDAO;
import cn.edu.zzti.entity.UserDO;
import cn.edu.zzti.util.DAOFactory;
import cn.edu.zzti.util.PathConstence;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by guoli on 17/7/11.
 */
@WebServlet(name = "RemoveCartServlet",urlPatterns = {PathConstence.W_SERVLET_BASE+"/RemoveCartServlet"})
public class RemoveCartServlet extends HttpServlet {
    private TemporaryCartDAO temporaryCartDAO = (TemporaryCartDAO) DAOFactory.getDAO(DAOFactory.TEMPORARY_CART_DAO_CLASS_NAME);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aucId = request.getParameter("id");
        this.temporaryCartDAO.removeFromCart(((UserDO)request.getSession().getAttribute("user")).getUsername(),aucId);
        response.sendRedirect(request.getContextPath()+PathConstence.W_SERVLET_BASE+"/CartListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
