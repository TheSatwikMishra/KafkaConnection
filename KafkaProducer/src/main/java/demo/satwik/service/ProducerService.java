package demo.satwik.service;

import jakarta.annotation.Resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProducerService {
    @Resource
    KafkaTemplate<String,String> kafkaTemplate;

    @Value("${spring.kafka.topic.name}")
    String topic;
    public void post(String message){
        kafkaTemplate.send(topic,message);
    }
}
