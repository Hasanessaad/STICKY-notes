package com.example.sticky.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "Reminders" , schema = "public")
public class Note {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Getter
    @Setter
    @Column(name = "notes")
    private String note;
    @Getter
    @Setter
    @JoinColumn(name = "client_fk_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;
}
