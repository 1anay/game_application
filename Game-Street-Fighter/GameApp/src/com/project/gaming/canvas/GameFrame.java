package com.project.gaming.canvas;

import javax.swing.JFrame;

import com.project.gaming.utils.Gameconstant;

public class GameFrame extends JFrame implements Gameconstant {
	
	public GameFrame() throws Exception {
		setResizable(false);
		setTitle(TITLE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(GWIDTH,GHEIGHT);
		setLocationRelativeTo(null);
		Board board= new Board();
		add(board);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			GameFrame obj = new GameFrame();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}