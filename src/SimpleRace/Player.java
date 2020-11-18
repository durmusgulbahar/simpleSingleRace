/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructurehw1_20180808076;

import datastructurehw1_20180808076.Terrain;
import datastructurehw1_20180808076.Race;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.lang.Exception;
/**
 *
 * @author Durmus
 */
public class Player {
    int p = 0;
    int pX = 0;
    int pY = 0;
    
    public Player(){ //Second player object (Player2) id will be "-2" , third "-3"
        p--;
}
    
    public int playerName(){
        return this.p;
    }
    
    public void move(Terrain t) throws Exception{ //player moves in matrix. Every turn to inform us direction player moved.
                                                   // if there is obstacle or limit of terrain player can't move.
        Race race = new Race();
        race.finish(this,t);
        
        t.terrain[this.pX][this.pY] = p;
        
        char[] directions = {'e','w','n','s'};
        
        Scanner input = new Scanner(System.in);
        
        while(true){
        t.saveConfig(t.terrain);
        
        race.finish(this, t);
        
        System.out.println("Please press '1' for next turn!");
        int in = input.nextInt();
        
        
        if(in==1){
            Random random = new Random();

            int direct = random.nextInt(directions.length); //select random direction from "directions" char array


            try{
            switch(directions[direct]){
                case 'e':
                    if(t.terrain[pX][pY+1] != 1){
                        t.terrain[pX][pY] =  0;
                        
                        pX = pX;
                        pY = pY+1;
                        
                        t.terrain[pX][pY] = p;
                        
                        System.out.println("Player moved to East!");
                        
                       
                        
                        continue;
                    }
                     else{
                        throw new Exception();
                    }

                case 'w':
                    if(t.terrain[pX][pY-1] != 1){
                        t.terrain[pX][pY] =  0;
                        
                        pX = pX;
                        pY = pY-1;
                        
                        t.terrain[pX][pY] = p;
                        
                        
                        System.out.println("Player moved to West!");
                        
                        continue;
                    }
                     else{
                        throw new Exception();
                    }

                case 'n':
                    if(t.terrain[pX-1][pY] != 1){
                        t.terrain[pX][pY] =  0;
                        
                        pX = pX-1;
                        pY = pY;
                        
                        t.terrain[pX][pY] = p;
                        System.out.println("Player moved to North!");
                        
                        continue;
                    }
                     else{
                        throw new Exception();
                    }

                case's':
                    if(t.terrain[pX+1][pY] != 1){
                        t.terrain[pX][pY] =  0;
                        
                        pX = pX+1;
                        pY = pY;
                        
                        t.terrain[pX][pY] = p;
                        System.out.println("Player moved to South");
                        
                        continue;
                    }
                    else{
                        throw new Exception();
                    }
            }

            }
            catch(Exception e){
                t.terrain[pX][pY] = p;

                System.out.println("Player can't move!!");
            }
             
        }
        else{
            System.out.println("Exit");
            input.close();
            break;
        }
        
        } 
        
        
        
    }
    
   
   
}


