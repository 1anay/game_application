package com.project.gaming.sprite;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.project.gaming.utils.Gameconstant;

public class Ken extends Sprite implements Gameconstant {
	BufferedImage damageEffect[]=new BufferedImage[5];
	private BufferedImage IdleImages [] = new BufferedImage[10];
	private BufferedImage walkImages [] = new BufferedImage[12];
	private BufferedImage kickImages[] = new BufferedImage[12];
	private BufferedImage punchImages[] = new BufferedImage[6];
	private BufferedImage jumpImages[] = new BufferedImage[7];
	
	public Ken() throws Exception {
		x=1150;
		h=w=220;
		y= FLOOR -h;
		imageIndex=0;
		speed=SPEED;
		CurrentMove=IDLE;
		image =ImageIO.read(Cammy.class.getResource(Opp_Image));
		LoadDamageEffect();
		loadIdleImages();
		loadWalkImages();
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
		damageEffect[0]=image.getSubimage(1358,3276,74,93);
		damageEffect[1]=image.getSubimage(1436,3275,87,94);
		damageEffect[2]=image.getSubimage(1539,3278,78,91);
		damageEffect[3]=image.getSubimage(1626,3278,76,91);
		damageEffect[4]=image.getSubimage(1709,3275,66,93);
	}
	
	private void loadIdleImages() {
		IdleImages[0] = image.getSubimage(1694,680,58,98);
		IdleImages[1] = image.getSubimage(1762,680,58,98);
		IdleImages[2] = image.getSubimage(1830,680,58,98);
		IdleImages[3] = image.getSubimage(1900,680,58,98);
		IdleImages[4] = image.getSubimage(1969,680,58,98);
		IdleImages[5] = image.getSubimage(2037,680,58,98);
		IdleImages[6] = image.getSubimage(1969,680,58,98);
		IdleImages[7] = image.getSubimage(1900,680,58,98);
		IdleImages[8] = image.getSubimage(1830,680,58,98);
		IdleImages[9] = image.getSubimage(1762,680,58,98);
		}

	private void loadWalkImages() {
		walkImages[0] = image.getSubimage(1965,866,63,92);
		walkImages[1] = image.getSubimage(1890, 865,68,92);
		walkImages[2] = image.getSubimage(1817,865,68,92);
		walkImages[3] = image.getSubimage(1753, 864,58,92);
		walkImages[4] = image.getSubimage(1683, 864,61,97);
		walkImages[5] = image.getSubimage(1620, 864,61,97);
		walkImages[6] = image.getSubimage(1547, 864,61,97);
		walkImages[7] = image.getSubimage(1480, 862,61,97);
		walkImages[8] = image.getSubimage(1408, 859,61,100);
		walkImages[9] = image.getSubimage(1336, 860,61,100);
		walkImages[10] = image.getSubimage(1262, 864,65,94);
		walkImages[11] = image.getSubimage(2028, 869,63,92);
		}
	
	private void loadKickImages() {
		kickImages[0] = image.getSubimage(2019, 2207,78,96);
		kickImages[1] = image.getSubimage(1940, 2206,78,96);
		kickImages[2] = image.getSubimage(1867, 2203,65,96);
		kickImages[3] = image.getSubimage(1753, 2197,109,102);
		kickImages[4] = image.getSubimage(1620,2196,109,102);
		kickImages[5] = image.getSubimage(1529, 2195,78,102);
		kickImages[6] = image.getSubimage(1450, 2196,78,102);
		kickImages[7] = image.getSubimage(1351, 2200,78,102);
		kickImages[8] = image.getSubimage(1281, 2196,63,100);
		kickImages[9] = image.getSubimage(1213, 2195,63,100);
		kickImages[10] = image.getSubimage(1143, 2198,63,100);
		}
	
	private void loadPunchImages() {
		punchImages[0] = image.getSubimage(2030,1148,67,92);
		punchImages[1] = image.getSubimage(1931,1151,93,92);
		punchImages[2] = image.getSubimage(1865,1151,66,92);
		punchImages[3] = image.getSubimage(1788,1147,77,101);
		punchImages[4] = image.getSubimage(1666,1145,117,101);
		punchImages[5] = image.getSubimage(1788,1147,77,101);
		}

	private void loadjumpImages() {
		jumpImages[0] = image.getSubimage(1380,1058,61,90);
		jumpImages[1] = image.getSubimage(1314,1034,63,109);
		jumpImages[2] = image.getSubimage(1251,991,59,95);
		jumpImages[3] = image.getSubimage(1187,963,61,84);
		jumpImages[4] = image.getSubimage(1136,962,54,75);
		jumpImages[5] = image.getSubimage(1007,1006,63,110);
		jumpImages[6] = image.getSubimage(1380,1058,61,90);
		
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
	

	private BufferedImage printIdle() {
		Isattacking=false;
		if(imageIndex>9) {
		imageIndex=0;
		}
		BufferedImage img = IdleImages[imageIndex];
		imageIndex++; // Change Image Frames
		return img;
		}
	
		private BufferedImage printWalk() {
		if(imageIndex>11) {
		imageIndex=0;
		 CurrentMove = IDLE;
		 Isattacking=false;
		}
		BufferedImage img = walkImages[imageIndex];
		imageIndex++; // Change Image Frames
		return img;
		}
		
		private BufferedImage printKick() {
		if(imageIndex>11) {
		imageIndex=0;
		CurrentMove = IDLE;
		Isattacking=false;
		}
		BufferedImage img = kickImages[imageIndex];
		Isattacking=true;
		imageIndex++; // Change Image Frames
		return img;
		}
		
		private BufferedImage printPunch() {
		if(imageIndex>5) {
		imageIndex=0;
		CurrentMove = IDLE;
		Isattacking=false;
		}
		BufferedImage img = punchImages[imageIndex];
		Isattacking=true;
		imageIndex++; // Change Image Frames
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
		// TODO Auto-generated method stub
		// return image.getSubimage(1263, 863, 64, 93);
		// return image.getSubimage(1756, 685, 62, 94);
		if(CurrentMove == kick) {
		return printKick();
		}
		else if (CurrentMove == punch) {
		return printPunch();
		}
		else if (CurrentMove ==jump){
			return printJump();
			}
		else if (CurrentMove ==walk){
		return printWalk();
		}
		else {
		return printIdle();
		// return printWalk();
		}
		}

	
	/*@Override
	public BufferedImage defaultImage() {
		if(CurrentMove ==walk) 
			return image.getSubimage(1756, 685,62,84);
		else
			return printdamageImage();
		

	}*/

}
