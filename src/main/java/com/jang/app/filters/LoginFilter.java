package com.jang.app.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
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
		// TODO Auto-generated method stub
		// place your code here
		//session에서 멤버 꺼낼을때 null이냐 아니냐
		
		// ServletRequest 이 부모라 형변환 해주기 이래야 session 사용가능
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		
		Object obj = session.getAttribute("member");
		
		if(obj != null) {
			
			chain.doFilter(request, response);
		} else {
			// filter는 spring영역이 아니라 java로 해야함
			//1.foward 방식
			request.setAttribute("result", "권환이 없습니다");
			request.setAttribute("url", "/member/login");
			 RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/message.jsp");
			 view.forward(request, response);
			 
			//2.redirect
//			 HttpServletResponse res = (HttpServletResponse)response;
//			 res.sendRedirect("/member/login");
		}

		// pass the request along the filter chain
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
