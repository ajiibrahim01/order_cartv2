package com.shop.infrastructure;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpSession;

import com.shop.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginFilter extends HttpFilter implements Filter {
       

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);
        User user = (User) session.getAttribute("user_data");
        boolean isEmpty = (user==null);
        if(session!=null) {
        	System.out.println(user.getName());
        	System.out.println(user.getRole());
            chain.doFilter(request, response);
        }else {
        	httpResponse.sendRedirect(httpRequest.getContextPath()+"/login");
        }
      
    }
}
