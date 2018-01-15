package com.sca.service;

import com.sca.entity.Client;
import com.sca.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Page<Client> getAllClientsByPage(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    public Client getClientById(Long id){
            return clientRepository.findOne(id);
    }

    public void addClient(Client client){
            clientRepository.save(client);
    }

    public void updateClient(Client client, Long id){
            client.setId(id);
            clientRepository.save(client);
    }

    public void deleteClient(Long id){
                clientRepository.delete(id);
    }
}
