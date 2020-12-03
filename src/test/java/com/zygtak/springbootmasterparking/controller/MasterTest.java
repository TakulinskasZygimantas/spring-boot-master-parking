package com.zygtak.springbootmasterparking.controller;

import org.hamcrest.Matchers;
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
                .andExpect(jsonPath("$.data.freePercentage").value(12.2))
                .andExpect(jsonPath("$.data.busyPercentage").value(75.7))
                .andExpect(jsonPath("$.data.reservedPercentage").value(12.2))
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
                .andExpect(jsonPath("$.data.reservedPercentage").value(100.0))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("OK"));
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
        mvc.perform(get("/getParkingSpotsBusynessByParkingLotId/291")
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
    void testGetParkingSpotsBusynessByParkingLotId5() throws Exception {
        mvc.perform(get("/getParkingSpotsBusynessByParkingLotId")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andDo(print())

                // check's request meta data
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetBusiestHours1() throws Exception {
        mvc.perform(get("/getBusiestHours/163")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andDo(print())

                // check's request meta data
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                //check if the jason node exist

                .andExpect(jsonPath("$.data.[0].hour").exists())
                .andExpect(jsonPath("$.data.[0].countService").exists())
                .andExpect(jsonPath("$.data.[1].hour").exists())
                .andExpect(jsonPath("$.data.[1].countService").exists())
                .andExpect(jsonPath("$.data.[2].hour").exists())
                .andExpect(jsonPath("$.data.[2].countService").exists())
                .andExpect(jsonPath("$.data.[3].hour").exists())
                .andExpect(jsonPath("$.data.[3].countService").exists())
                .andExpect(jsonPath("$.data.[4].hour").exists())
                .andExpect(jsonPath("$.data.[4].countService").exists())
                .andExpect(jsonPath("$.success").exists())
                .andExpect(jsonPath("$.message").exists())

                //check the type of json node
                .andExpect(jsonPath("$.data.[0].hour").isNumber())
                .andExpect(jsonPath("$.data.[0].countService").isNumber())
                .andExpect(jsonPath("$.data.[1].hour").isNumber())
                .andExpect(jsonPath("$.data.[1].countService").isNumber())
                .andExpect(jsonPath("$.data.[2].hour").isNumber())
                .andExpect(jsonPath("$.data.[2].countService").isNumber())
                .andExpect(jsonPath("$.data.[3].hour").isNumber())
                .andExpect(jsonPath("$.data.[3].countService").isNumber())
                .andExpect(jsonPath("$.data.[4].hour").isNumber())
                .andExpect(jsonPath("$.data.[4].countService").isNumber())
                .andExpect(jsonPath("$.success").isBoolean())
                .andExpect(jsonPath("$.message").isString())

                //check the return value
                .andExpect(jsonPath("$.data.[0].hour").value(12))
                .andExpect(jsonPath("$.data.[0].countService").value(3))
                .andExpect(jsonPath("$.data.[1].hour").value(13))
                .andExpect(jsonPath("$.data.[1].countService").value(3))
                .andExpect(jsonPath("$.data.[2].hour").value(14))
                .andExpect(jsonPath("$.data.[2].countService").value(7))
                .andExpect(jsonPath("$.data.[3].hour").value(15))
                .andExpect(jsonPath("$.data.[3].countService").value(8))
                .andExpect(jsonPath("$.data.[4].hour").value(16))
                .andExpect(jsonPath("$.data.[4].countService").value(10))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("OK"));
    }

    @Test
    void testGetBusiestHours2() throws Exception {
        mvc.perform(get("/getBusiestHours/288")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andDo(print())

                // check's request meta data
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                //check if the jason node exist

                .andExpect(jsonPath("$.data").exists())
                .andExpect(jsonPath("$.success").exists())
                .andExpect(jsonPath("$.message").exists())

                //check the type of json node
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.success").isBoolean())
                .andExpect(jsonPath("$.message").isString())

                //check the return value
                .andExpect(jsonPath("$.data", Matchers.empty()))
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.message").value("Where is no services in this parking lot"));
    }

    @Test
    void testGetBusiestHours3() throws Exception {
        mvc.perform(get("/getBusiestHours/289")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andDo(print())

                // check's request meta data
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                //check if the jason node exist

                .andExpect(jsonPath("$.data.[0].hour").exists())
                .andExpect(jsonPath("$.data.[0].countService").exists())
                .andExpect(jsonPath("$.data.[1].hour").exists())
                .andExpect(jsonPath("$.data.[1].countService").exists())
                .andExpect(jsonPath("$.data.[2].hour").exists())
                .andExpect(jsonPath("$.data.[2].countService").exists())
                .andExpect(jsonPath("$.success").exists())
                .andExpect(jsonPath("$.message").exists())

                //check the type of json node
                .andExpect(jsonPath("$.data.[0].hour").isNumber())
                .andExpect(jsonPath("$.data.[0].countService").isNumber())
                .andExpect(jsonPath("$.data.[1].hour").isNumber())
                .andExpect(jsonPath("$.data.[1].countService").isNumber())
                .andExpect(jsonPath("$.data.[2].hour").isNumber())
                .andExpect(jsonPath("$.data.[2].countService").isNumber())
                .andExpect(jsonPath("$.success").isBoolean())
                .andExpect(jsonPath("$.message").isString())

                //check the return value
                .andExpect(jsonPath("$.data.[0].hour").value(16))
                .andExpect(jsonPath("$.data.[0].countService").value(3))
                .andExpect(jsonPath("$.data.[1].hour").value(17))
                .andExpect(jsonPath("$.data.[1].countService").value(3))
                .andExpect(jsonPath("$.data.[2].hour").value(18))
                .andExpect(jsonPath("$.data.[2].countService").value(3))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("3 is not enough data for research"));
    }

    @Test
    void testGetBusiestHours4() throws Exception {
        mvc.perform(get("/getBusiestHours")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andDo(print())

                // check's request meta data
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetHistoryOfWeekDays() throws Exception {
        mvc.perform(get("/getHistoryOfWeekDays")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andDo(print())

                // check's request meta data
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                //check if the jason node exist

                .andExpect(jsonPath("$.[0].weekDay").exists())
                .andExpect(jsonPath("$.[0].countService").exists())
                .andExpect(jsonPath("$.[1].weekDay").exists())
                .andExpect(jsonPath("$.[1].countService").exists())
                .andExpect(jsonPath("$.[2].weekDay").exists())
                .andExpect(jsonPath("$.[2].countService").exists())
                .andExpect(jsonPath("$.[3].weekDay").exists())
                .andExpect(jsonPath("$.[3].countService").exists())
                .andExpect(jsonPath("$.[4].weekDay").exists())
                .andExpect(jsonPath("$.[4].countService").exists())
                .andExpect(jsonPath("$.[5].weekDay").exists())
                .andExpect(jsonPath("$.[5].countService").exists())
                .andExpect(jsonPath("$.[6].weekDay").exists())
                .andExpect(jsonPath("$.[6].countService").exists())

                //check the type of json node
                .andExpect(jsonPath("$.[0].weekDay").isString())
                .andExpect(jsonPath("$.[0].countService").isNumber())
                .andExpect(jsonPath("$.[1].weekDay").isString())
                .andExpect(jsonPath("$.[1].countService").isNumber())
                .andExpect(jsonPath("$.[2].weekDay").isString())
                .andExpect(jsonPath("$.[2].countService").isNumber())
                .andExpect(jsonPath("$.[3].weekDay").isString())
                .andExpect(jsonPath("$.[3].countService").isNumber())
                .andExpect(jsonPath("$.[4].weekDay").isString())
                .andExpect(jsonPath("$.[4].countService").isNumber())
                .andExpect(jsonPath("$.[5].weekDay").isString())
                .andExpect(jsonPath("$.[5].countService").isNumber())
                .andExpect(jsonPath("$.[6].weekDay").isString())
                .andExpect(jsonPath("$.[6].countService").isNumber())

                //check the return value
                .andExpect(jsonPath("$.[0].weekDay").value("Monday"))
                .andExpect(jsonPath("$.[0].countService").value(3))
                .andExpect(jsonPath("$.[1].weekDay").value("Saturday"))
                .andExpect(jsonPath("$.[1].countService").value(1))
                .andExpect(jsonPath("$.[2].weekDay").value("Thursday"))
                .andExpect(jsonPath("$.[2].countService").value(2))
                .andExpect(jsonPath("$.[3].weekDay").value("Friday"))
                .andExpect(jsonPath("$.[3].countService").value(3))
                .andExpect(jsonPath("$.[4].weekDay").value("Sunday"))
                .andExpect(jsonPath("$.[4].countService").value(7))
                .andExpect(jsonPath("$.[5].weekDay").value("Wednesday"))
                .andExpect(jsonPath("$.[5].countService").value(1))
                .andExpect(jsonPath("$.[6].weekDay").value("Tuesday"))
                .andExpect(jsonPath("$.[6].countService").value(1));
    }

    @Test
    void testGetHistoryOfParkingSpots() throws Exception {
        mvc.perform(get("/getHistoryOfParkingSpots")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andDo(print())

                // check's request meta data
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                //check if the jason node exist

                .andExpect(jsonPath("$.[0].parkingSpot").exists())
                .andExpect(jsonPath("$.[0].countService").exists())
                .andExpect(jsonPath("$.[1].parkingSpot").exists())
                .andExpect(jsonPath("$.[1].countService").exists())
                .andExpect(jsonPath("$.[2].parkingSpot").exists())
                .andExpect(jsonPath("$.[2].countService").exists())

                //check the type of json node
                .andExpect(jsonPath("$.[0].parkingSpot").isNumber())
                .andExpect(jsonPath("$.[0].countService").isNumber())
                .andExpect(jsonPath("$.[1].parkingSpot").isNumber())
                .andExpect(jsonPath("$.[1].countService").isNumber())
                .andExpect(jsonPath("$.[2].parkingSpot").isNumber())
                .andExpect(jsonPath("$.[2].countService").isNumber())

                //check the return value
                .andExpect(jsonPath("$.[0].parkingSpot").value(42))
                .andExpect(jsonPath("$.[0].countService").value(1))
                .andExpect(jsonPath("$.[1].parkingSpot").value(45))
                .andExpect(jsonPath("$.[1].countService").value(1))
                .andExpect(jsonPath("$.[2].parkingSpot").value(40))
                .andExpect(jsonPath("$.[2].countService").value(10));
    }
}