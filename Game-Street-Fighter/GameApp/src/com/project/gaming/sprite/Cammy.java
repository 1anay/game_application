package com.project.gaming.sprite;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.project.gaming.utils.Gameconstant;

public class Cammy extends Sprite implements Gameconstant{
	BufferedImage damageEffect[]=new BufferedImage[2];
	private BufferedImage IdleImages [] = new BufferedImage[6];
	private BufferedImage walkImages[] =new BufferedImage[5];
	private BufferedImage KickImages[] =new BufferedImage[5];
	private BufferedImage PunchImages[] =new BufferedImage[2];
	private BufferedImage jumpImages[] = new BufferedImage[7];
public Cammy() throws Exception {
	x=150;
	h=w=220;
	y= FLOOR -h;
	speed=SPEED;
	image =ImageIO.read(Cammy.class.getResource(Ply_Image));
	LoadDamageEffect();
	loadidleImages();
	loadwalkImages();
	loadKickImages();
	loadPunchImages();
	loadjumpImages();
}
public void jump() {
	if(!isjump) {
	isjump =true;
	force=-18;
	y+=force;
	}
}
public void fall() {
	if(y>=(FLOOR-h)) {
		isjump=false;
		return;
	}
	y=y+force;
	force+=gravity;
	
}

public void LoadDamageEffect() {
	damageEffect[0]=image.getSubimage(8,3736,85,105);
	damageEffect[1]=image.getSubimage(97,3744,67,95);
}

private void loadidleImages() {
	IdleImages[0]= image.getSubimage(66, 482,85,96);
	IdleImages[1]= image.getSubimage(160, 479,81,98);
	IdleImages[2]= image.getSubimage(246, 476,83,99);
	IdleImages[3]= image.getSubimage(332, 477,83,99);
	IdleImages[4]= image.getSubimage(419, 476,83,99);
	IdleImages[5]= image.getSubimage(501, 477,83,99);
}

private void loadwalkImages() {
	walkImages[0]= image.getSubimage(71,585,79,110);
	walkImages[1]= image.getSubimage(230,585,76,110);
	walkImages[2]= image.getSubimage(376,585,62,110);
	walkImages[3]= image.getSubimage(509,585,82,110);
	walkImages[4]= image.getSubimage(741,585,73,110);
}

private void loadKickImages() {
	KickImages[0]= image.getSubimage(46,1885,91,105);
	KickImages[1]= image.getSubimage(139,1889,86,102);
	KickImages[2]= image.getSubimage(224,1886,133,104);
	}

private void loadPunchImages() {
	PunchImages[0]= image.getSubimage(103,1629,95,101);
	PunchImages[1]= image.getSubimage(199,1630,128,101);
}

private void loadjumpImages() {
	jumpImages[0] = image.getSubimage(89,959,71,141);
	jumpImages[1] = image.getSubimage(161,945,65,103);
	jumpImages[2] = image.getSubimage(232,938,65,88);
	jumpImages[3] = image.getSubimage(297,936,60,77);
	jumpImages[4] = image.getSubimage(232,938,65,88);
	jumpImages[5] = image.getSubimage(161,945,65,103);
	jumpImages[6] = image.getSubimage(489,949,65,146);
}

public BufferedImage printdamageImage() {
	if(imageIndex>damageEffect.length-1) {
		imageIndex=0;
		CurrentMove=walk;
	}
	BufferedImage img= damageEffect[imageIndex];
	imageIndex++;
	return img;
}

private BufferedImage printidle() {
	Isattacking=false;
	if(imageIndex>5) {
		imageIndex=0;
	}
	BufferedImage img=IdleImages[imageIndex];
	imageIndex++; // changing image frames
	return img;
}

private BufferedImage printWalk() {
	if(imageIndex>4) {
		imageIndex=0;
		CurrentMove= IDLE;
		Isattacking=false;
	}
	BufferedImage img=walkImages[imageIndex];
	imageIndex++; // changing image frames
	return img;
}

private BufferedImage printkick() {
	if(imageIndex>2) {
		imageIndex=0;
		CurrentMove= IDLE;
		Isattacking=false;
	}
	BufferedImage img=KickImages[imageIndex];
	Isattacking=true;
	imageIndex++; // changing image frames
	return img;
}
private BufferedImage printpunch() {
	if(imageIndex>1) {
		imageIndex=0;
		CurrentMove= IDLE;
		Isattacking=false;
	}
	BufferedImage img=PunchImages[imageIndex];
	Isattacking=true;
	imageIndex++; // changing image frames
	return img;
}

private BufferedImage printJump() {
	if(imageIndex>6) {
	imageIndex=0;
	CurrentMove = IDLE;
	Isattacking=false;
	}
	BufferedImage img = jumpImages[imageIndex];
	imageIndex++; // Change Image Frames
	return img;
	}

@Override
public BufferedImage defaultImage() {
	 if(CurrentMove==kick) {
		return printkick();
	 }
	 else if(CurrentMove==punch) {
			return printpunch();
		 }
	 else if (CurrentMove ==jump){
			return printJump();
			}
	 else if (CurrentMove ==walk){
			return printWalk();
			}
	 else
		 return printidle();
	

}

}
