package com.campspot.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Reservation {

    @JsonProperty("campsiteId")
    private long campsiteId;

    @JsonProperty("startDate")
    private LocalDate startDate;

    @JsonProperty("endDate")
    private LocalDate endDate;

    public Reservation(long campsiteId, LocalDate startDate, LocalDate endDate) {
        this.campsiteId = campsiteId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Reservation() {
    }

    public long getCampsiteId() {
        return campsiteId;
    }

    public void setCampsiteId(long campsiteId) {
        this.campsiteId = campsiteId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
