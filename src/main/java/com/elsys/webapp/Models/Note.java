package com.elsys.webapp.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Note {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    @JsonIgnore
    private int userId;

    public Note(String title, String content){
        this.title = title;
        this.content = content;
    }

    public void setUserID(int userId) {
        this.userId = userId;
    }
}
