/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.Scanner;

/**
 *
 * @author Florin
 */
public class Hangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // scanner input to get user input
        Scanner input = new Scanner(System.in);
        //user one
        String userOne = "Player one ";
        //user two
        String userTwo = "Player two ";
        //number of lives
        int lives = 6;
        //create a counter 
        int counter = 0;
        //create a boolean to check if the answer is wrong or right
        boolean check = false;
        //create a boolean to check if the player wants to play again
        boolean playAgain = true;
        //remember the amount of games played
        int game = 1;
        
        //start to play the game
        while (playAgain == true) {
           
            // tell player 1 to insert word
            System.out.println(userOne + ": Enter a word for " + userTwo + "to guess: ");
            String word = input.nextLine();
            word = word.toLowerCase();
            String word2 = word;

            //insert blank lines
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");

            //insert dashes for word length
            for (int i = 0; i < word.length(); i++) {
                String temp = word2.substring(i, i + 1);
                char temp1 = temp.charAt(0);

                word2 = word2.replace(temp1, '-');

            }
            //create a stringBuilder to manipulate easier
            StringBuilder nameOfBuilder = new StringBuilder(word2);

            //create a while statement 
            while (lives > 0 && counter < word.length() && playAgain == true) {
                check = false;

                //ask the player to guess a letter and output the number of lives left
                System.out.println(userTwo + ": You have " + lives + " lives left. Guess a letter: ");
                String letter = input.nextLine();
                letter = letter.toLowerCase();
                //store the letter as a character
                char letterGuessed = letter.charAt(0);

                // create a for loop
                for (int i = 0; i < word.length(); i++) {
                    // statement if the letter guessed is right
                    if (letterGuessed == word.charAt(i)) {
                        nameOfBuilder.setCharAt(i, letterGuessed);
                        check = true;
                        //increase counter
                        counter++;
                    }
                }
                // statement if the letter guessed is wrong
                if (check == false) {
                    //decrease number of lives
                    lives = lives - 1;
                }
                System.out.println(nameOfBuilder);

            }
            //lose the game if too many lives are lost
            if (lives == 0) {
                System.out.println("You lost! The word was " + word);

            }
            if (counter == word.length()) {
                System.out.println("You win!");
                //ask them to play again
                System.out.println("Would you like to play again? (Answer yes or no)");
                String answer = input.nextLine();
                //case sensitive
                answer = answer.toLowerCase();

                //if answer is no, end the game
                if (answer.equals("no")) {
                    System.out.println("Come back another time!");
                    playAgain = false;
                    break;
                }
                //if answer is yes, repeat the game
                if (answer.equals("yes")) {
                    System.out.println("Good luck!");
                    game = game + 1;
                    lives = 6;
                    playAgain = true;
                    counter = 0;
                    //switch players
                    
                    if (game == 2 || game == 4 || game == 6 || game == 8){
                    userOne = userOne.replaceAll(userOne, "Player two ");
                    userTwo = userTwo.replaceAll(userTwo, "Player one ");
                } else{
                        userOne = ("Player one ");
                        userTwo = ("Player two ");
                    }
                }
                //if the player inputs neither yes or no
                if (!(answer.equals("yes")) && !(answer.equals("no"))) {
                    System.out.println("You Quit");
                    break;
                }
                if(game == 10){
                    System.out.println("Game over");
                    break;
                }
            }
        }
    }
}
