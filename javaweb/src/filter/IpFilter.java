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
		//��ȡServletConfig
        ServletContext sc = config.getServletContext();
        //��ȡServletContext�е�map
        Map<String,Integer> map=(Map<String, Integer>) sc.getAttribute("map");
        //���map�����ڣ�˵�����ǵ�һ�α�����
        if(map==null){
            //����map
            map=new LinkedHashMap<String,Integer>();
        }
        //��ȡ����ip
        String ip = request.getRemoteAddr();
        //�ж�map���Ƿ�������ip
        if(map.containsKey(ip)){
            //���ip���ڣ�˵�����IP�Ѿ����ʹ���վ
            // ��ȡ���ʴ���
            Integer count = map.get(ip);
            //�ѷ��ʴ���+1
            count++;
            //���µķ��ʴ��������ȥ
            map.put(ip, count);
        }else{
            //��Ϊ���IP�ǵ�һ�η��ʣ�����ֵΪ1
            map.put(ip, 1);
        }
        //��map����ServletContext��
    sc.setAttribute("map", map);
    //����
    chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;
	}

}
