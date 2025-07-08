package com.atguigu.java.ai.langchain4j;

import com.atguigu.java.ai.langchain4j.bean.ChatMessages;
import com.atguigu.java.ai.langchain4j.store.MongoChatMemoryStore;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.UserMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class MongoTest1 {
    @Autowired
    private MongoChatMemoryStore mongoChatMemoryStore;
    @Test
    public void test() {
        mongoChatMemoryStore.updateMessages(1, null);
    }

    @Test
    public void test1() {
        List<ChatMessage>   messages = List.of(
                UserMessage.from("你好"),
                UserMessage.from("测试消息")
        );
        mongoChatMemoryStore.updateMessages(1, messages);
    }

    @Test
    public void test2() {
        List<ChatMessage> messages = mongoChatMemoryStore.getMessages(1);
        System.out.println(messages);
    }
}
