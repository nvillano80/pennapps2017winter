/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Rohans
 */
public class MainPanel extends JPanel{
	public static final int SIZEX= 640;
	public static final int SIZEY=480;
	
public Dimension getPreferredSize(){
	return new Dimension(SIZEX,SIZEY);
}

	/**
	 *
	 * @param g
	 */
	public void paintComponent(Graphics g){
	super.paintComponent(g);
	g.setColor(Color.green);
	g.fillRect(0, 0, SIZEX,SIZEY);
}
}
