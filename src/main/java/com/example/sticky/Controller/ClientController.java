package com.example.sticky.Controller;

import com.example.sticky.Entity.Client;
import com.example.sticky.Repository.ClientRepository;
import com.example.sticky.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientService clientService;

    @GetMapping("/name")
    public ResponseEntity<?> findByName(@RequestParam("name") final String name){

        List<Client> cur_client = this.clientRepository.findByName(name);

        return cur_client == null
                ? ResponseEntity.badRequest().body("No value found")
                : ResponseEntity.ok(cur_client);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        try{
            List<?> m_marca = clientRepository.findAll();
            return new ResponseEntity<>(m_marca, HttpStatus.OK);
        }catch (Exception e){

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> cadastrar(@RequestBody final Client client){
        try {
            this.clientService.cadastrar(client);
            return ResponseEntity.ok("Registrado cadastrado com Sucesso");
        }
        catch (DataIntegrityViolationException e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getCause().getCause().getMessage());
        }
        catch (RuntimeException e){
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<?> edit(@RequestParam("id") final Long id,@RequestBody final Client client){

        try{
            this.clientService.edit(client, id);
            return ResponseEntity.ok("Registro atualizacao com sucesso");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getCause().getCause().getMessage());
        }
        catch (RuntimeException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletar (@RequestParam ("id") final Long id){

        final Client bb = this.clientRepository.findById(id).orElse(null);

        this.clientService.delete(bb);

        return ResponseEntity.ok("Marca deletada com sucesso");
    }
}
