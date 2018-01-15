package com.sca.service;

import com.sca.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService {
    Page<Client> getAllClientsByPage(Pageable pageable);

    Client getClientById(Long id);

    void addClient(Client client);

    void updateClient(Client client, Long id);

    void deleteClient(Long id);
}
