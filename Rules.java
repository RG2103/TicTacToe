package TicTacToe;

public interface Rules {
    boolean isValidMove(Board b, int row, int col);

    boolean checkWin(Board b, Symbol s);

    boolean checkDraw(Board b, Symbol s);
}
