package com.example.service;

import com.example.dto.ClientGetDTO;
import com.example.dto.ClientPostDTO;
import com.example.entity.Client;
import com.example.repository.ClientRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ClientService {
    @Inject
    ClientRepository clientRepository;

    public List<ClientGetDTO> getClients() {
        return clientRepository.listAll().stream().map(this::clientToClientDTO).toList();
    }

    public ClientGetDTO getClient(Long id) {
        return clientToClientDTO(getClientById(id));
    }

    @Transactional
    public ClientGetDTO createClient(ClientPostDTO clientPostDTO) {
        Client client = dtoToClient(clientPostDTO);
        clientRepository.persistAndFlush(client);
        return clientToClientDTO(client);
    }

    @Transactional
    public ClientGetDTO updateClient(Long id, Client updatedClient) {
        Client client = getClientById(id);
        if (client != null) {
            client.setName(updatedClient.getName());
            client.setEmail(updatedClient.getEmail());
            client.setPhone(updatedClient.getPhone());
            clientRepository.persistAndFlush(client);
            return clientToClientDTO(client);
        }
        return null;
    }

    @Transactional
    public boolean deleteClient(Long id) {
        return clientRepository.deleteById(id);
    }

    private Client getClientById(Long id) {
        return clientRepository.findById(id);
    }

    private ClientGetDTO clientToClientDTO(Client client) {
        return new ClientGetDTO(
                client.getId(),
                client.getName(),
                client.getEmail(),
                client.getPhone());
    }

    private Client dtoToClient(ClientPostDTO clientPostDTO) {
        Client client =  new Client();
        client.setName(clientPostDTO.getName());
        client.setEmail(clientPostDTO.getEmail());
        client.setPhone(clientPostDTO.getPhone());
        return client;
    }
}
