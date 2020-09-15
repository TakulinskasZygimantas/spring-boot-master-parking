package com.zygtak.springbootmasterparking.Controllers;

import com.zygtak.springbootmasterparking.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

@SpringBootTest
@AutoConfigureMockMvc
class UserTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserRepository userRepository;

    @Test
    void testFindAllUsers() throws Exception {

        Mockito.when(userRepository.findAll()).thenReturn(
                Collections.emptyList()
        );
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/users/")
                        .accept(MediaType.APPLICATION_JSON)

        ).andReturn();

        System.out.println(mvcResult.getResponse());
        String expected = "[{id: 1, name: Zilvinas, surname: Takulinskas, email: takulinskas.ilvinas@gmail.com, password: kyuubi}," +
                "{id: 2, name: Žilvinas, surname: Takulinskas, email: takulinskas.ilvinas@gmail.com, password: kyuubi}," +
                "{id: 8, name: Zygimantas, surname: Takulinskas, email: zygimantas.takulinskas@gmail.com, password: latata11}" + "]";

        JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);

        Mockito.verify(userRepository).findAll();
    }


}

