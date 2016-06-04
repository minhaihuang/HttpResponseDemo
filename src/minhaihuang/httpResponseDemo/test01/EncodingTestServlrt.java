package minhaihuang.httpResponseDemo.test01;
/**
 * 测试编码与解码的问题的另外一种方式。
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingTestServlrt extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		//String s="<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">哈哈哈，我响应了";
//		String s="哈哈哈，我响应了";
//		//输出到浏览器
//		//response.getWriter().write(s);
//		byte[] b=s.getBytes("utf-8");
//		response.getOutputStream().write(b);
		 String s =
				 "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">  中文信息 ";
				 byte[] data = s.getBytes("utf-8");
				 response.getOutputStream().write(data);//不能用printwriter
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
