package filter;

import java.io.IOException;
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

public class IpFilter implements Filter {

	private FilterConfig config;
    
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		ServletContext context = config.getServletContext();
        Map<String, Integer> ipMap = (Map<String, Integer>) context.getAttribute("ipMap");
        String ip = request.getRemoteAddr();
        if(ipMap.containsKey(ip)){
            Integer count = ipMap.get(ip);
            ipMap.put(ip,count+1);
        }else{
            ipMap.put(ip,1);
        }
        context.setAttribute("ipMap", ipMap);
        chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		this.config = arg0;
	}

}
