package com.atguigu.java.ai.langchain4j.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * @author qingshu
 * @date 7/6/25
 */
@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "qwenChatModel",
        chatMemoryProvider = "chatMemoryProvider"
)
public interface SeparateChatAssistant {
    /**
     * 对话
     *
     * @param id          记忆id
     * @param userMessage 用户消息
     * @return 机器人回复
     */
    @SystemMessage(fromResource = "my-prompt-template.txt")
    String chat(@MemoryId int id, @UserMessage String userMessage);
}
