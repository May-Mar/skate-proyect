package com.reto.skate.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto.skate.model.Admin;
import com.reto.skate.repository.crud.AdminCrudRepositoryInterfaz;

@Repository
public class AdminRepository {
    
    @Autowired
    private AdminCrudRepositoryInterfaz adminCrudRepositoryInterfaz;

    public List<Admin> obtenerAdminCompleta(){
        return (List<Admin>) adminCrudRepositoryInterfaz.findAll();
    }

    public Optional<Admin> obtenerAdminId(Integer id){
        return adminCrudRepositoryInterfaz.findById(id);
    }

    public Admin salvarAdmin(Admin admin){
        return adminCrudRepositoryInterfaz.save(admin);     
    }

    public void delete (Admin admin){
        adminCrudRepositoryInterfaz.delete(admin);
    } 
}
