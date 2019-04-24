package com.campspot.example.util;

import com.campspot.example.dto.ReservationSearchDto;
import com.campspot.example.model.Campsite;
import com.campspot.example.model.Reservation;
import com.campspot.example.model.search.DateSearch;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReservationUtil {

    /**
     * Check if a date is between the given start and end dates (non-inclusive)
     *
     * @param start the start date
     * @param end   the end date
     * @param date  the date to check
     * @return true if the date is between start and end, otherwise false
     */
    public static boolean isBetween(LocalDate start, LocalDate end, LocalDate date) {
        return date.isAfter(start) && date.isBefore(end);
    }

    public static Collection<Campsite> getAvailableCampsites(ReservationSearchDto reservationSearchDto, int minGap) {
        DateSearch dateSearch = reservationSearchDto.getSearch();
        Collection<Campsite> campsites = reservationSearchDto.getCampsites();
        Collection<Reservation> reservations = reservationSearchDto.getReservations();

        Map<Long, Campsite> availableCampsites = campsites.stream()
                .collect(Collectors.toMap(Campsite::getId, Function.identity()));

        removeUnavailableCampsites(minGap, dateSearch, reservations, availableCampsites);
        return availableCampsites.values();
    }

    /**
     * Remove unavailable campsites from the map
     *
     * @param minGap       the minimum night gap
     * @param dateSearch   the date search
     * @param reservations the reservations
     * @param campsiteMap  map of id to campsite
     */
    private static void removeUnavailableCampsites(int minGap, DateSearch dateSearch, Collection<Reservation> reservations,
                                                   Map<Long, Campsite> campsiteMap) {
        for (Reservation reservation : reservations) {
            if (!campsiteMap.containsKey(reservation.getCampsiteId())) {
                continue;
            }

            LocalDate adjustedResStart = reservation.getStartDate().minusDays(minGap + 1);
            LocalDate adjustedResEnd = reservation.getEndDate().plusDays(minGap + 1);

            if (ReservationUtil.isBetween(adjustedResStart, adjustedResEnd, dateSearch.getStartDate()) ||
                    ReservationUtil.isBetween(adjustedResStart, adjustedResEnd, dateSearch.getEndDate())) {

                campsiteMap.remove(reservation.getCampsiteId());
            }
        }
    }
}
