package com.yonsai.deploy_mcp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yonsai.deploy_mcp.client.TestClient;

@RestController
public class HomeController {

	@Autowired
	private TestClient 자동코드작성담당자;

	@GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
	public String home() {
		System.out.println("연결 HomeController - home() ");

		Map<String, Object> 결과 = 자동코드작성담당자.getPosts();

		System.out.println("자동코드작성담당자.getPosts() - 실행");

		return 결과.toString();
	}
}
