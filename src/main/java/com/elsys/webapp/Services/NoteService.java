package com.elsys.webapp.Services;

import com.elsys.webapp.DataAccess.NoteRepository;
import com.elsys.webapp.DataAccess.UserRepository;
import com.elsys.webapp.Models.Note;
import com.elsys.webapp.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository,
                       UserRepository userRepository){
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    public void createNote(Note note, int user_id){
        Optional<User> user = userRepository.findById(user_id);

        if (user.isEmpty())
            return;

        note.setUser(user.get());
        noteRepository.save(note);
    }

    public void deleteNote(int note_id){
        noteRepository.deleteAllById(List.of(note_id));
    }
}
