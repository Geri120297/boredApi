package com.boredAPI.boredApi.Commands;

import com.boredAPI.boredApi.Client.BoredClient;
import com.boredAPI.boredApi.LineReader.MyLineReader;
import com.boredAPI.boredApi.Model.BoredResponse;
import org.jline.terminal.Terminal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;



@SpringBootTest(classes = {BoredCommands.class})
@ExtendWith(SpringExtension.class)
@Import({Terminal.class, Logic.class})
class BoredCommandsIntegrationTest {

    @Autowired
    public BoredCommands boredCommands;

    @MockBean
    private BoredClient boredClient;

    @MockBean
    MyLineReader myLineReader;

    @MockBean
    Terminal terminal;



    @Test
    public void whenMethodCalledGetByType_thenGetByType(){
        when(myLineReader.readLine(any(), any())).thenReturn("1");
        when(boredClient.getByType(any())).thenReturn(new BoredResponse("Test Passed", 0.5, "type", 1, 0.2, 123));

        // Führe den Befehl aus
        String result = boredCommands.oneOption();

        assertEquals("Test Passed", result);
    }

    @Test
    public void whenMethodCalledGetByTypeWithInput10_thenGetEXIT(){
        when(myLineReader.readLine(any(), any())).thenReturn("10");

        // Führe den Befehl aus
        String result = boredCommands.oneOption();

        assertEquals("EXIT", result);
    }

    @Test
    public void whenMethodCalledRandom_thenGetRandomActivity(){
        when(boredClient.random()).thenReturn(new BoredResponse("Test Passed", 0.5, "type", 1, 0.2, 123));

        // Führe den Befehl aus
        String result = boredCommands.getRandomActivity();

        assertEquals("Test Passed", result);
    }
}