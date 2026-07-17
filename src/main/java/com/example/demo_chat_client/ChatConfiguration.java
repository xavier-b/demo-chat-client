package com.example.demo_chat_client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ChatConfiguration {


    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder)  {
        return chatClientBuilder.build();
    }

    @Bean
    public CommandLineRunner demo(ChatClient chatClient , ToolCallbackProvider mcpTools) {
        log.info("XAv");
        return args -> {
            String response = chatClient
                    .prompt("What's the weather like in Paris?")
                    .tools(mcpTools)
                    .call()
                    .content();
            System.out.println(response);
        };
    }
}
