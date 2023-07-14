package demo.satwik.model;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Entity
@Table(name = "message")
@Slf4j
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public void setText(String text) {
        this.name = text;
    }

}
