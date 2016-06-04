package minhaihuang.httpResponseDemo.downLoad;
/**
 * 测试利用浏览器下载文件,重点掌握
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BroswerDownLoadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//设置文件下载的名字
		String fileName=URLEncoder.encode("小和尚.jpg","utf-8");//为了防止文件名是中文的情况
		//以下爱的头信息是必要的，重点掌握
		response.setHeader("Content-Disposition","attachment;fileName="+fileName);
		
		//获取文件的路径
		String filePath=getServletContext().getRealPath("/1.jpg");
		
		InputStream in=new FileInputStream(new File(filePath));
		OutputStream out=response.getOutputStream();
		//把文件信息读取到浏览器
		int len=0;
		byte[] b=new byte[1024];
		while(-1!=(len=in.read(b))){
			out.write(b, 0, len);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
