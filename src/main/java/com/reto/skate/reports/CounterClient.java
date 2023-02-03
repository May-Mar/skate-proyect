package com.reto.skate.reports;

import com.reto.skate.model.Client;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CounterClient {
    
    private Long total;
    private Client client;

    public CounterClient(Long total, Client client) {
        this.total = total;
        this.client = client;
    }
}