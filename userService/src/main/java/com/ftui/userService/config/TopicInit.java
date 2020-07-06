package com.ftui.userService.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;

import java.util.Arrays;

@Configuration
public class TopicInit {

    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name("thing1")
                .partitions(10)
                .replicas(3)
                .compact()
                .build();
    }

    @Bean
    public NewTopic topic2() {
        return TopicBuilder.name("thing2")
                .partitions(10)
                .replicas(3)
                .config(TopicConfig.COMPRESSION_TYPE_CONFIG, "zstd")
                .build();
    }




    @Bean
    public NewTopic topic3() {
        return TopicBuilder.name("thing3")
                .assignReplicas(0, Arrays.asList(0, 1))
                .assignReplicas(1, Arrays.asList(1, 2))
                .assignReplicas(2, Arrays.asList(2, 0))
                .config(TopicConfig.COMPRESSION_TYPE_CONFIG, "zstd")
                .build();
    }
}
