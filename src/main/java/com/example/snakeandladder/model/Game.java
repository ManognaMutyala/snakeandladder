package com.example.snakeandladder.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

@Data
@AllArgsConstructor
public  class Game {

    static Dice dice;
    static Queue<Player> nextTurn;
    static Map<Integer,Integer> snakes;
    static Map<Integer,Integer> ladders;
    static Map<String,Integer> playerCurrentPosition;
    static int boardSize;

    public Game(Dice dice, Queue<Player> nextTurn, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders, Map<String, Integer> playersCurrentPosition, int boardSize) {
    this.dice=dice;
    this.nextTurn=nextTurn;
    this.snakes=snakes;
    this.ladders=ladders;
    this.playerCurrentPosition=playersCurrentPosition;
    this.boardSize=boardSize;

    }

    public static void startGame(){

        while(nextTurn.size()>1){

            Player player=nextTurn.poll();
            int diceValue=dice.rollDice();
            System.out.println("dice value is"+diceValue);
            System.out.println("player position value is"+playerCurrentPosition);

            int currentPos=playerCurrentPosition.get(player.getPlayerName());
            int nextCell=currentPos+diceValue;
            int nextPosition=nextCell;
            if(nextCell>boardSize)
                nextTurn.offer(player);
            else if(nextCell==boardSize)
                System.out.println("Player won the game"+player.getPlayerName());
            else {
                if (snakes.containsKey(nextCell)) {
                    System.out.println("Bitten by snake");
                    nextPosition = snakes.get(nextCell);
                } else if (ladders.containsKey(nextCell)) {
                    System.out.println("Got ladder");
                    nextPosition = ladders.get(nextCell);
                }
                playerCurrentPosition.put(player.getPlayerName(), nextPosition);
                nextTurn.offer(player);

            }

        }
    }

}
