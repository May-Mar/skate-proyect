package com.reto.skate.repository.crud;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.reto.skate.model.Reservation;

public interface ReservationCrudRepositoryInterfaz extends CrudRepository<Reservation, Integer> {

    public List<Reservation> findAllByStatus(String status);

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date startDate, Date endDate);

    @Query("SELECT c.client, COUNT(c.client) from Reservation  AS c  group by c.client order by COUNT(c.client)DESC ")
    public List<Object[]> reportsClients();    
}
