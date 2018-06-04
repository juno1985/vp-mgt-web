package org.softcits.mgt.service;

import java.util.HashMap;
import java.util.Map;

import org.softcits.mgt.model.MbgUser;
import org.softcits.utils.CookieUtils;
import org.softcits.utils.HttpClientUtil;
import org.softcits.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;

@Service
public class MgtUserService {

	@Value("${auth.core.base.url}")
	private String AUTH_CORE_BASE_URL;
	@Value("${auth.core.context-path}")
	private String AUTH_CORE_CONTEXT_PATH;
	
	
	public String updateUser(MbgUser user) {
		//将对象转化为json
		String userJson = JsonUtils.objectToJson(user);
		return HttpClientUtil.doPostJson(AUTH_CORE_BASE_URL + AUTH_CORE_CONTEXT_PATH + "/user/update", userJson);
	}


	public String login(String username, String passwd) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("username", username);
		param.put("passwd", passwd);
		return HttpClientUtil.doPost(AUTH_CORE_BASE_URL + AUTH_CORE_CONTEXT_PATH + "/user/login", param);
		
	}
}
