package com.boredAPI.boredApi.Commands;

import com.boredAPI.boredApi.Client.BoredClient;
import jakarta.annotation.PostConstruct;
import org.jline.terminal.Terminal;
import org.springframework.context.annotation.Lazy;
import org.springframework.shell.standard.AbstractShellComponent;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.*;

@ShellComponent
public class BoredCommands extends AbstractShellComponent {

    private final BoredClient boredClient;

    private final Terminal terminal;

    private final Logic logic;


    private final List<String> OPTIONS = List.of("education", "recreational", "social", "diy", "charity", "cooking", "relaxation", "music", "busywork", "EXIT");


    public BoredCommands(BoredClient boredClient,@Lazy final Terminal terminal, Logic logic){
        this.boredClient = boredClient;
        this.terminal = terminal;
        this.logic = logic;
    }

    @ShellMethod(key = "random", value = "Get a Random Activity")
    public String getRandomActivity(){
        return boredClient.random().activity();
    }



    @ShellMethod(key = "GetByType", value = "Give a Activity by Type")
    public String oneOption() {
        String respone = logic.getInput(this.terminal, this.OPTIONS);
        if(respone.equals("EXIT"))
            return respone;
        else{
            return boredClient.getByType(respone).activity();
        }
    }


    @PostConstruct
    public void showAvailableCommands() {
        System.out.println("Available Commands:");
        System.out.println("random [Get Random Activity]");
        System.out.println("GetByType [Get Activity by Type]");
        System.out.println("help [see all commands]");
    }


}







