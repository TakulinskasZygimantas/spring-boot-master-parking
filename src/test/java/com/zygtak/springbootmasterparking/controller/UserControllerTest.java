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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void addUser() throws Exception {

        String bodyData = "{\"name\":\"nameTest\",\"surname\":\"surnameTest\",\"email\":\"emailTest@gmail.com\",\"password\":\"passwordTest\"}";

        mvc.perform(post("/addUser")
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
                .andExpect(jsonPath("$.surname").exists())
                .andExpect(jsonPath("$.email").exists())
                .andExpect(jsonPath("$.password").exists())

                //check the type of json node
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.name").isString())
                .andExpect(jsonPath("$.surname").isString())
                .andExpect(jsonPath("$.email").isString())
                .andExpect(jsonPath("$.password").isString())

                //check the return value
                .andExpect(jsonPath("$.name").value("nameTest"))
                .andExpect(jsonPath("$.surname").value("surnameTest"))
                .andExpect(jsonPath("$.email").value("emailTest@gmail.com"))
                .andExpect(jsonPath("$.password").value("passwordTest"));
    }

    @Test
    void addUsers() throws Exception {

        String bodyData = "[{\"name\":\"nameTest1\",\"surname\":\"surnameTest1\",\"email\":\"emailTest1@gmail.com\",\"password\":\"passwordTest1\"}," +
                "{\"name\":\"nameTest2\",\"surname\":\"surnameTest2\",\"email\":\"emailTest2@gmail.com\",\"password\":\"passwordTest2\"}]";

        mvc.perform(post("/addUsers")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(bodyData))
                .andDo(print())

                // check's request meta data
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                //check if the jason node exist
                .andExpect(jsonPath("$.[0].id").exists())
                .andExpect(jsonPath("$.[0].name").exists())
                .andExpect(jsonPath("$.[0].surname").exists())
                .andExpect(jsonPath("$.[0].email").exists())
                .andExpect(jsonPath("$.[0].password").exists())

                .andExpect(jsonPath("$.[1].id").exists())
                .andExpect(jsonPath("$.[1].name").exists())
                .andExpect(jsonPath("$.[1].surname").exists())
                .andExpect(jsonPath("$.[1].email").exists())
                .andExpect(jsonPath("$.[1].password").exists())

                //check the type of json node
                .andExpect(jsonPath("$.[0].id").isNumber())
                .andExpect(jsonPath("$.[0].name").isString())
                .andExpect(jsonPath("$.[0].surname").isString())
                .andExpect(jsonPath("$.[0].email").isString())
                .andExpect(jsonPath("$.[0].password").isString())

                .andExpect(jsonPath("$.[1].id").isNumber())
                .andExpect(jsonPath("$.[1].name").isString())
                .andExpect(jsonPath("$.[1].surname").isString())
                .andExpect(jsonPath("$.[1].email").isString())
                .andExpect(jsonPath("$.[1].password").isString())

                //check the return value
                .andExpect(jsonPath("$.[0].name").value("nameTest1"))
                .andExpect(jsonPath("$.[0].surname").value("surnameTest1"))
                .andExpect(jsonPath("$.[0].email").value("emailTest1@gmail.com"))
                .andExpect(jsonPath("$.[0].password").value("passwordTest1"))

                .andExpect(jsonPath("$.[1].name").value("nameTest2"))
                .andExpect(jsonPath("$.[1].surname").value("surnameTest2"))
                .andExpect(jsonPath("$.[1].email").value("emailTest2@gmail.com"))
                .andExpect(jsonPath("$.[1].password").value("passwordTest2"));
    }

    @Test
    void testGetUserById() throws Exception {
        mvc.perform(get("/userById/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())

                // check's request meta data
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                //check if the jason node exist
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.surname").exists())
                .andExpect(jsonPath("$.email").exists())
                .andExpect(jsonPath("$.password").exists())

                //check the type of json node
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.name").isString())
                .andExpect(jsonPath("$.surname").isString())
                .andExpect(jsonPath("$.email").isString())
                .andExpect(jsonPath("$.password").isString())

                //check the return value
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("nameFinalTest"))
                .andExpect(jsonPath("$.surname").value("surnameFinalTest"))
                .andExpect(jsonPath("$.email").value("emailFinalTest@gmail.com"))
                .andExpect(jsonPath("$.password").value("passwordFinalTest"));
    }

    @Test
    void testGetUserByEmail() throws Exception {
        mvc.perform(get("/userByEmail/{email}", "emailFinalTest@gmail.com")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())

                // check's request meta data
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                //check if the jason node exist
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.surname").exists())
                .andExpect(jsonPath("$.email").exists())
                .andExpect(jsonPath("$.password").exists())

                //check the type of json node
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.name").isString())
                .andExpect(jsonPath("$.surname").isString())
                .andExpect(jsonPath("$.email").isString())
                .andExpect(jsonPath("$.password").isString())

                //check the return value
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("nameFinalTest"))
                .andExpect(jsonPath("$.surname").value("surnameFinalTest"))
                .andExpect(jsonPath("$.email").value("emailFinalTest@gmail.com"))
                .andExpect(jsonPath("$.password").value("passwordFinalTest"));
    }

    @Test
    void testGetAllUsers() throws Exception {
        mvc.perform(get("/users")
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
                .andExpect(jsonPath("$.[0].surname").exists())
                .andExpect(jsonPath("$.[0].email").exists())
                .andExpect(jsonPath("$.[0].password").exists())

                .andExpect(jsonPath("$.[1].id").exists())
                .andExpect(jsonPath("$.[1].name").exists())
                .andExpect(jsonPath("$.[1].surname").exists())
                .andExpect(jsonPath("$.[1].email").exists())
                .andExpect(jsonPath("$.[1].password").exists())

                //check the type of json node
                .andExpect(jsonPath("$.[0].id").isNumber())
                .andExpect(jsonPath("$.[0].name").isString())
                .andExpect(jsonPath("$.[0].surname").isString())
                .andExpect(jsonPath("$.[0].email").isString())
                .andExpect(jsonPath("$.[0].password").isString())

                .andExpect(jsonPath("$.[1].id").isNumber())
                .andExpect(jsonPath("$.[1].name").isString())
                .andExpect(jsonPath("$.[1].surname").isString())
                .andExpect(jsonPath("$.[1].email").isString())
                .andExpect(jsonPath("$.[1].password").isString())

                //check the return value
                .andExpect(jsonPath("$.[0].id").value(1))
                .andExpect(jsonPath("$.[0].name").value("nameFinalTest"))
                .andExpect(jsonPath("$.[0].surname").value("surnameFinalTest"))
                .andExpect(jsonPath("$.[0].email").value("emailFinalTest@gmail.com"))
                .andExpect(jsonPath("$.[0].password").value("passwordFinalTest"))

                .andExpect(jsonPath("$.[1].id").value(2))
                .andExpect(jsonPath("$.[1].name").value("nameTest"))
                .andExpect(jsonPath("$.[1].surname").value("surnameTest"))
                .andExpect(jsonPath("$.[1].email").value("emailTest@gmail.com"))
                .andExpect(jsonPath("$.[1].password").value("passwordTest"));
    }

    @Test
    void testUpdateUser() throws Exception {
        String bodyData = "{\"id\":2,\"name\":\"nameTest\",\"surname\":\"surnameTest\",\"email\":\"emailTest@gmail.com\",\"password\":\"passwordTest\"}";

        mvc.perform(put("/updateUser")
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
                .andExpect(jsonPath("$.surname").exists())
                .andExpect(jsonPath("$.email").exists())
                .andExpect(jsonPath("$.password").exists())

                //check the type of json node
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.name").isString())
                .andExpect(jsonPath("$.surname").isString())
                .andExpect(jsonPath("$.email").isString())
                .andExpect(jsonPath("$.password").isString())

                //check the return value
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.name").value("nameTest"))
                .andExpect(jsonPath("$.surname").value("surnameTest"))
                .andExpect(jsonPath("$.email").value("emailTest@gmail.com"))
                .andExpect(jsonPath("$.password").value("passwordTest"));
    }

    @Test
    void testDeleteUser() throws Exception {
        int userId = 79;

        mvc.perform(delete("/deleteUser/" + userId))
                .andDo(print())
                .andExpect(status().isOk());
    }
}