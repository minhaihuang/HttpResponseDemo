package minhaihuang.httpResponseDemo.test01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取文件路径。
		String filePath=getServletContext().getRealPath("/1.jpg");
		
		File file=new File(filePath);
		//System.out.println(file.exists());
		//设置文件名称
		response.setHeader("fileName", "1.jpg");
		response.setContentLength((int) file.length());
		
		//往客户端发送数据
		OutputStream out=response.getOutputStream();
		InputStream in=new FileInputStream(file);
		
		int len=0;
		byte[] b=new byte[1024];
		while(-1!=(len=in.read(b))){
			out.write(b,0,len);
			String s=new String(b,0,len);
			//System.out.println(s);
		}
		
		out.close();
		in.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
