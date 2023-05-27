package com.project.gaming.canvas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.project.gaming.sprite.Ken;
import com.project.gaming.sprite.Cammy;
import com.project.gaming.sprite.HealthBar;
import com.project.gaming.utils.Gameconstant;

public class Board extends JPanel implements Gameconstant {
	BufferedImage imagebg;
	private Cammy player;
	private Ken oppplayer;
	private HealthBar CmyFullPower;
	private HealthBar KenFullPower;
	private Timer timer;
	private boolean gameOver;
	
	private void GameLoop() {
		timer=new Timer(gameloop,new ActionListener() {
			
			@Override 
			public void actionPerformed(ActionEvent e) {
		
				repaint();// this will call paint component
				if(gameOver) {
					timer.stop();
				}
				player.fall();
				oppplayer.fall();
				collision();
				IsGameOver();
			}
		});
		timer.start();
	}
	private void Loadpower() {
		CmyFullPower= new HealthBar(80,"Cammy");
		KenFullPower= new HealthBar(GWIDTH-500,"Ken");
	}
	private void printFullPower(Graphics g) {
		CmyFullPower.printRectangle(g);
		KenFullPower.printRectangle(g);
	}
	
private boolean iscollision() {
	int xdistance= Math.abs(player.getX()-oppplayer.getX());
	int ydistance= Math.abs(player.getY()-oppplayer.getY());
	int maxh=Math.max(player.getH(),oppplayer.getH());
	int maxw=Math.max(player.getW(),oppplayer.getW());
	return xdistance<=(maxw-30) && ydistance<=(maxh-20);
}
private void collision() {
	if(iscollision()) {
		if(player.isIsattacking() && oppplayer.isIsattacking()){
			
		}
		else if(player.isIsattacking()){
			oppplayer.setCurrentMove(damage);
			KenFullPower.setHealth();
			
		}
		else if(oppplayer.isIsattacking()){
			player.setCurrentMove(damage);
			CmyFullPower.setHealth();
		}
		player.setIscollision(true);
		player.setSpeed(SPEED);
		oppplayer.setIscollision(true);
		oppplayer.setSpeed(SPEED);
	}
	else {
		player.setIscollision(false);
		player.setSpeed(SPEED);
		oppplayer.setIscollision(false);
		oppplayer.setSpeed(SPEED);
	}
	
}
private void IsGameOver() {
	if(CmyFullPower.getHealth()<=0 ||KenFullPower.getHealth()<=0)
		gameOver=true;
}
private void printgameover(Graphics pen) {
	if(gameOver) {
		pen.setColor(Color.BLACK);
	pen.setFont(new Font("Times",Font.BOLD,100));
	pen.drawString("Game Over!!",GWIDTH/2-300,GHEIGHT/2);
	}
}
	public Board() throws Exception {
		player =new Cammy();
		oppplayer=new Ken();
		LoadBackGroundImage();
		setFocusable(true);
		bindEvents();
		GameLoop();
		Loadpower();
	}
	
	
	private void bindEvents() {
		KeyListener listener= new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent e) {
			//System.out.println("typed"+ e.getKeyCode()+" "+ e.getKeyChar()); 
			
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			//System.out.println("release"+ e.getKeyCode()+" "+ e.getKeyChar());
			
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			// cammmy
			if(e.getKeyCode()==KeyEvent.VK_A) {
				player.setCurrentMove(walk);
				player.setIscollision(false);
				player.setSpeed(-SPEED);
				player.move();
				//repaint();
			}
			
			if(e.getKeyCode()==KeyEvent.VK_D) {
				player.setCurrentMove(walk);
				player.setSpeed(SPEED);
				player.move();
				//repaint();
			}
			//cammy kick 
			else if(e.getKeyCode()==KeyEvent.VK_C) {
				player.setCurrentMove(kick);
			}
			//punch
			else if(e.getKeyCode()==KeyEvent.VK_F) {
				player.setCurrentMove(punch);
			}
			//jump
			else if (e.getKeyCode()==KeyEvent.VK_SPACE){
				player.setCurrentMove(jump);
				player.jump();
			}
			
			
			
			
			// ken
			if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				oppplayer.setCurrentMove(walk);
				oppplayer.setSpeed(-SPEED);
				oppplayer.move();
				//repaint();
			}
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				oppplayer.setCurrentMove(walk);
				oppplayer.setIscollision(false);
				oppplayer.setSpeed(SPEED);
				oppplayer.move();
				//repaint();
			}
			
			//Ken kick 
			else if(e.getKeyCode()==KeyEvent.VK_K) {
				oppplayer.setCurrentMove(kick);
			}
			//punch
			else if(e.getKeyCode()==KeyEvent.VK_P) {
				oppplayer.setCurrentMove(punch);
			}
			//jump
			else if (e.getKeyCode()==KeyEvent.VK_L){
				oppplayer.setCurrentMove(jump);
				oppplayer.jump();
			}
			//System.out.println("press"+ e.getKeyCode()+" "+ e.getKeyChar());
		}
		
		};
		this.addKeyListener(listener);
	} 
	
	
	
	@Override
	public void paintComponent(Graphics pen) {
		//rendering or painting
		super.paintComponent(pen);
		DisplayBgImage(pen);
		player.drawplayer(pen);
		oppplayer.drawplayer(pen);
		printFullPower(pen);
		printgameover(pen);
	}
	
	
	private void DisplayBgImage(Graphics pen) {
		pen.drawImage(imagebg,0,0,GWIDTH,GHEIGHT,null );
	}
	
	
	private void LoadBackGroundImage() {
		try {
			imagebg = ImageIO.read(Board.class.getResource(Bg_Image));
			}
			catch(Exception e) {
			System.out.println("background image loading fail.....");
			System.exit(0);
			}
	}
}