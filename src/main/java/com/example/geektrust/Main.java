package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import com.example.geektrust.modal.CoOrdinates;
import com.example.geektrust.process.CoordinatePoints;
import com.example.geektrust.process.PowerLoss;
import com.example.geektrust.process.Turn;

public class Main {

    public static void main(String[] args) {
        Integer sourceX=0, sourceY=0, destinationX=0, destinationY=0;
        String direction="";

        try {
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); 
            while (sc.hasNextLine()) {
                String input = sc.nextLine();
                String[] cmd = input.split(" ");
                switch (cmd[0]) {
                    case "SOURCE":
                        sourceX = Integer.parseInt(cmd[1]);
                        sourceY =  Integer.parseInt(cmd[2]);
                        direction =  cmd[3];
                        break;
                    case "DESTINATION":
                        destinationX = Integer.parseInt(cmd[1]);
                        destinationY = Integer.parseInt(cmd[2]);
                        break;
                    case "PRINT_POWER":
                    	CoOrdinates cordinates = new CoOrdinates(sourceX, sourceY, destinationX, destinationY, direction);
                    	Turn calculateTurns = new Turn(cordinates);
                    	CoordinatePoints calculateGrid = new CoordinatePoints(cordinates);
                    	PowerLoss powerLoss = new PowerLoss(calculateGrid, calculateTurns);
                        Integer power = powerLoss.resultant();    
                        System.out.println("POWER "+ power);
                        break;                    
                }
            }
            
            
            sc.close(); 
        } catch (IOException e) {
        }
    }
}
