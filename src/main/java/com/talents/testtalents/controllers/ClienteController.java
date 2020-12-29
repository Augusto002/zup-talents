package com.talents.testtalents.controllers;

import com.talents.testtalents.entities.Cliente;
import com.talents.testtalents.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente) {

        try {
            Cliente clienteSalvo = clienteService.criar(cliente);

            return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }

}
