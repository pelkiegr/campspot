package com.campspot.example.dto;

import com.campspot.example.model.Campsite;
import com.campspot.example.model.Reservation;
import com.campspot.example.model.search.DateSearch;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public class ReservationSearchDto {

    @JsonProperty("search")
    private DateSearch search;

    @JsonProperty("campsites")
    private Collection<Campsite> campsites;

    @JsonProperty("reservations")
    private Collection<Reservation> reservations;

    public DateSearch getSearch() {
        return search;
    }

    public void setSearch(DateSearch search) {
        this.search = search;
    }

    public Collection<Campsite> getCampsites() {
        return campsites;
    }

    public void setCampsites(Collection<Campsite> campsites) {
        this.campsites = campsites;
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Collection<Reservation> reservations) {
        this.reservations = reservations;
    }
}
