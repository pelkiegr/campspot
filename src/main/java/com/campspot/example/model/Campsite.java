package com.campspot.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Campsite {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonIgnore
    private NavigableMap<LocalDate, Reservation> reservationMap;

    public Campsite() {
    }

    public Campsite(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NavigableMap<LocalDate, Reservation> getReservationMap() {
        if (reservationMap == null) {
            reservationMap = new TreeMap<>();
        }
        return reservationMap;
    }

    public void addReservation(Reservation reservation) {
        getReservationMap().put(reservation.getStartDate(), reservation);
    }
}
