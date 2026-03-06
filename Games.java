package TicTacToe;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Games {
    private Board board;
    private Deque<Player> players = new ArrayDeque<>();
    private Rules rules;
    private boolean gameOver;
    private static Map<Integer, RowCol> pos = Map.of(1, new RowCol(0,0)
            ,2, new RowCol(0,1)
            ,3, new RowCol(0,2)
            ,4, new RowCol(1,0)
            ,5, new RowCol(1,1)
            ,6, new RowCol(1,2)
            ,7, new RowCol(2,0)
            ,8, new RowCol(2,1)
            ,9, new RowCol(2,2));

    Games(int size){
        board = new Board(size);
        this.gameOver = false;
    }

    public void addPlayers(Player player){
        players.add(player);
    }

    public void play(){
        Scanner sc = new Scanner(System.in);
        while (!gameOver){
            Player currentPlayer = players.peek();
            System.out.println("Its " + currentPlayer.getName() +"'s turn. Enter position");
            int position = sc.nextInt();
            RowCol rowCol = pos.get(position);
            int row = rowCol.getRow();
            int col = rowCol.getCol();
            if(rules.isValidMove(board, row, col)){
                board.placeMark(row, col, currentPlayer.getSymbol());
                if (rules.checkWin(board, currentPlayer.getSymbol())){
                    board.display();
                    System.out.println(currentPlayer.getName() + " wins!!!");
                    currentPlayer.incrementScore();
                    gameOver=true;
                } else if(rules.checkDraw(board, currentPlayer.getSymbol())){
                    board.display();
                    System.out.println("Its a draw!!!");
                    gameOver=true;
                } else{
                    board.placeMark(row,col,currentPlayer.getSymbol());
                    players.pop();
                    players.add(currentPlayer);
                    board.display();
                }
            } else{
                System.out.println("Invalid move. Please try again");
                continue;
            }

        }
    }
}
