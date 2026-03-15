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
    private Deque<IObserver> observers = new ArrayDeque<>();
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

    public void addObserver(IObserver observer){
        observers.add(observer);
    }

    public void notify(String msg){
        for(IObserver observer : observers){
            observer.update(msg);
        }
    }

    public void play(){
        Scanner sc = new Scanner(System.in);
        while (!gameOver){
            Player currentPlayer = players.peek();
            notify("Its " + currentPlayer.getName() +"'s turn. Enter position");
            int position = sc.nextInt();
            RowCol rowCol = pos.get(position);
            int row = rowCol.getRow();
            int col = rowCol.getCol();
            if(rules.isValidMove(board, row, col)){
                board.placeMark(row, col, currentPlayer.getSymbol());
                if (rules.checkWin(board, currentPlayer.getSymbol())){
                    board.display();
                    notify(currentPlayer.getName() + " wins!!!");
                    currentPlayer.incrementScore();
                    gameOver=true;
                } else if(rules.checkDraw(board, currentPlayer.getSymbol())){
                    board.display();
                    notify("Its a draw!!!");
                    gameOver=true;
                } else{
                    board.placeMark(row,col,currentPlayer.getSymbol());
                    players.pop();
                    players.add(currentPlayer);
                    board.display();
                }
            } else{
                notify("Invalid move. Please try again");
                continue;
            }

        }
    }
}
