package servlet;

/**
 * 控制层-查询全体学生业务逻辑
 * @author DY1101shaoyuxian
 */

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;

public class ShowAllServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");//解决的是servlet页面显示的乱码 
		request.setCharacterEncoding("utf-8");//解决post方式参数传递的参数乱码  
		
		StudentDAO studao = new StudentDAO();
		List list = studao.StSelect();
		String mainPage="displaystudent.jsp";
		request.setAttribute("list", list);
		request.setAttribute("mainPage", mainPage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		dispatcher.forward(request, response);
	}

}
