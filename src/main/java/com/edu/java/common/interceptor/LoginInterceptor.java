package com.edu.java.common.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	
	public final static List<String> PERMITCOMMAND = Arrays.asList("/courseList.do","/courseDetail.do","/appForm.do","/courseInsert.do","/courseUpdate.do");
	public final static List<String> APPPAGE = Arrays.asList("/courseList.do","/courseDetail.do","/appForm.do","/courseInsert.do","/courseUpdate.do");
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String prevURI = request.getHeader("referer").substring(28, request.getHeader("referer").length());//이전 command
		String uri = request.getRequestURI().substring(6,request.getRequestURI().length());
		
		if (PERMITCOMMAND.contains(uri) || request.getSession().getAttribute("member") != null) {
			return true;
		}
		
		if (request.getSession().getAttribute("member") == null) {
			String goURI = "";
			if (APPPAGE.contains(uri)) {
				goURI = prevURI;
			} else {
				goURI = "main.do";
			}
			jsResponse(goURI,"You need to Login first!", response);
		}
		return false;
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}
	
	public void jsResponse(String url, String message, HttpServletResponse response) throws IOException {
		String script = "<script type='text/javascript'> " + "alert('" + message + "'); " + "location.href = '" + url + "';" + "</script>";
		PrintWriter writer = response.getWriter();
		writer.print(script);
	}

}
