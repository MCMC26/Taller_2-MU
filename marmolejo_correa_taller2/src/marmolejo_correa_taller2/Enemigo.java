package marmolejo_correa_taller2;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Enemigo extends Thread {

	private PApplet app;
	private PVector pos;
	private int tam;
	private PVector vel;
	private int contador;
	private PImage Sully;
	private boolean vivo;
	private Logica log;
	
	public Enemigo (PApplet app, Logica log) {
		this.app = app;
		this.log = log;
		pos = new PVector(app.random(0,app.width/2),app.random(0,app.height/2));
		vel = new PVector(0, 0);
		Sully= app.loadImage("Sully.png");
		vivo = true;
	}
	public void run() {
		while(vivo) {				
			//if( detectar() ==  true ){			
				
				//vivo = false;
			//}else {			
				mover();
				try {
					sleep(16);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}		
			}			
				
		}
	

	
	

	

	
	public void pintar() {
		app.image(Sully, pos.x, pos.y );
		app.stroke(27,153,160);
		app.noFill();
		app.ellipse(pos.x+95, pos.y-1,20,20);
		app.fill(27,153,160);
		app.text(contador,pos.x+92, pos.y+3);
		}
	public void mover() {
		vel = PVector.sub(log.getPer().getPos(), pos);
		vel.normalize();
		vel.mult(3);
		pos.add(vel);
	}
	public void validarChoque(){
		
	}
	public void validarRecoger() {
		
	}
	
	public PVector getPos() {
		return pos;
	}
}
 