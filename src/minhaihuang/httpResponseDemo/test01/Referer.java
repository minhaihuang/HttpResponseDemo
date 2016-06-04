package minhaihuang.httpResponseDemo.test01;
/**
 * 测试防盗链
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Referer extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置相应的编码格式
		response.setHeader("Content-type", "text/plain;charset=utf-8");
		//获得有关请求的链接的头信息
		String refer=request.getHeader("Referer");
		
		//如果为空，则说明已经盗链
		if(refer==null){
			response.getWriter().write("盗链了");
			return;
		}
		//如果不为空，看看链接是否是本网站的链接
		//获取网站名称
		String contextPath=request.getContextPath();
		System.out.println(contextPath);///HttpResponseDemo
		if(refer.contains(contextPath)){
			//跳转到资源页面
			request.getRequestDispatcher("/source.html").forward(request, response);
		}else{
			response.getWriter().write("盗链了");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
