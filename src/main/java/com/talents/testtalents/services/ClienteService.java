package com.talents.testtalents.services;

import com.talents.testtalents.entities.Cliente;
import com.talents.testtalents.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente criar(Cliente cliente) {
        Optional<Cliente> clienteOptionalEmail = clienteRepository.findByEmail(cliente.getEmail());

        if (clienteOptionalEmail.isPresent()) {
            throw new RuntimeException();
        }

        Optional<Cliente> clienteOptionalCpf = clienteRepository.findByCpf(cliente.getCpf());

        if (clienteOptionalCpf.isPresent()) {
            throw new RuntimeException();
        }

        return clienteRepository.save(cliente);
    }

}
