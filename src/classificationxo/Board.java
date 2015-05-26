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
    
    private static char [] boardArray;
    private static byte countFull = 9;
    private final char charr = '-';
    private byte location = 0, i = 0;
    
    
    public Board()
    {
        boardArray = new char[9];
        for(i=0;i<boardArray.length; i++)
        {
            boardArray[i] = charr;
        }
    }
    
    public Board(int i)
    {
        
    }
    
    public char [] getByteArray()
    {
        return this.boardArray;
    }
    
    public void print()
    {
        for(i=1; i<=boardArray.length; i++)
        {
            System.out.print(" | " + boardArray[i-1] + " | ");
            if(i % 3 == 0) System.out.println();
        }
    }
    
    public boolean playerWon(char turn)
    {
        // Horizontal
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
        if(boardArray[x] == charr) return false;
        return true;
    }
    
    public void play(byte x, char turn)
    {
        boardArray[x] = turn;
        countFull--;
    }
    
    public boolean isFull()
    {
        /*for(i=0; i < boardArray.length; i++ ){
            if(boardArray[i] == ' ')
                return false;
        }
        return true;*/
        if(countFull == 0)
            return true;
        else return false;
    }
    
}
