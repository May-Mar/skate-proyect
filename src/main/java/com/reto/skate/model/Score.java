package com.reto.skate.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="score")
@Getter
@Setter

public class Score implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idScore; 
    private String messageText;
    private Integer stars;
    
    @OneToOne
    @JsonIgnoreProperties("score")
    private Reservation reservation;

}
