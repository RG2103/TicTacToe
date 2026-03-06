package TicTacToe;

import java.util.Scanner;

public class PlayGame {
    private Games game;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Let's play Tic Tac Toe :)");
        System.out.println("Please enter board size to start game...");
        int size = sc.nextInt();
        if (size==3){
            GameType gt = GameType.STANDARD;
            Games game = GameFactory.createGame(gt, size);
            System.out.println("Enter name for player 1");
            String name = sc.next();
            System.out.println("Enter symbol for " + name);
            char symbol = sc.next().charAt(0);
            System.out.println("Enter name for player 2");
            String name2 = sc.next();
            System.out.println("Enter symbol for " + name2);
            char symbol2 = sc.next().charAt(0);
            Player player1=new Player(1, name, new Symbol(symbol));
            Player player2=new Player(2, name2, new Symbol(symbol2));
            game.addPlayers(player1);
            game.addPlayers(player2);
            game.play();
        } else {
            System.out.println("Invalid board size");
        }

    }
}
