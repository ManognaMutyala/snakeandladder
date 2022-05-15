package com.example.snakeandladder;

import com.example.snakeandladder.model.Dice;
import com.example.snakeandladder.model.Game;
import com.example.snakeandladder.model.Jumper;
import com.example.snakeandladder.model.Player;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class SnakeandladderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnakeandladderApplication.class, args);
        Dice dice=new Dice(1);
        Player p1 = new Player(1,"Alber");
        Player p2 = new Player(2,"Rose");
        Queue<Player> allPlayers = new LinkedList<>();
        allPlayers.offer(p1);
        allPlayers.offer(p2);
        Map<Integer,Integer> snakes=new HashMap<>();
        snakes.put(10,2);
        snakes.put(99,12);
        Map<Integer,Integer> ladders=new HashMap<>();
        ladders.put(5,25);
        ladders.put(40,89);

        Map<String,Integer> playersCurrentPosition = new HashMap<>();
        playersCurrentPosition.put("Alber",0);
        playersCurrentPosition.put("Rose",0);
        Game gb=new Game(dice,allPlayers,snakes,ladders,playersCurrentPosition,100);
        gb.startGame();
    }

}
