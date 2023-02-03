package com.reto.skate.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.skate.model.Admin;
import com.reto.skate.repository.AdminRepository;

@Service
public class AdminService {
    
    @Autowired
    public AdminRepository adminRepository;
    public List<Admin> obtenerAdminCompleta(){
        return adminRepository.obtenerAdminCompleta();

    }

    public Optional<Admin> obtenerAdminId(Integer id){
        return adminRepository.obtenerAdminId(id);
    }

    public Admin salvarAdmin(Admin admin){
        if(admin.getIdAdmin()==null){
            return adminRepository.salvarAdmin(admin);
        }
        else{
            Optional <Admin> adminAuxiliar = adminRepository.obtenerAdminId(admin.getIdAdmin());
            if(adminAuxiliar.isEmpty()){
                return adminRepository.salvarAdmin(admin);
            }
            else{
                return admin;
            }
        }

    }

    public Admin updateAdmin(Admin admin){
        if(admin.getIdAdmin()!=null){
            Optional<Admin>adminAuxiliar = adminRepository.obtenerAdminId(admin.getIdAdmin());
            if(!adminAuxiliar.isEmpty()){
                if(admin.getEmail()!=null){
                    adminAuxiliar.get().setEmail(admin.getEmail());
                }
                if(admin.getPassword()!=null){
                    adminAuxiliar.get().setPassword(admin.getPassword());
                }
                if(admin.getName()!=null){
                    adminAuxiliar.get().setName(admin.getName());
                }
                return adminRepository.salvarAdmin(adminAuxiliar.get());
            }
        }
        return admin;
    }

    public boolean deleteAdmin(Integer id){
        boolean flag=false;
        Optional<Admin> adminAuxiliar = adminRepository.obtenerAdminId(id);
        if(adminAuxiliar.isPresent()){
            adminRepository.delete(adminAuxiliar.get());
            flag=true;
        }
        return flag;
    }

}
