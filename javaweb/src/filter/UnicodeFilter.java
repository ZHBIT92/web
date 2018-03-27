package filter;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UnicodeFilter implements Filter {

	private FilterConfig config;
    
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");//�������servletҳ����ʾ������ 
		request.setCharacterEncoding("utf-8");//���post��ʽ�������ݵĲ�������  
        //����
        chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;
	}

}
