/**
 * @Copyright (c) 成都大学信息科学与技术学院
 * 服务外包与创意大赛
 */
package cn.cdu.edu.TQC.bems.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName: UrlFilter 说明： url过滤，只允许登陆后才能进入后台页面
 * @Author LPM 【email:shouli1990@gmail.com 】
 * @Version V1.0 2012-7-5 下午9:38:34
 * 
 */
public class UrlFilter implements Filter {
    private String loginPage = "login.html";
    private FilterConfig filterConfig;

    @Override
    public void destroy() {
	// TODO Auto-generated method stu
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
	    FilterChain chain) throws IOException, ServletException {
	// 获取当前页面请求\
	HttpServletRequest req = (HttpServletRequest) request;
	HttpServletResponse res = (HttpServletResponse) response;

	String uri = req.getRequestURL().toString();
	// 判断ssesion中是否有admin参数,以此来判断用户是否登录
	HttpSession session = req.getSession();
	// 访问登录页面或者已经登录
	if (uri.endsWith(loginPage) || uri.endsWith("login")
		|| session.getAttribute("user") != null) {
	    chain.doFilter(req, res);
	    return;

	} else {
	    //重定向
	    res.sendRedirect("../"+loginPage);
	}
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
	// 获取过滤器配置参数
	filterConfig = config;
	if (filterConfig.getInitParameter("loginPage") != null) {
	    loginPage = filterConfig.getInitParameter("loginPage");
	}
    }

}
