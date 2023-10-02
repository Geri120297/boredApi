package com.boredAPI.boredApi.Commands;

import com.boredAPI.boredApi.LineReader.MyLineReader;
import org.jline.terminal.Terminal;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Logic {

    private final MyLineReader myLineReader;
    public Logic(MyLineReader myLineReader){
    this.myLineReader = myLineReader;
    }

    public String getInput(Terminal terminal, List<String> OPTIONS){
        int input = 0;


        do {
            String reader = myLineReader.readLine(terminal, OPTIONS);
            if(reader.matches("^[1-9][0-9]?$")){
                input = Integer.parseInt(reader);
            }else{
                System.out.println("Wrong Input!");
            }
        }while (input <= 0 || input > OPTIONS.size());

        return OPTIONS.get(input - 1);
    }



}
