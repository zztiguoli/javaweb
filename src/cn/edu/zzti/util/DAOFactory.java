package cn.edu.zzti.util;

import cn.edu.zzti.dao.AuctionDAO;
import cn.edu.zzti.dao.BaseDAO;
import cn.edu.zzti.dao.PersonalDAO;
import cn.edu.zzti.dao.UserDAO;
import cn.edu.zzti.dao.impl.mysql.AuctionDAOImpl;
import cn.edu.zzti.dao.impl.mysql.PersonalDAOImpl;
import cn.edu.zzti.dao.impl.mysql.UserDAOImpl;

/**
 * Created by guoli on 17/7/10.
 */
public class DAOFactory {
    public static final String AUCTION_DAO_CLASS_NAME="cn.edu.zzti.dao.impl.mysql.AuctionDAOImpl";
    public static final String PERSONAL_DAO_CLASS_NAME="cn.edu.zzti.dao.impl.mysql.PersonalDAOImpl";
    public static final String USER_DAO_CLASS_NAME="cn.edu.zzti.dao.impl.mysql.UserDAOImpl";
    public static final String TEMPORARY_CART_DAO_CLASS_NAME="cn.edu.zzti.dao.impl.constance.TemporaryCartDAOImpl";
    private DAOFactory factory = new DAOFactory();
    private DAOFactory(){}
    private static AuctionDAO auctionDAO = new AuctionDAOImpl();
    private static PersonalDAO personalDAO = new PersonalDAOImpl();
    private static UserDAO userDAO = new UserDAOImpl();
    public static BaseDAO getDAO(String className){
        if(className!=null&&!"".equals(className)){
            try {
                Class<? extends BaseDAO> clazz = (Class<? extends BaseDAO>)Class.forName(className);
                return clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
