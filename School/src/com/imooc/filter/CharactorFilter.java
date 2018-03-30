package com.imooc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharactorFilter implements Filter {
	
	String encoding=null;
	
	public void destroy() {
		// TODO Auto-generated method stub
		encoding=null;
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		 if(encoding!=null){
		        //设置request字符编码
			 arg0.setCharacterEncoding(encoding);
		         //设置response字符编码
			 arg1.setContentType("text/html;charset="+encoding);
		        }
		     //传递给下一个过滤器
		 arg2.doFilter(arg0, arg1);

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		encoding=arg0.getInitParameter("encoding");
	}

}
