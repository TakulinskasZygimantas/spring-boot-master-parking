package com.zygtak.springbootmasterparking.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class ParkingSpotControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void testAddParkingSpot() throws Exception {

        String bodyData = "{\"number\":\"0\",\"status\":\"0\",\"parkingLot\":{\"id\":\"1\"}}";

        mvc.perform(post("/addParkingSpot")
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
                .andExpect(jsonPath("$.number").exists())
                .andExpect(jsonPath("$.status").exists())
                .andExpect(jsonPath("$.parkingLotId").exists())

                //check the type of json node
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.number").isNumber())
                .andExpect(jsonPath("$.status").isNumber())
                .andExpect(jsonPath("$.parkingLotId").isNumber())

                //check the return value
                .andExpect(jsonPath("$.number").value(0))
                .andExpect(jsonPath("$.status").value(0))
                .andExpect(jsonPath("$.parkingLotId").value(1));
    }

    @Test
    void testGetAllParkingSpotsByParkingLotId() throws Exception {
        mvc.perform(get("/allParkingSpotsByParkingLotId/" + 1)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andDo(print())

                // check's request meta data
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                //check if the jason node exist
                .andExpect(jsonPath("$.[0].id").exists())
                .andExpect(jsonPath("$.[0].number").exists())
                .andExpect(jsonPath("$.[0].status").exists())
                .andExpect(jsonPath("$.[0].parkingLotId").exists())

                .andExpect(jsonPath("$.[1].id").exists())
                .andExpect(jsonPath("$.[1].number").exists())
                .andExpect(jsonPath("$.[1].status").exists())
                .andExpect(jsonPath("$.[1].parkingLotId").exists())

                //check the type of json node
                .andExpect(jsonPath("$.[0].id").isNumber())
                .andExpect(jsonPath("$.[0].number").isNumber())
                .andExpect(jsonPath("$.[0].status").isNumber())
                .andExpect(jsonPath("$.[0].parkingLotId").isNotEmpty())

                .andExpect(jsonPath("$.[1].id").isNumber())
                .andExpect(jsonPath("$.[1].number").isNumber())
                .andExpect(jsonPath("$.[1].status").isNumber())
                .andExpect(jsonPath("$.[1].parkingLotId").isNotEmpty())

                //check the return value
                .andExpect(jsonPath("$.[0].id").value(1))
                .andExpect(jsonPath("$.[0].number").value(0))
                .andExpect(jsonPath("$.[0].status").value(0))
                .andExpect(jsonPath("$.[0].parkingLotId").value(1))

                .andExpect(jsonPath("$.[1].id").value(2))
                .andExpect(jsonPath("$.[1].number").value(1))
                .andExpect(jsonPath("$.[1].status").value(1))
                .andExpect(jsonPath("$.[1].parkingLotId").value(1));
    }

    @Test
    void testUpdateParkingSpot() throws Exception {
        String bodyData = "{\"id\":2,\"number\":\"1\",\"status\":\"1\",\"parkingLot\":{\"id\":\"1\"}}";

        mvc.perform(put("/updateParkingSpot")
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
                .andExpect(jsonPath("$.number").exists())
                .andExpect(jsonPath("$.status").exists())
                .andExpect(jsonPath("$.parkingLotId").exists())

                //check the type of json node
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.number").isNumber())
                .andExpect(jsonPath("$.status").isNumber())
                .andExpect(jsonPath("$.parkingLotId").isNumber())

                //check the return value
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.number").value(1))
                .andExpect(jsonPath("$.status").value(1))
                .andExpect(jsonPath("$.parkingLotId").value(1));
    }
}