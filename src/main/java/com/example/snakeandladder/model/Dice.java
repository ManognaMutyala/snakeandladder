package com.example.snakeandladder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class Dice {

    int numberOfDice;
    public int rollDice(){
        int upperBound=numberOfDice*6;
        int lowerBound=numberOfDice;
        int range=upperBound-lowerBound+1;
        return  ((int)(Math.random()*range))+lowerBound;
    }

}
