package com.example.sticky.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Client" , schema = "public")
public class Client {
    @Id
    @Getter
    @Setter
    private long ID;

    @Getter
    @Setter
    @Column(name = "client_names")
    private String name;

    @Getter
    @Setter
    @Column(name = "client_notes")
    private List<Note> stickynotes;
}
