/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classificationxo;

import java.util.Random;

/**
 * This class will be used to help the computer's user selects the best move or location to play using artificial intelligence & classification technique
 * The program will collect winning patterns and apply the choice to one of 8 classes (0,1,2,3,..8)
 * @author Azeez
 */
public class Decide {
    
    private byte choice;
    private byte [] dynamicArray = new byte[9];
    private byte i = 0;
    private int access = 0;
    private Random r = new Random();
    
    public Decide()
    {
        for(i=0; i<dynamicArray.length; i++)
        {
            dynamicArray[i]= 0;
        }
    }
    
    public void printOriginal(char [] array)
    {
        for(i=1; i<=array.length; i++)
        {
            System.out.print(" | " + array[i-1] + " | ");
            if(i % 3 == 0) System.out.println();
        }
    }
    
    public void print()
    {
        for(i=1; i<=dynamicArray.length; i++)
        {
            System.out.print(" | " + dynamicArray[i-1] + " | ");
            if(i % 3 == 0) System.out.println();
        }
    }
    
    public byte whereToPlay(char [] array)
    {
        choice = 0;
        access++;
        byte blockHere;
        byte score = 0;
        for(i=0;i<array.length-1; i++)
        {
            if(array[i] == '-' )
            {
                dynamicArray[i]--;
                //score++;
                if (i == 0) score = 1;
                else score = score;
            }
            else if(array[i]=='X')
            {
                dynamicArray[i]++;
                score++;
            }
            else
            {
                dynamicArray[i]=-1;
                score--;
            }
            
        }
        
        if (access  > 10 ) return (byte) r.nextInt(9);
        print();
        return score;
        /*
        
        System.out.println();
       // print();
        System.out.println();
        Random r = new Random();
        for(i=0; i <array.length-1; i++)
        {
            if(array[i+1] == '-')
            {
                dynamicArray[i]--;
            }
            else if(array[i+1] == 'X' )
            {
                dynamicArray[i]++;
            }
            else
            {
                dynamicArray[i]=0;
            }

        }
        
       // print();
        int count= 0;
        for(i=0; i<dynamicArray.length; )
        {
            
            if(array[i]!='X' && dynamicArray[i] > 0 )
                return i;
            else i++;
            
            /*if (blockHere > 1)
                count++;
            if(count >= 1) return (byte) r.nextInt(9);
            else count++;
            /*if(dynamicArray[i] < i && array[i] == '-')
                return i;
            else i++;
                
        }
        
        

        /*Random r = new Random();
        Board boo = new Board(1);
        choice = (byte) r.nextInt(9);
        byte i =0;
        while(!boo.playerWon('Y'))
        {
            if(!boo.isFieldFilled(i)) boo.play((byte) i, 'Y');
            
            if(i<=1 && boo.playerWon('Y'))
                return choice;
            else return (byte) r.nextInt(9);
            
        }*/
        //return (byte) r.nextInt(9);
    }
}
