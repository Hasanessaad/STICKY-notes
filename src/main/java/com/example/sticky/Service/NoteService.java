package com.example.sticky.Service;

import com.example.sticky.Controller.NoteController;
import com.example.sticky.Entity.Client;
import com.example.sticky.Entity.Note;
import com.example.sticky.Repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Transactional(rollbackFor = Exception.class)
    public void adding(@RequestBody final Note note){

        Assert.isTrue(note.getNote().length() > 2, "O nome está faltando");

        this.noteRepository.save(note);
    }
}
