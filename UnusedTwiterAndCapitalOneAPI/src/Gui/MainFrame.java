/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import javax.swing.JFrame;

/**
 *
 * @author Rohans
 */
public class MainFrame extends JFrame{
public MainFrame(){
	super("Clock");
	this.add(new MainPanel());
	this.pack();
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
	
}