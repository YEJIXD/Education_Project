package com.edu.java.common.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	
	public final static List<String> PERMITCOMMAND = Arrays.asList("/courseList.do","/courseDetail.do","/appForm.do","/courseInsert.do","/courseUpdate.do");
	public final static List<String> APPPAGE = Arrays.asList("/courseList.do","/courseDetail.do","/appForm.do","/courseInsert.do","/courseUpdate.do");
	
	// 페이지 요청 정보 저장 
	private void saveDestination(HttpServletRequest request) { 
		String uri = request.getRequestURI(); 
		String query = request.getQueryString(); 
		
		if (query == null || query.equals("null")) { 
			query = ""; 
		} else { 
			query = "?" + query; 
		} 
		
		if (request.getMethod().equals("GET")) { 
			logger.info("destination : " + (uri + query)); 
			request.getSession().setAttribute("destination", uri + query); 
		} 
	}

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession httpSession = request.getSession();
		
		if(httpSession.getAttribute("login") == null) {
			logger.info("current user is not logged");
			response.sendRedirect("/login/loginForm");
			return false;
		}
		
		return true;
		
		
		/*String prevURI = request.getHeader("referer").substring(28, request.getHeader("referer").length());//이전 command
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
		return false;*/
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		HttpSession httpSession = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		Object userDto = modelMap.get("member");
		
		if(userDto != null) {
			logger.info("new login success");
			httpSession.setAttribute("LOGIN", userDto);
			Object destination = httpSession.getAttribute("destination");
			
			response.sendRedirect(destination != null ? (String)destination : "/login/loginForm");
		}
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
