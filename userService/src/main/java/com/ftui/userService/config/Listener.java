package com.ftui.userService.config;

import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class Listener {
    private final CountDownLatch latch1 = new CountDownLatch(1);


}
