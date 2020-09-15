package com.zygtak.springbootmasterparking.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class ReservationControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void testAddReservation() throws Exception {

        String bodyData = "{\"userId\":\"1\",\"parkingSpotId\":\"1\",\"reservationStart\":\"2000-09-01T00:00:00.000+00:00\",\"reservationEnd\":\"2007-09-07T22:14:12.000+00:00\"}";

        mvc.perform(post("/addReservation")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(bodyData))
                .andDo(print())

                // check's request meta data
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                //check if the jason node exist
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.userId").exists())
                .andExpect(jsonPath("$.parkingSpotId").exists())
                .andExpect(jsonPath("$.reservationStart").exists())
                .andExpect(jsonPath("$.reservationEnd").exists())

                //check the type of json node
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.userId").isNumber())
                .andExpect(jsonPath("$.parkingSpotId").isNumber())
                .andExpect(jsonPath("$.reservationStart").isString())
                .andExpect(jsonPath("$.reservationEnd").isString())

                //check the return value
                .andExpect(jsonPath("$.userId").value(1))
                .andExpect(jsonPath("$.parkingSpotId").value(1))
                .andExpect(jsonPath("$.reservationStart").value("2000-09-01T00:00:00.000+00:00"))
                .andExpect(jsonPath("$.reservationEnd").value("2007-09-07T22:14:12.000+00:00"));
    }

    @Test
    void testGetAllReservationByParkingLotId() throws Exception {
        mvc.perform(get("/allReservationsByUserId/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())

                // check's request meta data
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                //check if the jason node exist
                .andExpect(jsonPath("$.[0].id").exists())
                .andExpect(jsonPath("$.[0].userId").exists())
                .andExpect(jsonPath("$.[0].parkingSpotId").exists())
                .andExpect(jsonPath("$.[0].reservationStart").exists())
                .andExpect(jsonPath("$.[0].reservationEnd").exists())

                .andExpect(jsonPath("$.[1].id").exists())
                .andExpect(jsonPath("$.[1].userId").exists())
                .andExpect(jsonPath("$.[1].parkingSpotId").exists())
                .andExpect(jsonPath("$.[1].reservationStart").exists())
                .andExpect(jsonPath("$.[1].reservationEnd").exists())

                //check the type of json node
                .andExpect(jsonPath("$.[0].id").isNumber())
                .andExpect(jsonPath("$.[0].userId").isNumber())
                .andExpect(jsonPath("$.[0].parkingSpotId").isNumber())
                .andExpect(jsonPath("$.[0].reservationStart").isString())
                .andExpect(jsonPath("$.[0].reservationEnd").isString())

                .andExpect(jsonPath("$.[1].id").isNumber())
                .andExpect(jsonPath("$.[1].userId").isNumber())
                .andExpect(jsonPath("$.[1].parkingSpotId").isNumber())
                .andExpect(jsonPath("$.[1].reservationStart").isString())
                .andExpect(jsonPath("$.[1].reservationEnd").isString())

                //check the return value
                .andExpect(jsonPath("$.[0].id").value(1))
                .andExpect(jsonPath("$.[0].userId").value(1))
                .andExpect(jsonPath("$.[0].parkingSpotId").value(1))
                .andExpect(jsonPath("$.[0].reservationStart").value("2000-09-01T00:00:00.000+00:00"))
                .andExpect(jsonPath("$.[0].reservationEnd").value("2007-09-07T22:14:12.000+00:00"))

                .andExpect(jsonPath("$.[1].id").value(2))
                .andExpect(jsonPath("$.[1].userId").value(1))
                .andExpect(jsonPath("$.[1].parkingSpotId").value(2))
                .andExpect(jsonPath("$.[1].reservationStart").value("2010-09-01T00:00:00.000+00:00"))
                .andExpect(jsonPath("$.[1].reservationEnd").value("2012-09-07T22:14:12.000+00:00"));
    }

    @Test
    void testUpdateReservation() throws Exception {

        String bodyData = "{\"id\":2,\"userId\":\"1\",\"parkingSpotId\":\"2\",\"reservationStart\":\"2010-09-01T00:00:00.000+00:00\",\"reservationEnd\":\"2012-09-07T22:14:12.000+00:00\"}";

        mvc.perform(put("/updateReservation")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(bodyData))
                .andDo(print())

                // check's request meta data
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                //check if the jason node exist
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.userId").exists())
                .andExpect(jsonPath("$.parkingSpotId").exists())
                .andExpect(jsonPath("$.reservationStart").exists())
                .andExpect(jsonPath("$.reservationEnd").exists())

                //check the type of json node
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.userId").isNumber())
                .andExpect(jsonPath("$.parkingSpotId").isNumber())
                .andExpect(jsonPath("$.reservationStart").isString())
                .andExpect(jsonPath("$.reservationEnd").isString())

                //check the return value
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.userId").value(1))
                .andExpect(jsonPath("$.parkingSpotId").value(2))
                .andExpect(jsonPath("$.reservationStart").value("2010-09-01T00:00:00.000+00:00"))
                .andExpect(jsonPath("$.reservationEnd").value("2012-09-07T22:14:12.000+00:00"));
    }

    @Test
    void testDeleteReservation() throws Exception {
        int reservationId = 111;

        mvc.perform(delete("/deleteReservation/" + reservationId))
                .andDo(print())
                .andExpect(status().isOk());
    }
}