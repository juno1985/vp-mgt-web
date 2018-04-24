package org.softcits.mgt.service;

import java.io.IOException;
import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.softcits.mgt.model.MbgComputer;
import org.softcits.utils.HttpClientUtil;
import org.softcits.utils.JsonUtils;
@Service
public class MgtComputerService {
	
	@Value("${pc.rest.url}")
	private String PC_REST_URL;
	@Value("${pc.admin.url}")
	private String PC_ADMIN_URL;

	public String getComputers(){
		// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String resultString = "";
		CloseableHttpResponse response = null;
		try {
			// 创建uri
			URIBuilder builder = new URIBuilder(PC_REST_URL + PC_ADMIN_URL + "/getAll");
			URI uri = builder.build();

			// 创建http GET请求
			HttpGet httpGet = new HttpGet(uri);

			// 执行请求
			response = httpclient.execute(httpGet);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}

	public String addComputer(String tradeMark, String price, String newFileName) {
		MbgComputer mbgComputer = new MbgComputer();
		mbgComputer.setTrademark(tradeMark);
		mbgComputer.setPrice(Float.parseFloat(price));
		mbgComputer.setPic(newFileName);
		String json_computer = JsonUtils.objectToJson(mbgComputer);
		System.out.println("web-> " + json_computer);
		
		return HttpClientUtil.doPostJson(PC_REST_URL + PC_ADMIN_URL + "/add", json_computer);
	}

	public String queryComputerById(String id) {
		return HttpClientUtil.doGet("http://localhost:8002/rest-api/admin/pc/query/"+id);
	}
}
