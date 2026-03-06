package TicTacToe;

public class StandardRules implements Rules{
    @Override
    public boolean isValidMove(Board b, int row, int col) {
        return b.isCellEmpty(row, col);
    }

    @Override
    public boolean checkWin(Board b, Symbol s) {
        int size = b.getSize();
        boolean win=false;
        for(int i=0;i<size;i++){
            win = true;
            for(int j=0;j<size;j++){
                if(b.getCell(i,j)!=s){
                    win = false;
                    break;
                }
            }
            if(win)
                return true;
        }

        for(int i=0;i<size;i++){
            win = true;
            for(int j=0;j<size;j++){
                if(b.getCell(j,i)!=s){
                    win = false;
                    break;
                }
            }
            if(win)
                return true;
        }

        win = true;
        for(int i=0;i<size;i++){
            if(b.getCell(i,i)!=s){
                win = false;
                break;
            }
        }
        if(win)
            return true;

        win = true;
        for(int i=0;i<size;i++){
            if(b.getCell(i,size-1-i)!=s){
                win = false;
                break;
            }
        }

        return win;
    }

    @Override
    public boolean checkDraw(Board b, Symbol s) {
        int size = b.getSize();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(b.isCellEmpty(i,j))
                    return false;
            }
        }
        return true;
    }
}
