package org.softcits.mgt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.softcits.mgt.service.MgtUserService;
import org.softcits.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.druid.util.StringUtils;
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Value("${pc.login.url}")
	private String PC_LOGIN_URL;
	@Autowired
	private MgtUserService mgtUserService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 取用户token
		String token = CookieUtils.getCookieValue(request, "PC_TOKEN");
		// 判断是否为空
		if (StringUtils.isEmpty(token)) {
			// 如果为空就是未登录状态
			// 跳转到登录页面
			response.sendRedirect(PC_LOGIN_URL);
			return false;
		} else {
			// 如果能取到token说明用户可能已经登录
			// 从sso中取用户信息，判断用户是否登录
			String userJson = mgtUserService.getUserByToken(token);
			// 判断用户是否过期
			if (StringUtils.isEmpty(userJson)) {
				// 跳转到登录页面
				response.sendRedirect(PC_LOGIN_URL);
				return false;
			} else {
				// 用户已经登录，把用户信息放到request中
				request.setAttribute("user", userJson);
			}

		}
		// 放行
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

}
