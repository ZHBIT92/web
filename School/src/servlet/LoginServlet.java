package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;
import entity.Users;
import util.StringUtil;

public class LoginServlet extends HttpServlet {
	
	
	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");//�������servletҳ����ʾ������ 
		request.setCharacterEncoding("utf-8");//���post��ʽ�������ݵĲ������� 	
		HttpSession session=request.getSession(); //��servlet��ʹ��sessionҪ�ض���
		
		String username=request.getParameter("username").trim();//��ȡusername��ȥ���ո�
		String password=request.getParameter("password").trim();//��ȡpassword��ȥ���ո�
		String imageValue=request.getParameter("imageValue");//��ȡ�û��������֤��	     
		String picCode=(String)session.getAttribute("picCode"); //��ȡ���ɺ�洢��session�е���֤��	
		imageValue = imageValue.toUpperCase();//�����е�Ӣ���ַ�ת��Ϊ��д��ĸ
		
		if(StringUtil.isEmpty(username)||StringUtil.isEmpty(password)){
			response.sendRedirect("../login.jsp");
			return;
		 }  
		if(StringUtil.isEmpty(imageValue)){
			request.setAttribute("error", "��������֤�룡");
			response.sendRedirect("../login.jsp");
			return;
		}else if(!imageValue.equals(picCode)){
			request.setAttribute("error", "��֤�����");
			request.getRequestDispatcher("../login.jsp").forward(request,response);
			return;
		}
		
		//��֤
		Users user=new Users(username,password);
		//��Ʒҵ���߼���Ķ���
		UsersDAO usersdao = new UsersDAO();		
		if(usersdao.usersLogin(user))
		{
		  session.setAttribute("username", username);
		  //response.sendRedirect(".");
		  response.sendRedirect("../main.jsp");
		}
		else
		{
		  request.setAttribute("error", "�û������������!");
		  response.sendRedirect("../login_failure.jsp");
		}				
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
