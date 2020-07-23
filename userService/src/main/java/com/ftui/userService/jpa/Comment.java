package com.ftui.userService.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  Long id;
    private String content;
    protected Comment(){}

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
