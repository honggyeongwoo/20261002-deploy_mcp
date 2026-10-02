package com.yonsai.deploy_mcp.client;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "jsonplaceholerTest", url = "https://jsonplaceholder.typicode.com")

public interface TestClient {

    @GetMapping("/posts")
    List<Map<String, Object>> getPosts();

    @GetMapping("/comments")
    List<Map<String, Object>> getComments();
}

// public interface TestClient {

// @GetMapping("/posts/1")
// Map<String, Object> getPosts();
// }
