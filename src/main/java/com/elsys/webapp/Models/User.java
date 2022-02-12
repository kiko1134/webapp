package com.elsys.webapp.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Note> notes;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.notes = new ArrayList<>();
    }

    public void addNote(Note note){
        notes.add(note);
    }
}
