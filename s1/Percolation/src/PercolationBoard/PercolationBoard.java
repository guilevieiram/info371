package PercolationBoard;

import java.util.Random;

import UnionFind.UnionFind;

public class PercolationBoard {

    public int [][] board;
    public int size;

    public UnionFind unionFind;

    public int top = 0;
    public int bottom = 1;

    private String white = ".";
    private String black = "X";

    public int stage;

    public PercolationBoard(int boardSize, UnionFind unionFindModel){
        size = boardSize;
        unionFind = unionFindModel;
        unionFind.initialize(size);

        board = new int [size] [size];
        for (int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                board[i][j] = 0;
            }
        }
    }

    public void showBoard() {
        for( int i = 0; i < size; i++){
            System.out.println();
            for(int j = 0; j < size ; j++){
                if(board[i][j] == 0) System.out.print(white);
                else System.out.print(black);
            }
        }
    }

    public void colorPlace(){
        int [] position = getRandomEmptyPlace();
        board[position[0]][position[1]] = 1;
    }

    // function to translate the board object indexes to the linear unionfind array index
    private int linear(int i, int j){
        return i * size + j + 2;
    }

    private int[] getRandomEmptyPlace(){
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(size);
            y = random.nextInt(size);
        } while(board[x][y] != 0);

        int [] position = {x, y};
        return position;
    }

    private int[][] getNeighbors (int x, int y){
        int [] position = {x, y};
        int [] top = position, bottom = position, left = position, right = position ;
        
        if (y == 0) top[1] = this.top;
        else top[1] --;
        if (y == size - 1) bottom[1] = this.bottom;
        else bottom[1] ++;
        if (x == 0) left = null;
        else left[1] --;
        if (x == size - 1) right = null;
        else right[1] ++;

        int [][] neighbors = {
            top, bottom, left, right
        };
        
        return neighbors;
    }
}
