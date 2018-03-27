	package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.UsersDAO;

/**
 * ���Ʋ�-ɾ��ҵ���߼����� 
 * @author DY1101shaoyuxian
 *
 */
public class DeleteUserServlet extends HttpServlet {

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
		UsersDAO dao = new UsersDAO();
	
		String id=request.getParameter("userid");
		int d=Integer.parseInt(id);
		boolean flag=dao.delUser(d);
		
		//���ɾ���ɹ������ص�displaystudent.jspҳ�棬������ɹ������û���ʾ��Ϣ
		if(flag){
			List list = dao.getAllItems();
			/*System.out.println(str);*/
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("code", 0);
			data.put("msg", "");
			data.put("count", list.size());
			data.put("data", list);
			
			Gson gson = new Gson();
			response.setContentType("text/json");
			response.getWriter().write(gson.toJson(data));
			response.getWriter().flush();
			response.getWriter().close();
		}else{
			System.out.println("ɾ��ʧ��!!");
		}
	}

}
