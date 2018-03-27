package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDAO;

import entity.Users;

/**
 * 控制层 -添加 逻辑处理
  @author DY1101shaoyuxian
 * 
 */
public class AddUserServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Student(stId,stName,stSex,stAge,stTel,stDept,stAddress)
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int power = Integer.valueOf(request.getParameter("power"));
		String sex = request.getParameter("sex");
		String text = request.getParameter("text");
		Users user = new Users(username, password, power, sex, text);
		
		/*System.out.println("%s"+user);*/
		UsersDAO userdao = new UsersDAO();
		boolean flag = userdao.addUser(user);
		
		if (flag) {
			request.setAttribute("msg", "添加成功!!");
			request.getRequestDispatcher("user.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("form.jsp").forward(request,
					response);
			System.out.println("添加失败!!");
		}

	}

}
