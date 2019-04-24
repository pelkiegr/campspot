package com.campspot.example.rest;

import com.campspot.example.dto.ReservationSearchDto;
import com.campspot.example.model.Campsite;
import com.campspot.example.util.ReservationUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ReservationController {

    @RequestMapping(value = "/reservations/campsites", produces = {"application/json"}, consumes = "application/json")
    public Collection<Campsite> getAvailableCampsites(@RequestBody ReservationSearchDto reservationSearchDto) {
        return ReservationUtil.getAvailableCampsites(reservationSearchDto, 1);
    }

}
