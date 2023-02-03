package com.reto.skate.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="skate")
@Getter
@Setter

public class Skate  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    
    @Column(name ="years")
    private Integer year;
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("skates")
    private Category category;


    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "skate")
    @JsonIgnoreProperties({"skate", "client"})
    private List<Message> messages; 

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "skate")
    @JsonIgnoreProperties({"skate", "Messages"})
    public List<Reservation> reservations;    

}
