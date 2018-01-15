package com.sca.controller;

import com.sca.entity.Client;
import com.sca.entity.dto.ClientDTO;
import com.sca.service.ClientService;
import com.sca.util.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Page<Client>> getAllClientsByPage(Pageable pageable) {
        Page<Client> list = clientService.getAllClientsByPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Long id){
        Client client = clientService.getClientById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addClient(@RequestBody @DTO(ClientDTO.class) Client client, UriComponentsBuilder builder){
        clientService.addClient(client);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/client/{id}").buildAndExpand(client.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@RequestBody @DTO(ClientDTO.class) Client client, @PathVariable("id") Long id){
        clientService.updateClient(client, id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable("id") Long id){
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
