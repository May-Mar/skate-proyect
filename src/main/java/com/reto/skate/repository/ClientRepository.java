package com.reto.skate.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto.skate.model.Client;
import com.reto.skate.repository.crud.ClientCrudRepositoryInterfaz;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepositoryInterfaz clientCrudRepositoryInterfaz;

    public List<Client> obtenerClientCompleta(){
        return (List<Client>) clientCrudRepositoryInterfaz.findAll();
    }

    public Optional<Client> obtenerClientId(Integer id){
        return clientCrudRepositoryInterfaz.findById(id);
    }

    public Client salvarClient(Client client){
        return clientCrudRepositoryInterfaz.save(client);     
    }

    public void delete (Client client){
        clientCrudRepositoryInterfaz.delete(client);
    }     
}
