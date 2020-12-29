package com.talents.testtalents.repositories;

import com.talents.testtalents.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public Optional<Cliente> findByEmail(String email);

    public Optional<Cliente> findByCpf(String cpf);

}
