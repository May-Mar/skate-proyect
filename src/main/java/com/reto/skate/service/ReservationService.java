package com.reto.skate.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.skate.model.Client;
import com.reto.skate.model.Reservation;
import com.reto.skate.reports.CounterClient;
import com.reto.skate.reports.StatusReservation;
import com.reto.skate.repository.ReservationRepository;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> obtenerReservationCompleta() {
        return reservationRepository.obtenerReservationCompleta();

    }

    public Optional<Reservation> obtenerReservationId(Integer id) {
        return reservationRepository.obtenerReservationId(id);
    }

    public Reservation salvarReservation(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.salvarReservation(reservation);
        } else {
            Optional<Reservation> reservationAuxiliar = reservationRepository
                    .obtenerReservationId(reservation.getIdReservation());
            if (reservationAuxiliar.isEmpty()) {
                return reservationRepository.salvarReservation(reservation);
            } else {
                return reservation;
            }
        }

    }

    public StatusReservation StatusReservation() {

        List<Reservation> completed = reservationRepository.StatusReservation("completed");
        List<Reservation> cancelled = reservationRepository.StatusReservation("cancelled");

        return new StatusReservation(completed.size(), cancelled.size());
    }

    public List<Reservation> ReservationTime(String startDate, String endDate) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

        Date dateOne = new Date();
        Date dateTwo = new Date();

        try {
            dateOne = parser.parse(startDate);
            dateTwo = parser.parse(endDate);
        } catch (ParseException evt) {
            evt.printStackTrace();
        }
        if (dateOne.before(dateTwo)) {
            return reservationRepository.ReservationTime(dateOne, dateTwo);
        } else {
            return new ArrayList<>();
        }
    }

    public List<CounterClient> reportsClients() {
        List<CounterClient> result = new ArrayList<>();
        List<Object[]> report = reservationRepository.reportsClients();
        System.out.println(report);
        for (int i = 0; i < report.size(); i++) {
            result.add(new CounterClient((Long) report.get(i)[1], (Client) report.get(i)[0]));
        }
        return result;
    }
}
