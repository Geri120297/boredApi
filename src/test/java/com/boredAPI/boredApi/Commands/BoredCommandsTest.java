package com.boredAPI.boredApi.Commands;

import com.boredAPI.boredApi.Client.BoredClient;
import com.boredAPI.boredApi.Model.BoredResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest(classes = BoredCommands.class)
class BoredCommandsTest {

    @MockBean
    BoredClient boredClient;

    @Autowired
    BoredCommands boredCommands;
    @MockBean
    Logic logic;

    @Test
    void whenMethodCalledGetByType_thenGetType(){

        Mockito.when(logic.getInput(any(), any())).thenReturn("test");
        Mockito.when(boredClient.getByType(any())).thenReturn(new BoredResponse("Test Passed",1,"test",4,22,10));

        assertEquals("Test Passed", boredCommands.oneOption());

    }
}