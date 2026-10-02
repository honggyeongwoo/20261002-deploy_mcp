package com.yonsai.deploy_mcp.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yonsai.deploy_mcp.service.PublicDataService;

@Component
public class LoanTool {

    @Autowired
    private PublicDataService dataService;

    @Tool(description = "서민금융 대출상품 목록을 조회한다. 대출상품명,최대한도 알려준다")
    public String getLoans() {

        System.out.println(" log - LoanTool - getLoans()");

        return dataService.getLoan();
    }
}