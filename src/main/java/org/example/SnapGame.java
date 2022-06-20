package org.example;

import java.sql.SQLOutput;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class SnapGame extends CardGame{

    private Scanner scanner = new Scanner(System.in);

    public SnapGame() {
        super("Snap!");
    }

    private Player createPlayer(int playerNumber){
        System.out.println("Player "+playerNumber+", please enter your name:");
        String playerName = scanner.nextLine();
        return new Player(playerName);
    }

    private Player[] createPlayers(int numPlayers){
        Player[] players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
           players[i] = createPlayer(i+1);
        }
        return players;
    }
    public void play(){
//        create player object
//        Player player1 = createPlayer(1);
//
////        create player object
//        Player player2 = createPlayer(2);
    Player[] players = createPlayers(2);
    int currentPlayerIndex = 0;
//        System.out.println("The players are: "+ player1.getName() + " and " + player2.getName());

//        shuffle deck
        shuffleDeck();

//        deal top card
        Card previousCard = null;

        Player previousPlayer = null;
        boolean previousPlayerWon = false;

//        while(condition){
//        }
//        Can run zero or more times!
        while (true) {
            Player currentPlayer = players[currentPlayerIndex];

            if(previousPlayerWon){
                System.out.println(String.format("Enter SNAP to win!!"));
            }

//            String currentPlayer = player1Turn ? player1.getName() : player2.getName();
            System.out.println(String.format("%s press enter to deal:",currentPlayer.getName()));
//            System.out.println(currentPlayer + " Press ENTER to deal:");
            try {
                String playerResponse = readResponse();
                if(playerResponse.equals("SNAP")&& previousPlayerWon) {
                    System.out.println(previousPlayer.getName() + " Congratulations! You Win!!");
                    break;
                } else if (playerResponse.equals("SNAP")) {
                    System.out.println("NOT SNAP!");
                    System.out.println("You lose!" );
                    break;
                }
            } catch (Exception e) {
                if(previousPlayerWon){
                    System.out.println("Too slow!");
                    System.out.println("You snooze you lose " + previousPlayer.getName() + "!!");
                    break;
                }
                System.out.println("Exception thrown");
            }

//            deal another card
            Card nextCard = dealCard();
            if(nextCard == null){
                System.out.println(currentPlayer.getName() + " You lose!");
                break;
            }
            System.out.println("Card: "+ nextCard);

            if(previousCard == null){
                previousCard = nextCard;
            }
            else{
//                compare value of last 2 cards
//        If values are the same then player wins!

//        else deal another card

                previousPlayerWon = previousCard.getValue() == nextCard.getValue();

//                if(previousCard.getValue() == nextCard.getValue()){
//                    System.out.println("SNAP");
//                    System.out.println(currentPlayer + " Congratulations! You Win!!");
//                    break;
//                }
            }
            previousCard = nextCard;
            previousPlayer = currentPlayer;
           currentPlayerIndex = (currentPlayerIndex +1)%players.length;
        }
        System.out.println("Thanks for playing!");
//
    }

//    Read response from user.
//    If takes over 2 seconds then throws an exception.
    private String readResponse() throws Exception{
        Instant startTime = Instant.now();
//        System.out.println("start: "+startTime);
       String response = scanner.nextLine();
       Instant endTime = Instant.now();
//        System.out.println("End: "+endTime);
       long elapsed = endTime.getEpochSecond() - startTime.getEpochSecond();

       if(elapsed > 5){
           throw new Exception("Out of time!");
       }

       return response.toUpperCase();
    }

    public static void main(String[] args) {
        SnapGame snapGame = new SnapGame();
        System.out.println(snapGame.getName());

        snapGame.play();
    }
}
