/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructurehw1_20180808076;

import datastructurehw1_20180808076.*;
import java.lang.Thread;
/**
 *
 * @author Durmus
 */


public class Race {
    
    public Race(){
        
        
    }
    
    public void start() throws Exception{
        Thread thread = new Thread();
        
        Terrain terrain = new Terrain();
       
        System.out.println("------------------------------"+"\n"+"RACE WILL BEGIN !!!"+"\n"+"------------------------------");
        
        for(int i =3;i>0;i--){
            System.out.println(i+"...");
            thread.sleep(800);
        }
        
        
        
        Player player1 = new Player();
        
        player1.move(terrain);
        
        
        
        finish(player1, terrain);
        
        
        
        
    }
    
 
    
    public void finish(Player p,Terrain t){
        
       
        
        for(int i=0;i<t.height;i++){
           int f = t.terrain[i][t.width-1];
           
           if(f == -1){
               System.out.println("\n"+"*******************"+"\n\n"+"Player "+p.p+"  WON !!"+"\n\n"+"*******************");
               System.exit(0);
           }
        }
        
        
    }
    
    
}
