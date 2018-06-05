package org.softcits.mgt;

import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;

import org.softcits.mgt.auth.AuthUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.context.WebApplicationContext;
@Configuration
public class VPApplicationStartup implements ApplicationListener<ContextRefreshedEvent>{

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		/*Map<String,Set<String>> auths = AuthUtil.initAuth("org.softcits.mgt.controller");
		ApplicationContext applicationContext = event.getApplicationContext();
		WebApplicationContext webApplicationContext = (WebApplicationContext)applicationContext;
		ServletContext servletContext = webApplicationContext.getServletContext();
		servletContext.setAttribute("allAuths", auths);
		System.out.println("---------------加载系统权限并存储进ServletContext---------------");
		System.out.println(servletContext.getAttribute("allAuths"));*/
	}

	

}
