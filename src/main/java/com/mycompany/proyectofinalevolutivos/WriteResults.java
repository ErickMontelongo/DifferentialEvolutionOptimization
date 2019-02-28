/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectofinalevolutivos;

import DiferentialEvolution.Individual.Individual;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Punkid PC
 */
public class WriteResults {
    private File outputFile;
    
    public WriteResults(String path){
        outputFile = new File(path);
    }
    
    public void writeToFile(String s){
        try{
        FileWriter fw = new FileWriter(outputFile, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(s);
        bw.newLine();
        bw.flush();
        }
        catch(IOException e){
            System.out.println("Error opening the file");
            e.printStackTrace();
        }
    }
}
