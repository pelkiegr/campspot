package com.campspot.example.util;

import com.campspot.example.dto.ReservationSearchDto;
import com.campspot.example.model.Campsite;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Test;

import java.net.URL;
import java.time.LocalDate;
import java.util.Collection;

import static org.junit.Assert.*;

public class ReservationUtilTest {

    private ClassLoader classLoader = getClass().getClassLoader();

    @Test
    public void isBetween() {
        LocalDate start = LocalDate.of(2019, 4, 5);
        LocalDate end = LocalDate.of(2019, 4, 29);

        LocalDate d1 = LocalDate.of(2019, 4, 6);
        LocalDate d2 = LocalDate.of(2019, 4, 29);
        LocalDate d3= LocalDate.of(2019, 4, 5);
        LocalDate d4 = LocalDate.of(2019, 4, 30);
        LocalDate d5 = LocalDate.of(2019, 4, 4);
        LocalDate d6 = LocalDate.of(2019, 4, 14);

        assertTrue(ReservationUtil.isBetween(start, end, d1));
        assertTrue(ReservationUtil.isBetween(start, end, d6));

        assertFalse(ReservationUtil.isBetween(start, end, d2));
        assertFalse(ReservationUtil.isBetween(start, end, d3));
        assertFalse(ReservationUtil.isBetween(start, end, d4));
        assertFalse(ReservationUtil.isBetween(start, end, d5));
    }

    @Test
    public void getAvailableCampsites() throws Exception {

        URL url = classLoader.getResource("reservations.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        ReservationSearchDto dto = objectMapper.readValue(url, ReservationSearchDto.class);
        Collection<Campsite> campsites = ReservationUtil.getAvailableCampsites(dto, 1);

        assertEquals(campsites.size(), 2);
    }
}