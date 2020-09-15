package com.zygtak.springbootmasterparking.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class ParkingLotControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void testAddParkingLot() throws Exception {

        String bodyData = "{\"name\":\"nameTest\",\"address\":\"addressTest\",\"coordinates\":\"coordinatesTest\",\"tariffDay\":\"1.0\",\"tariffNight\":\"1.0\",\"beginningOfTheWork\":\"06:00:00\",\"endOfTheWork\":\"21:00:00\",\"freeTime\":\"30\"}";

        mvc.perform(post("/addParkingLot")
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
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.address").exists())
                .andExpect(jsonPath("$.coordinates").exists())
                .andExpect(jsonPath("$.tariffDay").exists())
                .andExpect(jsonPath("$.tariffNight").exists())
                .andExpect(jsonPath("$.beginningOfTheWork").exists())
                .andExpect(jsonPath("$.endOfTheWork").exists())
                .andExpect(jsonPath("$.freeTime").exists())

                //check the type of json node
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.name").isString())
                .andExpect(jsonPath("$.address").isString())
                .andExpect(jsonPath("$.coordinates").isString())
                .andExpect(jsonPath("$.tariffDay").isNumber())
                .andExpect(jsonPath("$.tariffNight").isNumber())
                .andExpect(jsonPath("$.beginningOfTheWork").isString())
                .andExpect(jsonPath("$.endOfTheWork").isString())
                .andExpect(jsonPath("$.freeTime").isNumber())

                //check the return value
                .andExpect(jsonPath("$.name").value("nameTest"))
                .andExpect(jsonPath("$.address").value("addressTest"))
                .andExpect(jsonPath("$.coordinates").value("coordinatesTest"))
                .andExpect(jsonPath("$.tariffDay").value(1.0))
                .andExpect(jsonPath("$.tariffNight").value(1.0))
                .andExpect(jsonPath("$.beginningOfTheWork").value("06:00:00"))
                .andExpect(jsonPath("$.endOfTheWork").value("21:00:00"))
                .andExpect(jsonPath("$.freeTime").value(30));
    }

    @Test
    void testGetAllParkingLots() throws Exception {

        mvc.perform(get("/parkingLots")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andDo(print())

                // check's request meta data
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                //check if the jason node exist
                .andExpect(jsonPath("$.[0].id").exists())
                .andExpect(jsonPath("$.[0].name").exists())
                .andExpect(jsonPath("$.[0].address").exists())
                .andExpect(jsonPath("$.[0].coordinates").exists())
                .andExpect(jsonPath("$.[0].tariffDay").exists())
                .andExpect(jsonPath("$.[0].tariffNight").exists())
                .andExpect(jsonPath("$.[0].beginningOfTheWork").exists())
                .andExpect(jsonPath("$.[0].endOfTheWork").exists())
                .andExpect(jsonPath("$.[0].freeTime").exists())

                .andExpect(jsonPath("$.[1].id").exists())
                .andExpect(jsonPath("$.[1].name").exists())
                .andExpect(jsonPath("$.[1].address").exists())
                .andExpect(jsonPath("$.[1].coordinates").exists())
                .andExpect(jsonPath("$.[1].tariffDay").exists())
                .andExpect(jsonPath("$.[1].tariffNight").exists())
                .andExpect(jsonPath("$.[1].beginningOfTheWork").exists())
                .andExpect(jsonPath("$.[1].endOfTheWork").exists())
                .andExpect(jsonPath("$.[1].freeTime").exists())

                //check the type of json node
                .andExpect(jsonPath("$.[0].id").isNumber())
                .andExpect(jsonPath("$.[0].name").isString())
                .andExpect(jsonPath("$.[0].address").isString())
                .andExpect(jsonPath("$.[0].coordinates").isString())
                .andExpect(jsonPath("$.[0].tariffDay").isNumber())
                .andExpect(jsonPath("$.[0].tariffNight").isNumber())
                .andExpect(jsonPath("$.[0].beginningOfTheWork").isString())
                .andExpect(jsonPath("$.[0].endOfTheWork").isString())
                .andExpect(jsonPath("$.[0].freeTime").isNumber())

                .andExpect(jsonPath("$.[1].id").isNumber())
                .andExpect(jsonPath("$.[1].name").isString())
                .andExpect(jsonPath("$.[1].address").isString())
                .andExpect(jsonPath("$.[1].coordinates").isString())
                .andExpect(jsonPath("$.[1].tariffDay").isNumber())
                .andExpect(jsonPath("$.[1].tariffNight").isNumber())
                .andExpect(jsonPath("$.[1].beginningOfTheWork").isString())
                .andExpect(jsonPath("$.[1].endOfTheWork").isString())
                .andExpect(jsonPath("$.[1].freeTime").isNumber())

                //check the return value
                .andExpect(jsonPath("$.[0].id").value(1))
                .andExpect(jsonPath("$.[0].name").value("nameTest"))
                .andExpect(jsonPath("$.[0].address").value("addressTest"))
                .andExpect(jsonPath("$.[0].coordinates").value("coordinatesTest"))
                .andExpect(jsonPath("$.[0].tariffDay").value(1.0))
                .andExpect(jsonPath("$.[0].tariffNight").value(1.0))
                .andExpect(jsonPath("$.[0].beginningOfTheWork").value("06:00:00"))
                .andExpect(jsonPath("$.[0].endOfTheWork").value("21:00:00"))
                .andExpect(jsonPath("$.[0].freeTime").value(30))

                .andExpect(jsonPath("$.[1].id").value(2))
                .andExpect(jsonPath("$.[1].name").value("nameTest"))
                .andExpect(jsonPath("$.[1].address").value("addressTest"))
                .andExpect(jsonPath("$.[1].coordinates").value("coordinatesTest"))
                .andExpect(jsonPath("$.[1].tariffDay").value(1.0))
                .andExpect(jsonPath("$.[1].tariffNight").value(1.0))
                .andExpect(jsonPath("$.[1].beginningOfTheWork").value("06:00:00"))
                .andExpect(jsonPath("$.[1].endOfTheWork").value("21:00:00"))
                .andExpect(jsonPath("$.[1].freeTime").value(30));
    }

    @Test
    void testGetParkingLotById() throws Exception {
        mvc.perform(get("/getParkingLotById/" + 1)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andDo(print())

                // check's request meta data
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                //check if the jason node exist
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.address").exists())
                .andExpect(jsonPath("$.coordinates").exists())
                .andExpect(jsonPath("$.tariffDay").exists())
                .andExpect(jsonPath("$.tariffNight").exists())
                .andExpect(jsonPath("$.beginningOfTheWork").exists())
                .andExpect(jsonPath("$.endOfTheWork").exists())
                .andExpect(jsonPath("$.freeTime").exists())

                //check the type of json node
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.name").isString())
                .andExpect(jsonPath("$.address").isString())
                .andExpect(jsonPath("$.coordinates").isString())
                .andExpect(jsonPath("$.tariffDay").isNumber())
                .andExpect(jsonPath("$.tariffNight").isNumber())
                .andExpect(jsonPath("$.beginningOfTheWork").isString())
                .andExpect(jsonPath("$.endOfTheWork").isString())
                .andExpect(jsonPath("$.freeTime").isNumber())

                //check the return value
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("nameTest"))
                .andExpect(jsonPath("$.address").value("addressTest"))
                .andExpect(jsonPath("$.coordinates").value("coordinatesTest"))
                .andExpect(jsonPath("$.tariffDay").value(1.0))
                .andExpect(jsonPath("$.tariffNight").value(1.0))
                .andExpect(jsonPath("$.beginningOfTheWork").value("06:00:00"))
                .andExpect(jsonPath("$.endOfTheWork").value("21:00:00"))
                .andExpect(jsonPath("$.freeTime").value(30));
    }
}