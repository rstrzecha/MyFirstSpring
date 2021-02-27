package com.example.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //przykładowa tabela - może da się lepiej
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deadline;
    @Column(length = 3000)
    private String description;
    private String color;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;


}
