package com.zygtak.springbootmasterparking.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class ParkingServiceControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void testAddParkingService() throws Exception {

        String bodyData = "{\"userId\":\"1\",\"parkingSpotId\":\"1\",\"mac\":\"test1234\",\"parkingStart\":\"2000-09-01T00:00:00.000+00:00\",\"parkingEnd\":\"2007-09-07T22:14:12.000+00:00\"}";

        mvc.perform(post("/addParkingService")
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
                .andExpect(jsonPath("$.mac").exists())
                .andExpect(jsonPath("$.parkingStart").exists())
                .andExpect(jsonPath("$.parkingEnd").exists())

                //check the type of json node
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.userId").isNumber())
                .andExpect(jsonPath("$.parkingSpotId").isNumber())
                .andExpect(jsonPath("$.mac").isString())
                .andExpect(jsonPath("$.parkingStart").isString())
                .andExpect(jsonPath("$.parkingEnd").isString())

                //check the return value
                .andExpect(jsonPath("$.userId").value(1))
                .andExpect(jsonPath("$.parkingSpotId").value(1))
                .andExpect(jsonPath("$.mac").value("test1234"))
                .andExpect(jsonPath("$.parkingStart").value("2000-09-01T00:00:00.000+00:00"))
                .andExpect(jsonPath("$.parkingEnd").value("2007-09-07T22:14:12.000+00:00"));
    }

    @Test
    void testGetAllParkingServicesByUserId() throws Exception {
        mvc.perform(get("/allParkingServicesByUserId/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())

                // check's request meta data
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                //check if the jason node exist
                .andExpect(jsonPath("$.[0].id").exists())
                .andExpect(jsonPath("$.[0].userId").exists())
                .andExpect(jsonPath("$.[0].parkingSpotId").exists())
                .andExpect(jsonPath("$.[0].mac").exists())
                .andExpect(jsonPath("$.[0].parkingStart").exists())
                .andExpect(jsonPath("$.[0].parkingEnd").exists())

                .andExpect(jsonPath("$.[1].id").exists())
                .andExpect(jsonPath("$.[1].userId").exists())
                .andExpect(jsonPath("$.[1].parkingSpotId").exists())
                .andExpect(jsonPath("$.[1].mac").exists())
                .andExpect(jsonPath("$.[1].parkingStart").exists())
                .andExpect(jsonPath("$.[1].parkingEnd").exists())

                //check the type of json node
                .andExpect(jsonPath("$.[0].id").isNumber())
                .andExpect(jsonPath("$.[0].userId").isNumber())
                .andExpect(jsonPath("$.[0].parkingSpotId").isNumber())
                .andExpect(jsonPath("$.[0].mac").isString())
                .andExpect(jsonPath("$.[0].parkingStart").isString())
                .andExpect(jsonPath("$.[0].parkingEnd").isString())

                .andExpect(jsonPath("$.[1].id").isNumber())
                .andExpect(jsonPath("$.[1].userId").isNumber())
                .andExpect(jsonPath("$.[1].parkingSpotId").isNumber())
                .andExpect(jsonPath("$.[1].mac").isString())
                .andExpect(jsonPath("$.[1].parkingStart").isString())
                .andExpect(jsonPath("$.[1].parkingEnd").isString())

                //check the return value
                .andExpect(jsonPath("$.[0].id").value(1))
                .andExpect(jsonPath("$.[0].userId").value(1))
                .andExpect(jsonPath("$.[0].parkingSpotId").value(1))
                .andExpect(jsonPath("$.[0].mac").value("test1234"))
                .andExpect(jsonPath("$.[0].parkingStart").value("2000-09-01T00:00:00.000+00:00"))
                .andExpect(jsonPath("$.[0].parkingEnd").value("2007-09-07T22:14:12.000+00:00"))

                .andExpect(jsonPath("$.[1].id").value(2))
                .andExpect(jsonPath("$.[1].userId").value(1))
                .andExpect(jsonPath("$.[1].parkingSpotId").value(2))
                .andExpect(jsonPath("$.[1].mac").value("testUp12"))
                .andExpect(jsonPath("$.[1].parkingStart").value("2010-09-01T00:00:00.000+00:00"))
                .andExpect(jsonPath("$.[1].parkingEnd").value("2012-09-07T22:14:12.000+00:00"));
    }

    @Test
    void testUpdateParkingService() throws Exception {

        String bodyData = "{\"id\":2,\"userId\":\"1\",\"parkingSpotId\":\"2\",\"mac\":\"testUp12\",\"parkingStart\":\"2010-09-01T00:00:00.000+00:00\",\"parkingEnd\":\"2012-09-07T22:14:12.000+00:00\"}";

        mvc.perform(put("/updateParkingService")
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
                .andExpect(jsonPath("$.mac").exists())
                .andExpect(jsonPath("$.parkingStart").exists())
                .andExpect(jsonPath("$.parkingEnd").exists())

                //check the type of json node
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.userId").isNumber())
                .andExpect(jsonPath("$.parkingSpotId").isNumber())
                .andExpect(jsonPath("$.mac").isString())
                .andExpect(jsonPath("$.parkingStart").isString())
                .andExpect(jsonPath("$.parkingEnd").isString())

                //check the return value
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.userId").value(1))
                .andExpect(jsonPath("$.parkingSpotId").value(2))
                .andExpect(jsonPath("$.mac").value("testUp12"))
                .andExpect(jsonPath("$.parkingStart").value("2010-09-01T00:00:00.000+00:00"))
                .andExpect(jsonPath("$.parkingEnd").value("2012-09-07T22:14:12.000+00:00"));
    }

    @Test
    void testDeleteParkingService() throws Exception {
        int parkingServiceId = 113;

        mvc.perform(delete("/deleteParkingService/{id}", parkingServiceId))
                .andDo(print())
                .andExpect(status().isOk());
    }
}