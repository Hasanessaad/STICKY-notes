package com.example.sticky.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Client" , schema = "public")
public class Client {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    @Column(name = "client_names")
    private String name;

    @Getter
    @Setter
    @OneToMany(mappedBy = "client")
    private List<Note> stickynotes = new ArrayList<>();
}
