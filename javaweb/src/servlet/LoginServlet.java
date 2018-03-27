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

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		HttpSession session=request.getSession(); //在servlet中使用session要重定义
		
		String username=request.getParameter("username").trim();//获取username并去掉空格
		String password=request.getParameter("password").trim();//获取password并去掉空格
		String imageValue=request.getParameter("imageValue");//获取用户输入的验证码	     
		String picCode=(String)session.getAttribute("picCode"); //获取生成后存储在session中的验证码	
		imageValue = imageValue.toUpperCase();//将所有的英文字符转换为大写字母
		
		if(StringUtil.isEmpty(username)||StringUtil.isEmpty(password)){
			response.sendRedirect("../web/login.jsp");
			return;
		 }  
		if(StringUtil.isEmpty(imageValue)){
			request.setAttribute("error", "请输入验证码！");
			response.sendRedirect("../web/login.jsp");
			return;
		}else if(!imageValue.equals(picCode)){
			request.setAttribute("error", "验证码错误！");
			request.getRequestDispatcher("../web/login.jsp").forward(request,response);
			return;
		}
		
		//验证
		Users user=new Users(username,password);
		//商品业务逻辑类的对象
		UsersDAO usersdao = new UsersDAO();		
		if(usersdao.usersLogin(user))
		{
		  session.setAttribute("username", username);
		  //response.sendRedirect(".");
		  response.sendRedirect("../web/main.jsp");
		}
		else
		{
		  request.setAttribute("error", "用户名或密码错误!");
		  response.sendRedirect("../web/login_failure.jsp");
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
