package TicTacToe;

import lombok.Getter;

import java.util.Arrays;

@Getter
public class Board {
    private Symbol[][] grid;
    private int size;
    private Symbol emptyCell;

    Board(int s){
        this.size = s;
        this.emptyCell = new Symbol('-');
        grid = new Symbol[size][size];
        for(int i=0;i<size;i++){
            Arrays.fill(grid[i], emptyCell);
        }
    }
    public boolean isCellEmpty(int row, int col){
        if(row<0 || row>=size || col<0 || col>=size){
            return false;
        }
        return grid[row][col] == emptyCell;
    }

    public void placeMark(int row, int col, Symbol s){
        grid[row][col] = s;
    }

    public Symbol getCell(int row, int col){
        return grid[row][col];
    }

    public void display(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(getCell(i,j).getMark() + " ");
            }
            System.out.println();
        }
    }

}
