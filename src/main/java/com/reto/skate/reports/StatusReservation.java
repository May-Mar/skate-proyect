package com.reto.skate.reports;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusReservation {
    
    private Integer completed;
    private Integer cancelled;

    public StatusReservation(Integer completed, Integer cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }
}