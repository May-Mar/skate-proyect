package com.reto.skate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.skate.model.Skate;
import com.reto.skate.repository.SkateRepository;

@Service
public class SkateService {
    
    @Autowired
    private SkateRepository skateRepository;

    public List<Skate> obtenerSkateCompleta(){
        return skateRepository.obtenerSkateCompleta();

    }

    public Optional<Skate> obtenerSkateId(Integer id){
        return skateRepository.obtenerSkateId(id);
    }

    public Skate salvarSkate(Skate skate){
        if(skate.getId()==null){
            return skateRepository.salvarSkate(skate);
            }
            else{
                Optional<Skate> skateAuxiliar=skateRepository.obtenerSkateId(skate.getId());
                if(skateAuxiliar.isEmpty()){
                    return skateRepository.salvarSkate(skate);
                }
                else{
                    return skate;
                }
                    
            }  
        }

        public Skate update (Skate skate){
            if(skate.getId()!=null){
                Optional<Skate>skateAuxiliar=skateRepository.obtenerSkateId(skate.getId());
                if(!skateAuxiliar.isEmpty()){
                    if(skate.getName()!=null){
                        skateAuxiliar.get().setName(skate.getName());
                    }
                    if(skate.getYear()!=null){
                        skateAuxiliar.get().setYear(skate.getYear());
                    }
                    if(skate.getBrand()!=null){
                        skateAuxiliar.get().setBrand(skate.getBrand());
                    }
                    if(skate.getDescription()!=null){
                        skateAuxiliar.get().setDescription(skate.getDescription());
                    }
                    if(skate.getCategory()!=null){
                        skateAuxiliar.get().setCategory(skate.getCategory());
                    }
                    skateRepository.salvarSkate(skateAuxiliar.get());
                    return skateAuxiliar.get();
                }else{
                    return skate;
                }
            }else {
                return skate;        
            }
        }
    
        public boolean deleteSkate(Integer skateId){
            boolean flag=false;
            Optional<Skate> skateAuxiliar = skateRepository.obtenerSkateId(skateId);
            if(skateAuxiliar.isPresent()){
                skateRepository.delete(skateAuxiliar.get());
                flag=true;
            }
            return flag;
        } 
}
