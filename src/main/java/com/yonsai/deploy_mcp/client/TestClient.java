package com.yonsai.deploy_mcp.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "jsonplaceholerTest", url = "https://jsonplaceholder.typicode.com")

public interface TestClient {

}
