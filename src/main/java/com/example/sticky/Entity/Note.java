package com.example.sticky.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "Reminders" , schema = "public")
public class Note {
    @Id
    @Getter
    @Setter
    private long ID;
    @Getter
    @Setter
    @Column(name = "notes")
    private String note;
}
