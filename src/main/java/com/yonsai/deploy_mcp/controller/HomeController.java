package com.yonsai.deploy_mcp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yonsai.deploy_mcp.client.PublicClient;
import com.yonsai.deploy_mcp.client.TestClient;

@RestController
public class HomeController {

	@Autowired
	private TestClient 자동코드작성담당자;

	@Value("${service-key}")
	private String serviceKey;

	@Autowired
	private PublicClient 공공데이터자동코드담당자;

	@GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
	public String home() {
		System.out.println("연결 HomeController - home() ");

		List<Map<String, Object>> 결과 = 자동코드작성담당자.getPosts();

		System.out.println("자동코드작성담당자.getPosts() - 실행");

		return 결과.toString();
	}

	@GetMapping(value = "/data", produces = MediaType.TEXT_HTML_VALUE)
	public String data() {
		System.out.println("연결 HomeController - data() ");

		Map<String, Object> 결과 = 공공데이터자동코드담당자
				.getLoan(serviceKey,
						1,
						10,
						"json");
		System.err.println("실행");

		return 결과.toString();
	}

}

// public String home() {
// System.out.println("연결 HomeController - home() ");

// Map<String, Object> 결과 = 자동코드작성담당자.getPosts();

// System.out.println("자동코드작성담당자.getPosts() - 실행");

// return 결과.toString();
// }
