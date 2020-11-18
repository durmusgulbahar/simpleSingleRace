/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructurehw1_20180808076;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Durmus
 */
public class Terrain {
    int[][] terrain;
    int height;
    int width;
    int numberOfPeople;
    int numberOfObstacle;
    
    public Terrain() throws Exception{  
        
        readInfo();
        
        this.terrain = new int[this.height][this.width];
        for(int i=0;i<terrain.length;i++){
            for(int j=0;j<terrain[i].length;j++){
                terrain[i][j]=0;
                
            }
           
        
        }
       
        placeObstacle(terrain);
        saveConfig(terrain);
      
    }
    
    
    public void readInfo(){  //Takes the varibles from var.cfg 
        try{
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Durmus\\Masaüstü\\NetBeansProjects\\DataStructureHW1_20180808076\\src\\datastructurehw1_20180808076\\var.cfg"));
        
        String line;
        String[] l ;
        
        ArrayList<Integer> num = new ArrayList<>();
        
        
        while(br.ready()){
         
           line = br.readLine(); 
           
           l = line.split(" ");
           
           num.add(Integer.parseInt(l[1]));
           
            
            
     }
        br.close();
        Object[] nums = num.toArray();
       
        //assign varibles from var.cfg to terrain object properties.
       
       this.height = Integer.parseInt(nums[0].toString());
       this.width = Integer.parseInt(nums[1].toString());
       this.numberOfPeople = Integer.parseInt(nums[2].toString());
       this.numberOfObstacle = Integer.parseInt(nums[3].toString());
     
        
        
        }
        catch(Exception e){
            System.out.println();
        }
    
    }
  
    
   public void saveConfig(int[][] ter) throws Exception{ // Saves the player location to the output.txt file.
      
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Durmus\\Masaüstü\\NetBeansProjects\\DataStructureHW1_20180808076\\src\\datastructurehw1_20180808076\\output.txt"));
            
            for(int i=0;i<ter.length;i++){
                for(int j=0;j<ter[i].length;j++){
                    bw.write(ter[i][j]+((j==ter[i].length-1 ? "" : " ")));
                    
                }
                bw.newLine();
                
            }
          bw.flush();
        }

        catch(Exception e){ // if there is no output.txt this will create
           File file = new File("output.txt");
           file.createNewFile();
        }
        
       
       
   }
   
   public void placeObstacle(int[][] ter){ // places the obstacle every row, 1 obstacle for each row.
       Obstacle obstacle = new Obstacle();
       
       for(int i=0;i<ter.length;i++){
           
           Random random = new Random();
           
           int rand = random.nextInt(ter[i].length-1);
           
           ter[i][rand+1]=obstacle.o;
       }
   }
}
