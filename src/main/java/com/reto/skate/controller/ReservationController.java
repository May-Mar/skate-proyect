package com.reto.skate.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reto.skate.model.Reservation;
import com.reto.skate.reports.CounterClient;
import com.reto.skate.reports.StatusReservation;
import com.reto.skate.service.ReservationService;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {
    
    @Autowired
    private ReservationService reservationService;
    @GetMapping("/all")
    public List<Reservation> obtenerReservationCompleta(){
        return reservationService.obtenerReservationCompleta();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> obtenerReservationId(@PathVariable("id")Integer identificador){
        return reservationService.obtenerReservationId(identificador);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation salvarReservation(@RequestBody Reservation reservation){
        return reservationService.salvarReservation(reservation);
    }

    @GetMapping("/report-status")
    public StatusReservation getStatusReservation() {
        return reservationService.StatusReservation();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationTime(@PathVariable("dateOne") String startDate,@PathVariable("dateTwo") String endDate) {
        return reservationService.ReservationTime(startDate, endDate);
    }

    @GetMapping("/report-clients")
    public List<CounterClient> getClient() {
        return reservationService.reportsClients();
    }
}
