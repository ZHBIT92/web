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

public class IpFilter implements Filter {

	private FilterConfig config;
    
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//获取ServletConfig
        ServletContext sc = config.getServletContext();
        //获取ServletContext中的map
        Map<String,Integer> map=(Map<String, Integer>) sc.getAttribute("map");
        //如果map不存在，说明这是第一次被访问
        if(map==null){
            //创建map
            map=new LinkedHashMap<String,Integer>();
        }
        //获取请求ip
        String ip = request.getRemoteAddr();
        //判断map中是否存在这个ip
        if(map.containsKey(ip)){
            //如果ip存在，说明这个IP已经访问过本站
            // 获取访问次数
            Integer count = map.get(ip);
            //把访问次数+1
            count++;
            //把新的访问次数保存回去
            map.put(ip, count);
        }else{
            //因为这个IP是第一次访问，所以值为1
            map.put(ip, 1);
        }
        //把map放入ServletContext中
    sc.setAttribute("map", map);
    //放行
    chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;
	}

}
