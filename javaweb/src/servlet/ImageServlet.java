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
		response.setContentType("text/html;charset=utf-8");//�������servletҳ����ʾ������ 
		request.setCharacterEncoding("utf-8");//���post��ʽ�������ݵĲ������� 	
		
		//����һ����68����22�ľ���
		BufferedImage bi=new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
		//����һ�����������ͼƬ�����������ֱ�Ϊ ��������ɫ���͡�
		Graphics g=bi.getGraphics();
		Color c=new Color(200, 150, 255);
		g.setColor(c);//����ͼ����ɫ
		g.fillRect(0, 0, 68, 22);//������0��0λ�û��ƿ�
		
		char[] ch="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		Random r=new Random();
		int len=ch.length,index;
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<4;i++){
			index=r.nextInt(len);
			g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)));//�����ַ���ɫ
			g.drawString(ch[index]+"", (i*15)+3, 18);//���ַ����Ƶ�ͼƬ�ϣ�(i*15)+3��ʾ�ַ���СΪ15�����Ϊ3���߶�Ϊ18
			sb.append(ch[index]);//�����ַ�
		}
		request.getSession().setAttribute("picCode", sb.toString());//���ַ����浽session��
		try {
			ImageIO.write(bi, "JPG", response.getOutputStream());//�������
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
