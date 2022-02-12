package com.elsys.webapp.DataAccess;

import com.elsys.webapp.Models.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends CrudRepository<Note, Integer> {
}
