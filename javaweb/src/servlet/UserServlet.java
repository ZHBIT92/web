package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.UsersDAO;
import entity.Users;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UsersDAO dao=new UsersDAO();
		List list = dao.getAllItems();
		/*System.out.println(str);*/
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("code", 0);
		data.put("msg", "");
		data.put("count", list.size());
		data.put("data", list);
		
		Gson gson = new Gson();
		/*System.out.println(gson.toJson(data));*/
		
		response.setContentType("text/json");
		response.getWriter().write(gson.toJson(data));
		response.getWriter().flush();
		response.getWriter().close();
		
	}
}
