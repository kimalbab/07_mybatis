package com.br.mybatis.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter(filterName="encodingFilter", urlPatterns="/*")
public class EncodingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		/*
		 * 어떠한 서블릿이 실행되기 전에 해당 필터를 거쳐가도록 등록 할 수 있음
		 * 
		 * 이때 해당 doFilter 메소드 호출이 됨 
		 * 
		 * 필터 클래스 작업이 완료되면 해당 필터클래스를 등록해야만 동작함.
		 * 1) web.xml에 등록하는 방법
		 * 	  > 해당 filter 클래스를 등록하고 어떤 서블릿이 실행되기 전에 해당 이 필터를 실행시킬건지 지정
		 * 
		 * 2) 어노테이션을 이용하는 방법
		 * 	  > 해당 filter클래스 상단에 @WebFilter 어노테이션을 이용
		 */
		System.out.println("인코딩 필터 실행됨");
		request.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response);
		// => 다음 필터 또는 서블릿을 실행시켜 주는 구문
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
