package TicTacToe;

import lombok.Getter;

@Getter
public class Player {
    private int playerId;
    private String name;
    private Symbol symbol;
    private int score;

    Player(int playerId, String name, Symbol symbol){
        this.playerId=playerId;
        this.name=name;
        this.symbol=symbol;
        this.score=0;
    }

    public void incrementScore(){
        score++;
    }
}
