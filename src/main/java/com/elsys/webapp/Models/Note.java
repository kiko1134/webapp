package com.elsys.webapp.Models;

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
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Note(String title, String content){
        this.title = title;
        this.content = content;
    }
}
