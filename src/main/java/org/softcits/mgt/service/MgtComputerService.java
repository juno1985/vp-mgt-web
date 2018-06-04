package org.softcits.mgt.service;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.softcits.mgt.exception.PCBadRequestException;
import org.softcits.mgt.model.MbgComputer;
import org.softcits.utils.HttpClientUtil;
import org.softcits.utils.JsonUtils;
@Service
public class MgtComputerService {
	
	@Value("${pc.rest.url}")
	private String PC_REST_URL;
	@Value("${pc.admin.url}")
	private String PC_ADMIN_URL;

	public String getComputers(String pageNum, String rows){
		Map<String, String> params = new HashMap<String, String>();
		params.put("pageNum", pageNum);
		params.put("rows", rows);
		return HttpClientUtil.doGet(PC_REST_URL + PC_ADMIN_URL + "/getPage", params);
	}

	public String addComputer(String tradeMark, String price, String newFileName) {
		
		String result = queryComputerByTradeMark(tradeMark);
		if(!"".equals(result) || result == null) {
			throw new PCBadRequestException("TradeMark已经存在");
		}
		
		MbgComputer mbgComputer = new MbgComputer();
		mbgComputer.setTrademark(tradeMark);
		mbgComputer.setPrice(Float.parseFloat(price));
		mbgComputer.setPic(newFileName);
		String json_computer = JsonUtils.objectToJson(mbgComputer);
		
		return HttpClientUtil.doPostJson(PC_REST_URL + PC_ADMIN_URL + "/add", json_computer);
	}

	public String queryComputerById(String id) {
		return HttpClientUtil.doGet("http://localhost:8002/rest-api/admin/pc/query/"+id);
	}
	
	public String queryComputerByTradeMark(String tradeMark) {
		return HttpClientUtil.doGet("http://localhost:8002/rest-api/admin/pc/queryName/"+tradeMark);
	}
}
