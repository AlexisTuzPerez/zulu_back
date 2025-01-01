package com.zulu_bd.controller;


import com.zulu_bd.repository.ClientesRepository;
import com.zulu_bd.service.ClientesService;
import com.zulu_bd.model.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//Rest
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired //usa los services
    private ClientesService clientesService;
    @Autowired
    private ClientesRepository clientesRepository;


    @GetMapping
    public ResponseEntity<List<Clientes>> getClients() {
        List<Clientes> clientes = clientesService.findAll();
        return ResponseEntity.ok(clientes);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Clientes> getClient(@PathVariable int id) { //PathVariable es el {id}
        Clientes cliente = clientesService.findById(id);
        return  ResponseEntity.ok(cliente);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Clientes> updateCliente(@PathVariable int id, @RequestBody Clientes cliente) {

        try {
            Clientes clienteActualizado = clientesService.updateCliente(id, cliente);
            return ResponseEntity.ok(clienteActualizado);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Clientes> addClient(@RequestBody Clientes cliente) {
        try {
            Clientes nuevoCliente = clientesService.addClient(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{id}") // Ruta para eliminar un cliente por su ID
    public ResponseEntity<Void> deleteCliente(@PathVariable int id) {
        try {
            clientesService.deleteCliente(id);
            return ResponseEntity.noContent().build(); // HTTP 204 No Content
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // HTTP 404 Not Found
        }
    }











}