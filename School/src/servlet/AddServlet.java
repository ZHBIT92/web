package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;

import entity.Student;

/**
 * 控制层 -添加 逻辑处理
  @author DY1101shaoyuxian
 * 
 */
public class AddServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Student(stId,stName,stSex,stAge,stTel,stDept,stAddress)
		response.setContentType("text/html;charset=utf-8");//解决的是servlet页面显示的乱码 
		request.setCharacterEncoding("utf-8");//解决post方式参数传递的参数乱码  
		
		String stName = request.getParameter("stName");
		String stSex = request.getParameter("stSex");
		String stAge = request.getParameter("stAge");
		Long stTel = Long.parseLong(request.getParameter("stTel"));
		String stDept = request.getParameter("stDept");
		String stAddress = request.getParameter("stAddress");
		Student stu = new Student(stName, stSex, stAge, stTel, stDept,
				stAddress);
		System.out.println("%s"+stu);
		StudentDAO studao = new StudentDAO();
		boolean flag = studao.addStudent(stu);
		
		if (flag && !(stTel == null) && !"".equals(stTel)) {
			request.setAttribute("msg", "添加成功!!");
			request.getRequestDispatcher("main.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("main.jsp").forward(request,
					response);
			System.out.println("添加失败!!");
		}

	}

}
