package cn.edu.zzti.util;

/**
 * Created by guoli on 2017/7/11.
 */
public class PathConstence {
	/**
	 * 后台管理页面的根目录
     * 1、/jsp/manager目录下的都是使用JSP脚本代码实现，未标签化的内容
     * 2、/taglib/manager目录下的都是标签化后的代码实现
     * 3、/jspTest/manager目录下的都是课堂上的练习代码
	 */
    public static final String JSP_MANAGE_BASE="/jspTest/manage";
    /**
     * 前端页面的根目录
     * 1、/jsp/web目录下的都是使用JSP脚本代码实现，未标签化的内容
     * 2、/taglib/web目录下的都是标签化后的代码实现
     * 3、/jspTest/web目录下的都是课堂上的练习代码
     */
    public static final String JSP_WEB_BASE="/jspTest/web";
    /**
     * 后台管理的Servlet的根目录
     * * 1、/manager 路径下的内容都是经过测试的代码，每个功能都是拆开来写的
     *   2、/servlet 路径的内容是可以进行修改的，对应的servlet的包在cn.edu.zzti.servlet下面的哪些控制类都可以进行修改，这里是前后台使用的统一的Servlet。
     */
    public static final String M_SERVLET_BASE="/servlet";
    /**
     * 前端Servlet的根目录
     * 1、/web 路径下的内容都是经过测试的代码，每个功能都是拆开来写的
     * 2、/servlet 路径的内容是可以进行修改的，对应的servlet的包在cn.edu.zzti.servlet下面的哪些控制类都可以进行修改，这里是前后台使用的统一的Servlet。
     */
    public static final String W_SERVLET_BASE="/servlet";

    /**
     *
     * @param type 要求请求该功能时必须传入参数type：1代表响应前台页面，2代表响应后台页面
     * @return
     */
    public static String getBasePath(String type){
        return "1".equals(type) ? PathConstence.JSP_WEB_BASE:PathConstence.JSP_MANAGE_BASE;
    }

}
