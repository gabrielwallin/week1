package assignments.product;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;

/*
 * Nim Game
 * See https://en.wikipedia.org/wiki/Nim
 *
 * Plan and process: Compare Rock, Paper Scissor from exercises !
 */
public class Nim {

    public static void main(String[] args) {
        new Nim().program();
    }

    private void Space()
    {
        out.println("");
        out.println("=============================");
        out.println("");
    }

    void program() {
        Random rand = new Random();
        Scanner sc = new Scanner(in);
        boolean exit = false;
        boolean playerTurn;
        int playerPick;
        while(exit==false){
            String playerName;
            out.print("Player, choose your name: ");
            playerName = sc.next();

            int coinAmount = rand.nextInt(11) + 15; //gives random 15-25

            int startingSelection = rand.nextInt(2);
            if (startingSelection == 0)
            {
                playerTurn = true;
                out.println(playerName + " goes first.");
            }
            else
            {
                playerTurn = false;
                out.println("AI goes first.");
            }
            boolean playing = true;
            while (playing == true)
            {
                Space();
                out.println("There are " + coinAmount + " coins in the stack.");
                if (playerTurn == true)
                {
                    out.println(playerName + ", pick amount of coins to remove from stack (1 - 3): ");
                    playerPick = sc.nextInt();
                    coinAmount -= playerPick;
                    out.println(playerName + " takes " + playerPick + " coins from the stack. ");
                    playerTurn = false;
                }
                else
                {
                    playerPick = rand.nextInt(3) + 1;
                    out.println("AI picks " + playerPick + " coins from the stack.");
                    coinAmount -= playerPick;
                    playerTurn = true;
                }
                if (coinAmount <= 0)
                {
                    if (playerTurn == false)
                    {
                        out.println(playerName + " takes the last coin and wins!");
                    }
                    else {
                        out.println("AI takes the last coin and wins");
                    }
                    out.println("Enter 'r' to play again.");
                    String playAgainInput = sc.next();
                    if (playAgainInput.equals("r"))
                    {
                        out.println("Going again...");
                        playing = false;
                    }
                    else
                    {
                        out.println("Thanks for playing!");
                        playing = false;
                        exit = true;
                    }
                }
            }




        }

    }
}
