package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class GuessController {
    @GetMapping("/roll-dice")
    public String rollDice(){
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{userChoiceStr}")
    public String guessResult(@PathVariable String userChoiceStr, Model model){
        int randomNum = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        int userChoice = Integer.parseInt(userChoiceStr);
        String result = "";

        if(userChoice == randomNum){
            result = "Correct";
        } else {
            result = "Wrong";
        }

        model.addAttribute("userChoice", userChoice);
        model.addAttribute("randomNum", randomNum);
        model.addAttribute("result", result);
        return "roll-dice";
    }
}



