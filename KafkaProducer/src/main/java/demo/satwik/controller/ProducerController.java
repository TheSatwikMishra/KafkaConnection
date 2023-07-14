package demo.satwik.controller;

import demo.satwik.dto.ProducerRequest;
import demo.satwik.dto.ProducerResponse;
import demo.satwik.service.ProducerService;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Data
@RequestMapping(path = "/api")
public class ProducerController {
    private final ProducerService producerService;

    @GetMapping(path = "/v1/post/{message}")
    public void post(@PathVariable String message){
      producerService.post(message);
    }

    }

