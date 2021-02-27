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

    public Task() {
    }

    public Task(Long id, Date deadline, String description, String color, Date creationDate, Person person) {
        this.id = id;
        this.deadline = deadline;
        this.description = description;
        this.color = color;
        this.creationDate = creationDate;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public Date getDeadline() {
        return deadline;
    }

    public String getDescription() {
        return description;
    }

    public String getColor() {
        return color;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
