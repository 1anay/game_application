package com.project.gaming.sprite;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class HealthBar extends Sprite{
	
	String playername;
	public HealthBar(int x,String playername) {
		this.x=x;
		y=50;
		h=30;
		w=400;
		this.playername=playername;
	}

	@Override
	public BufferedImage defaultImage() {
		// TODO Auto-generated method stub
		return null;
	}
	public void printRectangle(Graphics pen) {
		pen.setColor(Color.RED);
		pen.fillRect(x, y, w, h);
		pen.setColor(Color.GREEN);
		pen.fillRect(x, y, health, h);
		pen.setColor(Color.BLACK);
		pen.setFont(new Font("Times",Font.BOLD,20));
		pen.drawString(playername,x+5, y+h+20);
	}

}
