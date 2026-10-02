package com.yonsai.deploy_mcp.tools;

import java.util.List;
import java.util.Map;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yonsai.deploy_mcp.client.TestClient;

@Component
public class PostTool {

    @Autowired
    private TestClient 자동코드담당자;

    @Tool(description = "게시글 목록을 조회한다")
    public String getPosts() {
        System.out.println("PostTool - getPosts() 실행");

        List<Map<String, Object>> 결과 = 자동코드담당자.getPosts();

        return 결과.toString();
    }
}
