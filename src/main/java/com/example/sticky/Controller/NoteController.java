package com.example.sticky.Controller;

import com.example.sticky.Entity.Note;
import com.example.sticky.Repository.NoteRepository;
import com.example.sticky.Service.NoteService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
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

    @GetMapping("/add")
    public ResponseEntity<?> adding(@RequestBody final Note note){
        try {
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
