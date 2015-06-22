/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classificationxo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

/**
 *
 * @author Azeez
 */
public class ClassificationXO {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.lang.InterruptedException
     */

    
    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
        // TODO code application logic here
        
        Board b = new Board();
        byte player = 0;  
        Random random = new Random();
        
        File f1 = new File("p1.txt");
        File f2 = new File("p2.txt");
        
        FileOutputStream fos1 = new FileOutputStream(f1, true);
        FileOutputStream fos2 = new FileOutputStream(f2,true );

        BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(fos1));
        BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(fos2));

        long timeStart = System.currentTimeMillis();
        Decide d = new Decide();
        
        while(true)
        {
            byte shot = (byte) random.nextInt(9);
            if(player == 0) 
            {
                System.out.println("\nPlayer one turn!");
                while (!b.isFieldFilled(shot)) 
                {
                    b.play(shot, 'X');
                    bw1.append(shot + ",");
                    if(b.playerWon('X')) 
                    { 
                        
                        bw1.append("won\n"); bw1.newLine();b.print();bw1.newLine(); bw1.close(); bw2.close();
                        long timeEnd = System.currentTimeMillis();
                        System.out.println("Time took: " + (timeEnd - timeStart));
                        System.out.println("Player 1 WON");
                        return; 
                    }
                    else { bw1.append("\n");}
                    player++;
                }
            }
            else if(player == 1)
            {
                System.out.println("\nPlayer two turn!");
                //shot = d.whereToPlay(b.getByteArray());
                while (!b.isFieldFilled(shot))
                {
                    b.play(shot, 'Y');
                    bw2.append(shot + ",");
                    if(b.playerWon('Y')) { 
                        
                        bw2.append("won\n"); bw2.newLine(); b.print(); bw1.close(); bw2.close(); 
                        long timeEnd = System.currentTimeMillis();
                        System.out.println("Time took: " + (timeEnd - timeStart));
                        System.out.println("Player 2 WON");
                        return; 
                    }
                    else { bw2.append("\n");}
                    player--;
                }
            }
            System.out.println("----------------------");
            
            if(b.isFull())
            {
                b.print();
                long timeEnd = System.currentTimeMillis();
                System.out.println("Time took: " + (timeEnd - timeStart));
                System.out.println("Game was a draw!");
                bw1.append("draw \n");
                bw2.append("draw \n");
                bw1.newLine(); bw2.newLine();
                bw1.close();
                bw2.close();
                break;
            } 
            b.print();              

        }
        


    }
    
}
