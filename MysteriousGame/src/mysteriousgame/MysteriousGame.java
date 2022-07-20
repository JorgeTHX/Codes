/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysteriousgame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class MysteriousGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader br = null;
        br = new BufferedReader(new InputStreamReader(System.in));
        String s=""; 
        
        
            
        try {
            while (true){  
                int sum1=0;
                int sum2=0;
                Boolean continue1=true;
                Boolean continue2=true;
                
                System.out.println("Please enter the name of player 1");
                s=br.readLine();
                String name1=s;
                System.out.println("Please enter the name of player 2");
                s=br.readLine();
                String name2=s;
                
                while (true){
                                
                if(continue1==true){
                    int card=((int)(Math.random()*10))+1;
                    sum1=sum1+card;
                }
                if(continue2==true){
                    int card=((int)(Math.random()*10))+1;
                    sum2=sum2+card;
                }

                System.out.println("Player "+name1+":"+sum1);
                System.out.println("Player "+name2+":"+sum2);

                if(continue1==true){
                    if(sum1<21){
                        System.out.println("Do you want to continue "+name1+" ? (y/n)");
                        s=br.readLine();
                        if(s.equals("n")){
                            continue1=false;
                        } 
                    }else continue1=false;
                    
                }
                if(continue2==true){
                    if(sum2<21){
                        System.out.println("Do you want to continue "+name2+" ? (y/n)");
                        s=br.readLine();
                        if(s.equals("n")){
                            continue2=false;
                        }
                    }else continue2=false;    
                }
                if(continue1==true || continue2==true && sum1<21 && sum2<21){
                    //restart to choosing card
                }else break;
                }
                    if(sum1==sum2 && sum1<=21 && sum2<=21){
                        System.out.println("It's a draw!!");
                    }
                    else if(sum1==21||sum1>sum2 && sum1<21||sum2>21 && sum1<21){
                        System.out.println("Player "+name1+" wins!!");
                    }
                    else if(sum2==21||sum2>sum1 && sum2<21||sum1>21 && sum2<21){
                        System.out.println("Player "+name2+" wins!!");
                    }
                    else System.out.println("Nobody won :(");
                
                System.out.println("Do you want to play again? (y/n)");
                s=br.readLine();
                if(s.equals("y")){           
                    //restarts to choosing the names
                }else break;                                 
          }
        } catch (IOException ex) {
            Logger.getLogger(MysteriousGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
