package com.yonsai.deploy_mcp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yonsai.deploy_mcp.client.PublicClient;
import com.yonsai.deploy_mcp.client.TestClient;
import com.yonsai.deploy_mcp.service.PublicDataService;

import tools.jackson.databind.JsonNode;

@Controller
public class HomeController {

  @Autowired
  private TestClient 자동코드작성담당자;

  @Value("${SERVICE_KEY}")
  private String serviceKey;

  @Autowired
  private PublicClient 공공데이터자동코드담당자;

  @Autowired
  private PublicDataService service;

  @GetMapping("/")
  public String index() {
    System.out.println("log - HomeController -index() 실행");

    return "index";
  }

  @GetMapping(value = "/home", produces = MediaType.TEXT_HTML_VALUE)
  public String home() {
    System.out.println("실행 전");
    // List<Map<String, Object>> 결과 = 자동코드작성담당자.getPosts();

    service.getLoan();
    System.out.println("실행 후");

    String 결과 = service.getLoan();

    // 맵타일을 문자로 변경해서 브라우저로 보내기!
    return 결과.toString();

  }

  @GetMapping(value = "/data", produces = MediaType.TEXT_HTML_VALUE)
  public String data() {
    System.out.println("연결 HomeController - data() ");

    JsonNode 결과 = 공공데이터자동코드담당자
        .getLoan(serviceKey,
            1,
            10,
            "json");
    System.err.println("실행");

    // 필요한 부분만 꺼내기(경로로 바로 접근)
    JsonNode 파싱결과 = 결과.at("/response/body/items/item");
    System.out.println("공공데이터 호출 후 !");

    String 결과정리 = "";

    for (JsonNode 상품한개 : 파싱결과) {

      결과정리 += 상품한개.get("finPrdNm").asString();
      결과정리 += " / ";
      결과정리 += "최대 한도: " + 상품한개.get("lnLmt").asString();
      결과정리 += "</br>"; // 줄바꿈 기호!
      System.out.println(결과정리);
    }

    return 결과정리;
  }

}

// public String home() {
// System.out.println("연결 HomeController - home() ");

// Map<String, Object> 결과 = 자동코드작성담당자.getPosts();

// System.out.println("자동코드작성담당자.getPosts() - 실행");

// return 결과.toString();
// }
