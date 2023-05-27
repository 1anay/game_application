package com.project.gaming.sprite;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.project.gaming.utils.Gameconstant;

public abstract class Sprite implements Gameconstant{
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected BufferedImage image;
	protected int speed; 
	protected int imageIndex;
	protected int CurrentMove;
	protected int force;
	protected boolean isjump;
	protected boolean iscollision;
	
	protected boolean Isattacking;
	protected int health;
	
	public Sprite() {
		health=Maxhealth;
	}
	

	
public int getHealth() {
		return health;
	}



	public void setHealth() {
		this.health = (int)(this.health - Maxhealth* 0.10);
	}



public boolean isIsattacking() {
		return Isattacking;
	}

	public void setIsattacking(boolean isattacking) {
		Isattacking = isattacking;
	}

public int getCurrentMove() {
		return CurrentMove;
	}

	public void setCurrentMove(int currentMove) {
		CurrentMove = currentMove;
	}

public abstract BufferedImage defaultImage();

public void drawplayer(Graphics pen) {
	pen.drawImage(defaultImage(),x,y,w,h,null);
	}
public boolean isIscollision() {
	return iscollision;
}

public void setIscollision(boolean iscollision) {
	this.iscollision = iscollision;
}

public void move() {
	if(!iscollision)
	x=x+speed;
}

public int getX() {
	return x;
}

public void setX(int x) {
	this.x = x;
}

public int getY() {
	return y;
}

public void setY(int y) {
	this.y = y;
}

public int getW() {
	return w;
}

public void setW(int w) {
	this.w = w;
}

public int getH() {
	return h;
}

public void setH(int h) {
	this.h = h;
}

public BufferedImage getImage() {
	return image;
}

public void setImage(BufferedImage image) {
	this.image = image;
}

public int getSpeed() {
	return speed;
}

public void setSpeed(int speed) {
	this.speed = speed;
}
}