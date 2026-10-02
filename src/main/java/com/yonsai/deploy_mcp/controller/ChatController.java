package com.yonsai.deploy_mcp.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.yonsai.deploy_mcp.tools.CommentTool;
import com.yonsai.deploy_mcp.tools.LoanTool;
import com.yonsai.deploy_mcp.tools.PostTool;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ChatController {

    private final ChatClient chatClient;

    @Autowired
    private PostTool postTool;

    @Autowired
    private CommentTool commentTool;

    @Autowired
    private LoanTool loanTool;

    // 생성자 서버가 실행할 때 한번만 실행해라! 타입검사해라!
    // private final 한번 저장된 객체는 절대 못바꾼다.
    // 매개변수를 이용해서 타입도 검사해준다! (안정성!)
    public ChatController(ChatClient.Builder builder) {
        System.out.println("ChatController - 타입 검사 실행");
        this.chatClient = builder.build();
        System.out.println("ChatController - 검사 완료");
    }

    @GetMapping("/chat")
    public String chat(@RequestParam("qus") String qus) {
        System.out.println("log - ChatController - chat() 실행 됨");

        String 결과 = chatClient
                .prompt()
                .user(qus)
                .tools(postTool, commentTool, loanTool)
                .call()
                .content();
        System.out.println("log - ChatController - chat() 완료");
        return 결과;

    }

}

// @GetMapping("/chat")
// public String chat() {
// System.out.println("log - ChatController - chat() 실행 됨");

// String 결과 = chatClient
// .prompt()
// .user("크리스마스에 수원에서 뭘 해야하지?")
// .call()
// .content();
// System.out.println("log - ChatController - chat() 완료");
// return 결과;
