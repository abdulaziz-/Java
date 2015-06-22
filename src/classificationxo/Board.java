/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classificationxo;

/**
 *
 * @author Azeez
 */
public class Board {
    
    private static final int size = 9; // the size of the board
    private static char [] boardArray = new char[size]; // a one diemenson array that represents the tic tac toe board
    private static byte countFull = size; // a parameter that is ueed to indicate the status of the board (filled completely or not)
    private final char charr = '-';
    private byte location = 0, i = 0;
    
    
    // initializing the board
    public Board()
    {
        for(i=0;i<boardArray.length; i++)
        {
            boardArray[i] = charr;
        }
    }
    
    
    public char [] getByteArray()
    {
        return Board.boardArray;
    }
    
    public void print()
    {
        for(i=1; i<=size; i++)
        {
            System.out.print(" | " + boardArray[i-1] + " | ");
            if(i % 3 == 0) System.out.println();
        }
    }
    
    public boolean playerWon(char turn)
    {
        // This function determines if a player won the match or not in O(7) time
        // Horizontal check 
        for(i=0; i <7; )
        {
            location = i;
            if(boardArray[location] == turn && boardArray[location] == boardArray[location+1] && boardArray[location+1] == boardArray[(location+1) + 1]) {  return true; }
            else i+=3;
        }
        
        // Vertical
        for(i=0; i <3; )
        {
            location = i;
            if(boardArray[location] == turn && boardArray[location] == boardArray[location + 3] && boardArray[location + 3] == boardArray[location +3 + 3] ) {  return true; }
            else i++;
        }
        
        // Diagonal
        for(i=0; i<3; )
        {
            location = i;
            if(boardArray[location] == turn && boardArray[location] == boardArray[location + 4] && boardArray[location + 4] == boardArray[location + 8]) {  return true; }
            if(boardArray[location + 2] == turn && boardArray[location + 6] == boardArray[location + 4] && boardArray[location + 4] == boardArray[location + 2]) { return true; }
            else break;
        }
        return false;
    }
    
    public boolean isFieldFilled(byte x)
    {
        return boardArray[x] != charr;
    }
    
    public void play(byte x, char turn)
    {
        boardArray[x] = turn;
        countFull--; // added to improve the isFull function from O(N) to O(1)
    }
    
    public boolean isFull()
    {
        /*for(i=0; i < boardArray.length; i++ ){
        if(boardArray[i] == ' ')
        return false;
        }
        return true;*/ 
        return Board.countFull == 0;
    }
    
}
