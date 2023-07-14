package demo.satwik.service;

import demo.satwik.model.Message;
import demo.satwik.repository.MessageRepository;
import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Data
@Service
public class ConsumerService {

    private final MessageRepository messageRepository;

    private String Path="/Users/satwik.mishra/Downloads/new-kafka-project/KafkaProducer/src/main/java/demo/satwik/service/ConsumerText.txt";

    @KafkaListener(
            topics="recentchange",
            groupId = "myGroup"
    )
    public void consume(String message) throws IOException {
        String newLine = "\n";
        Path path = Paths.get(Path);
        Files.write(path, message.getBytes(), StandardOpenOption.APPEND);
        Files.write(path, newLine.getBytes(), StandardOpenOption.APPEND);
        Message text=new Message();
        text.setText(message);
        messageRepository.save(text);
        System.out.println(message);
    }
}
