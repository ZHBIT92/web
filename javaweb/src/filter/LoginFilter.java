package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	private FilterConfig config;
    
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request =(HttpServletRequest) arg0;
		HttpServletResponse response =(HttpServletResponse) arg1;		
        HttpSession session = request.getSession();
        
        //排除不用过滤的页面
        String noLoginPaths = config.getInitParameter("noLoginPaths");
        request.setCharacterEncoding(config.getInitParameter("charset"));
        
        if(noLoginPaths!=null)
        {
        	String[] strArray = noLoginPaths.split(";");
        	for (int i = 0; i < strArray.length; i++) {
        		
        		//防止为空
        		if(strArray[i]==null||"".equals(strArray[i])) continue;
        		
        		if(request.getRequestURI().indexOf(strArray[i])!=-1 )
                {
                	arg2.doFilter(arg0, arg1);
                	return;
                }
			}
        }     
        
        if (session.getAttribute("loginUser")!=null) {
			arg2.doFilter(arg0, arg1);
		}
        else
		{       	
        	
			response.sendRedirect("login.jsp");
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
        config = arg0;
	}

}
