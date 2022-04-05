package com.example.jpah2demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.jpah2demo.entities.Cliente;
import com.example.jpah2demo.repositories.ClienteRepository;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/addClient")
    public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {
	Cliente addCliente = clienteRepository.save(cliente);
	return ResponseEntity.status(HttpStatus.CREATED).body(addCliente);
    }

    @GetMapping("/findAllClients")
    public ResponseEntity<List<Cliente>> findAllClients() {
	List<Cliente> clientes = clienteRepository.findAll();
	return ResponseEntity.ok(clientes);
    }

    @GetMapping("/findClientById/{id}")
    public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {
	Optional<Cliente> clientes = clienteRepository.findById(idClient);
	return ResponseEntity.status(HttpStatus.CREATED).body(clientes.get());
    }

    @DeleteMapping("/removeClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("id") Long idClient) {
	clienteRepository.findById(idClient).map(cliente -> {
	    clienteRepository.deleteById(cliente.getId());
	    return Void.TYPE;
	}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
    }

    @PutMapping("/updateClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
	Optional<Cliente> client = clienteRepository.findById(id);
	if (client.get() != null) {
	    clienteRepository.deleteById(cliente.getId());
	    clienteRepository.save(cliente);
	} else {
	    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado.");
	}
    }
}
