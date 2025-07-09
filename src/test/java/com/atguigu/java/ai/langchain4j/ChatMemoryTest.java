package com.atguigu.java.ai.langchain4j;

import com.atguigu.java.ai.langchain4j.assistant.Assistant;
import com.atguigu.java.ai.langchain4j.assistant.SeparateChatAssistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * @author qingshu
 */
@SpringBootTest
public class ChatMemoryTest {
    @Autowired
    private Assistant assistant;
    @Autowired
    private SeparateChatAssistant separateChatAssistant;
    @Autowired
    private QwenChatModel qwenChatModel;

    @Test
    public void testChatMemory() {
        String answer1 = assistant.chat("我是环环");
        System.out.println(answer1);
        String answer2 = assistant.chat("我叫什么");
        System.out.println(answer2);
    }

    @Test
    public void testChatMemory2() {
        UserMessage m1 = UserMessage.userMessage("我是环环");
        ChatResponse response = qwenChatModel.chat(m1);
        AiMessage aiMessage = response.aiMessage();
        System.out.println(aiMessage.text());

        UserMessage m2 = UserMessage.userMessage("我叫什么");
        response = qwenChatModel.chat(Arrays.asList(m1, aiMessage, m2));
        aiMessage = response.aiMessage();
        System.out.println(aiMessage.text());
    }

    @Test
    public void testChatMemory3() {
        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);
        Assistant assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(qwenChatModel)
                .chatMemory(chatMemory)
                .build();
        String m1 = assistant.chat("我是环环");
        System.out.println(m1);
        String m2 = assistant.chat("我叫什么");
        System.out.println(m2);
    }

    @Test
    public void testChatMemory4() {
        String m1 = assistant.chat("我是环环");
        System.out.println(m1);
        String m2 = assistant.chat("我叫什么");
        System.out.println(m2);
    }

    @Test
    public void testChatMemory5() {
        String m1 = separateChatAssistant.chat(11, "我是环环");
        System.out.println(m1);
        String m2 = separateChatAssistant.chat(11, "我叫什么");
        System.out.println(m2);
        String m3 = separateChatAssistant.chat(12, "我叫什么");
        System.out.println(m3);
    }
}
