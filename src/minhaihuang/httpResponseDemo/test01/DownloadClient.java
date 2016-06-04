package minhaihuang.httpResponseDemo.test01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 利用客户端下载服务器的数据
 * @author 黄帅哥
 *
 */
public class DownloadClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client=new Socket("localhost",80);
		
		//获取流
		OutputStream out=client.getOutputStream();
		
		//包装流
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(out));
	
		
		//请求信息,记住，GET的后面一定要有一个空格
		writer.write("GET /HttpResponseDemo/DownloadServer HTTP/1.1\n");
		writer.write("Host:localhost:80 \n");
		writer.write("\n");
		writer.flush();//刷新一下
		
		InputStream in=client.getInputStream();
		BufferedReader reader=new BufferedReader(new InputStreamReader(in));
		
		//文件名变量
		String fileName=null;
		
		//接收服务器返回信息，用一个临时文件存储
		int len=0;
		byte[] b=new byte[1024];
		String line=null;
		OutputStream os=null;
		//设置标识符，默认为false；
		boolean flag=false;
		while(null!=(line=reader.readLine())){
			//获取文件名
			if(line.contains("fileName")){
				
				int index=line.indexOf(":");
				fileName=line.substring(index+2,line.length());
				
				//设置文件输出路径
				os=new FileOutputStream("G:/1/a/"+fileName);
			}
			//当遍历到第一次的空格行时，
			//System.out.println(line);
			if(flag){//如果标识符为真，则已经跳过了请求信息，可以开始复制内容
				os.write(line.getBytes());
			}
			
			if(line.equals(" ")||line.length()==0){
				
				flag=true;
				//break;
			}
			
		}
		
		writer.close();
		in.close();
	}
}
