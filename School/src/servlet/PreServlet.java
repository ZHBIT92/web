package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StudentDAO;
import dao.UsersDAO;
import entity.Student;
import entity.Users;

/**
 * �߼�����ҳ����ת
 * @author DY1101shaoyuxian
 * 
 */
public class PreServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");//�������servletҳ����ʾ������ 
		request.setCharacterEncoding("utf-8");//���post��ʽ�������ݵĲ�������  
		String method = (String) request.getParameter("method");
		if ("studentAdd".equals(method)) {
			studentAdd(request, response);
		} else if ("updateStudent".equals(method)) {
			updateStudent(request, response);
		}else if("preupdatetepwd".equals(method)){
			preupdatetepwd(request, response);
		}else if(method==null){
			updatetepwd(request, response);
		}
	}
	/**
	 * ���ѧ������Ϣǰ-ʵ��ҳ����ת
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void studentAdd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String mainPage = "studentAdd.jsp";	
		request.setAttribute("mainPage", mainPage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * ����ѧ������Ϣǰ-�Ȳ�ѯ���û�����Ϣ����ʵ��ҳ����ת
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateStudent(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		StudentDAO studao = new StudentDAO();
		int ids = Integer.parseInt(id);
		Student student = studao.findStudentByid(ids);
		request.setAttribute("student", student);
		String mainPage = "studentUpdate.jsp";
		request.setAttribute("mainPage", mainPage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * ���Ĺ���Ա����-ʵ��ҳ����ת
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void preupdatetepwd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String mainPage = "updatepwd.jsp";
		request.setAttribute("mainPage", mainPage);
		response.setContentType("text/html;charset=utf-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * ���Ĺ���Ա����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updatetepwd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession();
		 String username=(String)session.getAttribute("username");
		 String repassword=request.getParameter("repassword");
		 Users user=new Users(username,repassword);
		 UsersDAO userdao=new UsersDAO();
		 int a=userdao.updateUserPassWord(user);
		 if(a!=0){
			 String mainPage = "updatepwdSuccess.jsp";
			 request.setAttribute("mainPage", mainPage);
		 }else{
			 request.setAttribute("error", "����ʧ��");
		 }
		    RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);
	}
	
	
}
