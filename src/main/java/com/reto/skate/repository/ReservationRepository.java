package com.reto.skate.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto.skate.model.Reservation;
import com.reto.skate.repository.crud.ReservationCrudRepositoryInterfaz;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepositoryInterfaz reservationCrudRepositoryInterfaz;

    public List<Reservation> obtenerReservationCompleta(){
        return (List<Reservation>) reservationCrudRepositoryInterfaz.findAll();
    }

    public Optional<Reservation> obtenerReservationId(Integer id){
        return reservationCrudRepositoryInterfaz.findById(id);
    }

    public Reservation salvarReservation(Reservation reservation){
        return reservationCrudRepositoryInterfaz.save(reservation);     
    }

    public List<Reservation> StatusReservation(String status){
        return reservationCrudRepositoryInterfaz.findAllByStatus(status);
    }

    public List<Reservation> ReservationTime(Date startDate, Date endDate){
        return reservationCrudRepositoryInterfaz.findAllByStartDateAfterAndStartDateBefore(startDate, endDate);
    }

       
    public   List<Object[]> reportsClients() {
        return reservationCrudRepositoryInterfaz.reportsClients();

    }
}
