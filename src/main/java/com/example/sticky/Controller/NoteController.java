package com.example.sticky.Controller;

import com.example.sticky.Entity.Note;
import com.example.sticky.Repository.NoteRepository;
import com.example.sticky.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/note")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private NoteService noteService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        try{
            List<?> m_marca = noteRepository.findAll();
            return new ResponseEntity<>(m_marca, HttpStatus.OK);
        }catch (Exception e){

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> cadastrar(@RequestBody final Note note){
        try {
            this.noteRepository.save(note);
            this.noteService.adding(note);
            return ResponseEntity.ok("Registrado cadastrado com Sucesso");
        }
        catch (DataIntegrityViolationException e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getCause().getCause().getMessage());
        }
        catch (RuntimeException e){
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

}
