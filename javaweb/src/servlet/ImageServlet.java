package servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Image")
public class ImageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ImageServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");//解决的是servlet页面显示的乱码 
		request.setCharacterEncoding("utf-8");//解决post方式参数传递的参数乱码 	
		
		//绘制一个长68，宽22的矩形
		BufferedImage bi=new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
		//建立一个缓冲区存放图片，三个参数分别为 长，宽，颜色类型。
		Graphics g=bi.getGraphics();
		Color c=new Color(200, 150, 255);
		g.setColor(c);//设置图形颜色
		g.fillRect(0, 0, 68, 22);//在坐标0，0位置绘制框
		
		char[] ch="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		Random r=new Random();
		int len=ch.length,index;
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<4;i++){
			index=r.nextInt(len);
			g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)));//设置字符颜色
			g.drawString(ch[index]+"", (i*15)+3, 18);//将字符绘制到图片上；(i*15)+3表示字符大小为15，间隔为3；高度为18
			sb.append(ch[index]);//保存字符
		}
		request.getSession().setAttribute("picCode", sb.toString());//将字符保存到session中
		try {
			ImageIO.write(bi, "JPG", response.getOutputStream());//进行输出
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
