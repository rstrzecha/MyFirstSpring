package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String gitHub;
    private String start;
    private Integer java;
    private Integer bestPractice;
    private Integer tdd;
    private Integer question;//dla SQLa bo nazwa jest zastrzeżona
    private Integer hibernate;
    private Integer html;
    private Integer jsp;
    private Integer thymeleaf;
    private Integer git;
    private Integer checkbox;

    public Person() {
    }

    public Person(long id, String firstName, String lastName, String gitHub, String start, Integer java, Integer bestPractice, Integer tdd, Integer question, Integer hibernate, Integer html, Integer jsp, Integer thymeeaf, Integer git, Integer checkbox) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gitHub = gitHub;
        this.start = start;
        this.java = java;
        this.bestPractice = bestPractice;
        this.tdd = tdd;
        this.question = question;
        this.hibernate = hibernate;
        this.html = html;
        this.jsp = jsp;
        this.thymeleaf = thymeeaf;
        this.git = git;
        this.checkbox = checkbox;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGitHub() {
        return gitHub;
    }

    public String getStart() {
        return start;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getJava() {
        return java;
    }

    public Integer getBestPractice() {
        return bestPractice;
    }

    public Integer getTdd() {
        return tdd;
    }

    public Integer getQuestion() {
        return question;
    }

    public Integer getHibernate() {
        return hibernate;
    }

    public Integer getHtml() {
        return html;
    }

    public Integer getJsp() {
        return jsp;
    }

    public Integer getThymeleaf() {
        return thymeleaf;
    }

    public Integer getGit() {
        return git;
    }

    public Integer getCheckbox() {
        return checkbox;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGitHub(String gitHub) {
        this.gitHub = gitHub;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setJava(Integer java) {
        this.java = java;
    }

    public void setBestPractice(Integer bestPractice) {
        this.bestPractice = bestPractice;
    }

    public void setTdd(Integer tdd) {
        this.tdd = tdd;
    }

    public void setQuestion(Integer question) {
        this.question = question;
    }

    public void setHibernate(Integer hibernate) {
        this.hibernate = hibernate;
    }

    public void setHtml(Integer html) {
        this.html = html;
    }

    public void setJsp(Integer jsp) {
        this.jsp = jsp;
    }

    public void setThymeleaf(Integer thymeleaf) {
        this.thymeleaf = thymeleaf;
    }

    public void setGit(Integer git) {
        this.git = git;
    }

    public void setCheckbox(Integer checkbox) {
        this.checkbox = checkbox;
    }
}
