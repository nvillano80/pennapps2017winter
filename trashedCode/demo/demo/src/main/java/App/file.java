/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Rohans
 */
public class file {
	public String getStringFomFile(String fileName){
		File f = new File(fileName);
	Scanner s = null;
		try{
	s = new Scanner(f);
		}catch(Exception ex){}
	return s.nextLine();
	}
	public void clear(String fileName){
	try{	
		File f = new File(fileName);
	BufferedWriter out = new BufferedWriter(new FileWriter(f));
		}catch(Exception ex){}
	}
}
