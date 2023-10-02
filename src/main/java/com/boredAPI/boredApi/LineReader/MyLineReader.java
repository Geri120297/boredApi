package com.boredAPI.boredApi.LineReader;

import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyLineReader implements LineReaderWrapper{
    @Override
    public String readLine(Terminal terminal, List<String> OPTIONS){
        StringBuilder desription = new StringBuilder("select one of this options: \n");
        for(int i = 0; i < OPTIONS.size(); i++){
            desription.append("[").append(i + 1).append("] ").append(OPTIONS.get(i)).append("\n");
        }
        return LineReaderBuilder.builder().terminal(terminal).build().readLine(desription + "input: ").trim();

    }
}
