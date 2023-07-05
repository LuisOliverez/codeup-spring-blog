package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class RollDiceController {

    // GET request for the /roll-dice endpoint
    @GetMapping("/roll-dice")
    public String showRollDiceForm() {
        return "roll-dice";
    }// shows roll-dice.html template

    // GET request for the /roll-dice/{guess} endpoint
    @GetMapping("/roll-dice/{guess}")
    public String rollDice(@PathVariable int guess, Model model) {
        int roll = rollDice(); // generates a random number to guess against
        model.addAttribute("guess", guess);
        model.addAttribute("roll", roll);
        model.addAttribute(("matches"), countMathces(guess, roll));
       model.addAttribute("rolls", getRolls());
        return "roll-dice-results";
    }

    private Object countMathces(int guess, int roll) {
        return guess == roll ? 1: 0;
    }

    // helper method to "roll a die" and get a random number from 1 to 6
    private int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    // helper method to get a list of 5 random dice rolls
    private List<Integer> getRolls() {
        List<Integer> rolls = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            rolls.add(random.nextInt(6) + 1);
        }
        return rolls;
    }
}