package com.reto.skate.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto.skate.model.Skate;
import com.reto.skate.repository.crud.SkateCrudRepositoryInterfaz;

@Repository
public class SkateRepository {
    
    @Autowired
    private SkateCrudRepositoryInterfaz skateCrudRepositoryInterfaz;

    public List<Skate> obtenerSkateCompleta(){
        return (List<Skate>) skateCrudRepositoryInterfaz.findAll();
    }

    public Optional<Skate> obtenerSkateId(Integer id){
        return skateCrudRepositoryInterfaz.findById(id);
    }

    public Skate salvarSkate(Skate skate){
        return skateCrudRepositoryInterfaz.save(skate);     
    }

    public void delete (Skate skate){
        skateCrudRepositoryInterfaz.delete(skate);
    } 
}
