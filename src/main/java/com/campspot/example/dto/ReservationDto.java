package com.campspot.example.dto;

import com.campspot.example.model.Campsite;

import java.util.Collection;

public class ReservationDto {

    Collection<Campsite> campsites;

    public Collection<Campsite> getCampsites() {
        return campsites;
    }

    public void setCampsites(Collection<Campsite> campsites) {
        this.campsites = campsites;
    }
}
