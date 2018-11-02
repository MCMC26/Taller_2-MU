package marmolejo_correa_taller2;

import processing.core.PApplet;

public class Main extends PApplet {
	private Logica log;
	
	public static void main(String[] args) {
		PApplet.main("marmolejo_correa_taller2.Main");
		// TODO Auto-generated method stub

	}
	public void settings() {
		size(1200,700);
	}
	
	public void setup() {
		log = new Logica(this);
	}
	public void draw() {
		log.dibujar();
	}
	public void mousePressed() {
		System.out.println("x:" + mouseX + ",y:"+ mouseY);
		log.clickear();
	}
	public void keyPressed() {
		log.teclear();
	}
	public void keyReleased() {
		log.soltado();
	}

}
