package com.reto.skate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.skate.model.Client;
import com.reto.skate.repository.ClientRepository;

@Service
public class ClientService {
        
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> obtenerClientCompleta(){
        return clientRepository.obtenerClientCompleta();

    }

    public Optional<Client> obtenerClientId(Integer id){
        return clientRepository.obtenerClientId(id);
    }

    public Client salvarClient(Client client){
        if(client.getIdClient()==null){
            return clientRepository.salvarClient(client);
            }
            else{
                Optional<Client> clientAuxiliar=clientRepository.obtenerClientId(client.getIdClient());
                if(clientAuxiliar.isEmpty()){
                    return clientRepository.salvarClient(client);
                }
                else{
                    return client;
                }
                    
            }  
        }
        public Client update(Client client){
            if(client.getIdClient()!=null){
                Optional<Client> clientAuxiliar = clientRepository.obtenerClientId(client.getIdClient());
                if(!clientAuxiliar.isEmpty()){
                    if(client.getName()!=null){
                        clientAuxiliar.get().setName(client.getName());
                    }
                    if(client.getAge()!=null){
                        clientAuxiliar.get().setAge(client.getAge());
                    }
                    if(client.getPassword()!=null){
                        clientAuxiliar.get().setPassword(client.getPassword());
                    }
                    clientRepository.salvarClient(clientAuxiliar.get());
                    return clientAuxiliar.get();
                }else{
                    return client;
                }
            }else{
                return client;
            }
        }
    
        public boolean deleteClient(Integer clientId){
            boolean flag=false;
            Optional<Client> clientAuxiliar = clientRepository.obtenerClientId(clientId);
            if(clientAuxiliar.isPresent()){
                clientRepository.delete(clientAuxiliar.get());
                flag=true;
            }
            return flag;
        } 
}
