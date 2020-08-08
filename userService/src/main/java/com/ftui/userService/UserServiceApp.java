package com.ftui.userService;
import com.ftui.userService.jpa.CommentRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
@MapperScan
@SpringBootApplication
@EnableEurekaClient
public class UserServiceApp implements CommandLineRunner {
    public static Logger logger = LoggerFactory.getLogger(UserServiceApp.class);
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApp.class,args);
    }

    @Autowired
    KafkaTemplate kafkaTemplate;
    private final CountDownLatch latch = new CountDownLatch(3);

    @Override
    public void run(String... args) throws Exception {
        kafkaTemplate.send("myTopic1", "foo1");
        kafkaTemplate.send("myTopic1", "foo2");
        kafkaTemplate.send("myTopic1", "foo3");
        latch.await(60, TimeUnit.SECONDS);
        logger.info("All received");
    }

    @KafkaListener(topics = "myTopic1")
    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
        logger.info(cr.toString());
        latch.countDown();
    }




}
