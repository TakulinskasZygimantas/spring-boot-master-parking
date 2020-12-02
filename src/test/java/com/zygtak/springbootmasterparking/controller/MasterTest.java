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

@SpringBootTest
@AutoConfigureMockMvc
class MasterTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void testGetParkingSpotsBusynessByParkingLotId1() throws Exception {
        mvc.perform(get("/getParkingSpotsBusynessByParkingLotId/163")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andDo(print())

                // check's request meta data
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                //check if the jason node exist
                .andExpect(jsonPath("$.data.freePercentage").exists())
                .andExpect(jsonPath("$.data.busyPercentage").exists())
                .andExpect(jsonPath("$.data.reservedPercentage").exists())
                .andExpect(jsonPath("$.success").exists())
                .andExpect(jsonPath("$.message").exists())

                //check the type of json node
                .andExpect(jsonPath("$.data.freePercentage").isNumber())
                .andExpect(jsonPath("$.data.busyPercentage").isNumber())
                .andExpect(jsonPath("$.data.reservedPercentage").isNumber())
                .andExpect(jsonPath("$.success").isBoolean())
                .andExpect(jsonPath("$.message").isString())


                //check the return value
                .andExpect(jsonPath("$.data.freePercentage").value(2.7))
                .andExpect(jsonPath("$.data.busyPercentage").value(94.6))
                .andExpect(jsonPath("$.data.reservedPercentage").value(2.7))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("OK"));
    }

    @Test
    void testGetParkingSpotsBusynessByParkingLotId2() throws Exception {
        mvc.perform(get("/getParkingSpotsBusynessByParkingLotId/289")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andDo(print())

                // check's request meta data
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                //check if the jason node exist
                .andExpect(jsonPath("$.data.freePercentage").exists())
                .andExpect(jsonPath("$.data.busyPercentage").exists())
                .andExpect(jsonPath("$.data.reservedPercentage").exists())
                .andExpect(jsonPath("$.success").exists())
                .andExpect(jsonPath("$.message").exists())

                //check the type of json node
                .andExpect(jsonPath("$.data.freePercentage").isNumber())
                .andExpect(jsonPath("$.data.busyPercentage").isNumber())
                .andExpect(jsonPath("$.data.reservedPercentage").isNumber())
                .andExpect(jsonPath("$.success").isBoolean())
                .andExpect(jsonPath("$.message").isString())


                //check the return value
                .andExpect(jsonPath("$.data.freePercentage").value(0.0))
                .andExpect(jsonPath("$.data.busyPercentage").value(0.0))
                .andExpect(jsonPath("$.data.reservedPercentage").value(0.0))
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.message").value("Where is no parking spots to count"));
    }

    @Test
    void testGetParkingSpotsBusynessByParkingLotId3() throws Exception {
        mvc.perform(get("/getParkingSpotsBusynessByParkingLotId/290")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andDo(print())

                // check's request meta data
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                //check if the jason node exist
                .andExpect(jsonPath("$.data.freePercentage").exists())
                .andExpect(jsonPath("$.data.busyPercentage").exists())
                .andExpect(jsonPath("$.data.reservedPercentage").exists())
                .andExpect(jsonPath("$.success").exists())
                .andExpect(jsonPath("$.message").exists())

                //check the type of json node
                .andExpect(jsonPath("$.data.freePercentage").isNumber())
                .andExpect(jsonPath("$.data.busyPercentage").isNumber())
                .andExpect(jsonPath("$.data.reservedPercentage").isNumber())
                .andExpect(jsonPath("$.success").isBoolean())
                .andExpect(jsonPath("$.message").isString())


                //check the return value
                .andExpect(jsonPath("$.data.freePercentage").value(0.0))
                .andExpect(jsonPath("$.data.busyPercentage").value(0.0))
                .andExpect(jsonPath("$.data.reservedPercentage").value(0.0))
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.message").value("Where is no parking spot status: 3"));
    }

    @Test
    void testGetParkingSpotsBusynessByParkingLotId4() throws Exception {
        mvc.perform(get("/getParkingSpotsBusynessByParkingLotId")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andDo(print())

                // check's request meta data
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetBusiestHours() throws Exception {
        mvc.perform(get("/getBusiestHours")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andDo(print())

                // check's request meta data
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                //check if the jason node exist
                .andExpect(jsonPath("$.[0].hour").exists())
                .andExpect(jsonPath("$.[0].countService").exists())

                .andExpect(jsonPath("$.[1].hour").exists())
                .andExpect(jsonPath("$.[1].countService").exists())

                .andExpect(jsonPath("$.[2].hour").exists())
                .andExpect(jsonPath("$.[2].countService").exists())

                .andExpect(jsonPath("$.[3].hour").exists())
                .andExpect(jsonPath("$.[3].countService").exists())

                .andExpect(jsonPath("$.[4].hour").exists())
                .andExpect(jsonPath("$.[4].countService").exists())

                //check the type of json node
                .andExpect(jsonPath("$.[0].hour").isNumber())
                .andExpect(jsonPath("$.[0].countService").isNumber())

                .andExpect(jsonPath("$.[1].hour").isNumber())
                .andExpect(jsonPath("$.[1].countService").isNumber())

                .andExpect(jsonPath("$.[2].hour").isNumber())
                .andExpect(jsonPath("$.[2].countService").isNumber())

                .andExpect(jsonPath("$.[3].hour").isNumber())
                .andExpect(jsonPath("$.[3].countService").isNumber())

                .andExpect(jsonPath("$.[4].hour").isNumber())
                .andExpect(jsonPath("$.[4].countService").isNumber())

                //check the return value
                .andExpect(jsonPath("$.[0].hour").value(1))
                .andExpect(jsonPath("$.[0].countService").value(4))

                .andExpect(jsonPath("$.[1].hour").value(13))
                .andExpect(jsonPath("$.[1].countService").value(3))

                .andExpect(jsonPath("$.[2].hour").value(14))
                .andExpect(jsonPath("$.[2].countService").value(3))

                .andExpect(jsonPath("$.[3].hour").value(15))
                .andExpect(jsonPath("$.[3].countService").value(4))

                .andExpect(jsonPath("$.[4].hour").value(16))
                .andExpect(jsonPath("$.[4].countService").value(5));
    }

    @Test
    void testGetHistoryOfWeekDays1() throws Exception {
    }
}