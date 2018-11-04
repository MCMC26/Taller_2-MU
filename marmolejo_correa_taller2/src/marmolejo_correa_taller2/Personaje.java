package marmolejo_correa_taller2;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Personaje {

	private PApplet app;
	private PVector pos;
	private int tam;
	private PVector vel;
	private int contador;
	private PImage Mike;
	private boolean vivo;
	private boolean soltar = true;
	private boolean arriba,abajo,izquierda,derecha,diagonal1 = false;
	
	
	public Personaje (PApplet app) {
		this.app = app;
		Mike = app.loadImage("Mike.png");
		pos = new PVector(app.width/2,app.height/2);
		vel = new PVector(3,3);
	}
	public void run() {
		
	}
	
	public void pintar() {
		app.image(Mike, pos.x, pos.y );
		if(arriba==true) {pos.y=pos.y-vel.y;}
		if(abajo ==true) {pos.y=pos.y+vel.y;}
		if(derecha ==true) {pos.x= pos.x+vel.x;}
		if(izquierda ==true) {pos.x=pos.x-vel.x;}
		//if(diagonal1==true) {pos.y=pos.y-vel.y; pos.x=pos.x-vel.x; }
		app.stroke(147,182,53);
		app.noFill();
		
	}
	public void mover() {
	soltar = false;
		if(app.keyCode== app.UP){
			//pos.y=pos.y-vel.y;
			arriba = true;
		}
		
		if(app.keyCode== app.DOWN){
			abajo = true;	
		}
		if(app.keyCode== app.RIGHT){
			derecha = true;
			
		}
		if(app.keyCode== app.LEFT){
			izquierda = true;
			
		}
	/*	if(app.keyCode== app.LEFT && app.keyCode==app.UP){
			diagonal1 = true;
		}*/
	
		

		
		
	}
	
	public void soltar() {
		soltar = true;
		if(app.keyCode== app.UP){
			//pos.y=pos.y-vel.y;
			arriba = false;
		}
		
		if(app.keyCode== app.DOWN){
			abajo = false;	
		}
		if(app.keyCode== app.RIGHT){
			derecha = false;
			
		}
		if(app.keyCode== app.LEFT){
			izquierda = false;
			
		}
		
	}
	public void validarChoque(){
		
	}
	public void validarRecoger() {
		
	}
	
	public PVector getPos() {
		return pos;
	}
	
	
	
	
}
