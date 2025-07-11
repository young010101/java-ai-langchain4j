package com.atguigu.java.ai.langchain4j;

import com.atguigu.java.ai.langchain4j.assistant.Agent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AgentTest {
    @Autowired
    private Agent agent;
    @Test
    public void test() {
        String answer = agent.chat("hello");
        System.out.println(answer);
    }
}
