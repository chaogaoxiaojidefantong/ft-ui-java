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

    @Bean
    public CommandLineRunner demo(CommentRepository repository) {
        return (args) -> {
//            // save a few customers
//            repository.save(new Customer("Jack", "Bauer"));
//            repository.save(new Customer("Chloe", "O'Brian"));
//            repository.save(new Customer("Kim", "Bauer"));
//            repository.save(new Customer("David", "Palmer"));
//            repository.save(new Customer("Michelle", "Dessler"));
//
//            // fetch all customers
//            logger.info("Customers found with findAll():");
//            logger.info("-------------------------------");
//            for (Customer customer : repository.findAll()) {
//                logger.info(customer.toString());
//            }
//            logger.info("");
//
//            // fetch an individual customer by ID
//            Customer customer = repository.findById(1L);
//            logger.info("Customer found with findById(1L):");
//            logger.info("--------------------------------");
//            logger.info(customer.toString());
//            logger.info("");
//
//            // fetch customers by last name
//            logger.info("Customer found with findByLastName('Bauer'):");
//            logger.info("--------------------------------------------");
//            repository.findByLastName("Bauer").forEach(bauer -> {
//                logger.info(bauer.toString());
//            });
//            // for (Customer bauer : repository.findByLastName("Bauer")) {
//            //  log.info(bauer.toString());
//            // }
//            logger.info("");
        };
    }
}
