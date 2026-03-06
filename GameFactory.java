package TicTacToe;

public class GameFactory {
    public static Games createGame(GameType gt, int size){
        Games game = new Games(size);
        if(gt == GameType.STANDARD){
            game.setRules(new StandardRules());
            return game;
        }
        return null;
    }
}
