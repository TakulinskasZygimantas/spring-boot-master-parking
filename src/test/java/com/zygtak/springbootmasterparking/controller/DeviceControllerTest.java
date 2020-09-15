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
class DeviceControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void testAddDevice() throws Exception {
        String bodyData = "{\"mac\":\"macTest\",\"name\":\"nameTest\",\"status\":\"0\",\"userId\":\"1\"}";

        mvc.perform(post("/addDevice", 1)
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
                .andExpect(jsonPath("$.mac").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.status").exists())
                .andExpect(jsonPath("$.userId").exists())

                //check the type of json node
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.mac").isString())
                .andExpect(jsonPath("$.name").isString())
                .andExpect(jsonPath("$.status").isNumber())
                .andExpect(jsonPath("$.userId").isNumber())

                //check the return value
                .andExpect(jsonPath("$.mac").value("macTest"))
                .andExpect(jsonPath("$.name").value("nameTest"))
                .andExpect(jsonPath("$.status").value(0))
                .andExpect(jsonPath("$.userId").value(1));
    }

    @Test
    void testGetDeviceById() throws Exception {
        mvc.perform(get("/deviceById/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())

                // check's request meta data
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                //check if the jason node exist
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.mac").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.status").exists())
                .andExpect(jsonPath("$.userId").exists())

                //check the type of json node
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.mac").isString())
                .andExpect(jsonPath("$.name").isString())
                .andExpect(jsonPath("$.status").isNumber())
                .andExpect(jsonPath("$.userId").isNumber())

                //check the return value
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.mac").value("macTest"))
                .andExpect(jsonPath("$.name").value("nameTest"))
                .andExpect(jsonPath("$.status").value(0))
                .andExpect(jsonPath("$.userId").value(1));
    }

    @Test
    void testGetAllDevices() throws Exception {
        mvc.perform(get("/allDevicesByUserId/" + 1)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andDo(print())

                // check's request meta data
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                //check if the jason node exist
                .andExpect(jsonPath("$.[0].id").exists())
                .andExpect(jsonPath("$.[0].mac").exists())
                .andExpect(jsonPath("$.[0].name").exists())
                .andExpect(jsonPath("$.[0].status").exists())
                .andExpect(jsonPath("$.[0].userId").exists())

                .andExpect(jsonPath("$.[1].id").exists())
                .andExpect(jsonPath("$.[1].mac").exists())
                .andExpect(jsonPath("$.[1].name").exists())
                .andExpect(jsonPath("$.[1].status").exists())
                .andExpect(jsonPath("$.[1].userId").exists())

                //check the type of json node
                .andExpect(jsonPath("$.[0].id").isNumber())
                .andExpect(jsonPath("$.[0].mac").isString())
                .andExpect(jsonPath("$.[0].name").isString())
                .andExpect(jsonPath("$.[0].status").isNumber())
                .andExpect(jsonPath("$.[0].userId").isNumber())

                .andExpect(jsonPath("$.[1].id").isNumber())
                .andExpect(jsonPath("$.[1].mac").isString())
                .andExpect(jsonPath("$.[1].name").isString())
                .andExpect(jsonPath("$.[1].status").isNumber())
                .andExpect(jsonPath("$.[1].userId").isNumber())

                //check the return value
                .andExpect(jsonPath("$.[0].id").value(1))
                .andExpect(jsonPath("$.[0].mac").value("macTest"))
                .andExpect(jsonPath("$.[0].name").value("nameTest"))
                .andExpect(jsonPath("$.[0].status").value(0))
                .andExpect(jsonPath("$.[0].userId").value(1))

                //check the return value
                .andExpect(jsonPath("$.[1].id").value(2))
                .andExpect(jsonPath("$.[1].mac").value("macTestUpdated"))
                .andExpect(jsonPath("$.[1].name").value("nameTestUpdated"))
                .andExpect(jsonPath("$.[1].status").value(0))
                .andExpect(jsonPath("$.[1].userId").value(1));
    }

    @Test
    void testUpdateDevice() throws Exception {
        String bodyData = "{\"id\":2,\"mac\":\"macTestUpdated\",\"name\":\"nameTestUpdated\",\"status\":\"0\",\"userId\":\"1\"}";

        mvc.perform(put("/updateDevice")
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
                .andExpect(jsonPath("$.mac").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.status").exists())
                .andExpect(jsonPath("$.userId").exists())

                //check the type of json node
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.mac").isString())
                .andExpect(jsonPath("$.name").isString())
                .andExpect(jsonPath("$.status").isNumber())
                .andExpect(jsonPath("$.userId").isNumber())

                //check the return value
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.mac").value("macTestUpdated"))
                .andExpect(jsonPath("$.name").value("nameTestUpdated"))
                .andExpect(jsonPath("$.status").value(0))
                .andExpect(jsonPath("$.userId").value(1));
    }

    @Test
    void testDeleteDevice() throws Exception {
        int deviceId = 89;

        mvc.perform(delete("/deleteDevice/" + deviceId))
                .andDo(print())
                .andExpect(status().isOk());
    }
}