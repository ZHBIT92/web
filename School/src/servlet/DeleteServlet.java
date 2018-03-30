package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;

/**
 * 控制层-删除业务逻辑处理 
 * @author DY1101shaoyuxian
 *
 */
public class DeleteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentDAO studao = new StudentDAO();
	
		String id=request.getParameter("id");
		int d=Integer.parseInt(id);
		boolean flag=studao.delStudent(d);
		//如果删除成功，返回到displaystudent.jsp页面，如果不成功，给用户提示信息
		if(flag){
			RequestDispatcher dispatch=request.getRequestDispatcher("showAllStudents");
			dispatch.forward(request, response);
		}else{
			 System.out.println("删除失敗!!");
		}
	}

}
