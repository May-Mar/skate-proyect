package com.reto.skate.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reto.skate.model.Skate;
import com.reto.skate.service.SkateService;


@RestController
@RequestMapping("/api/Skate")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class SkateController {

    @Autowired
    private SkateService skateService;
    @GetMapping("/all")
    public List<Skate> obtenerSkateCompleta(){
        return skateService.obtenerSkateCompleta();
    }

    @GetMapping("/{id}")
    public Optional<Skate> obtenerSkateId(@PathVariable("id")Integer identificador){
        return skateService.obtenerSkateId(identificador);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Skate salvarSkate(@RequestBody Skate skate){
        return skateService.salvarSkate(skate);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Skate update(@RequestBody Skate skate){
        return skateService.update(skate);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")Integer skateId){
        return skateService.deleteSkate(skateId);
    }
    
}
