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
	private boolean arriba,abajo,izquierda,derecha = false;
	
	
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
		app.stroke(147,182,53);
		app.noFill();
		app.ellipse(pos.x+95, pos.y-1,20,20);
		app.fill(147,182,53);
		app.text(contador,pos.x+92, pos.y+3);
		
	}
	public void mover() {
		
		
		if(app.keyCode== app.UP){
			//pos.y=pos.y-vel.y;
			arriba = true;
		}else {
			arriba = false;
		}
		if(app.keyCode== app.DOWN){
			abajo = true;		
		}else {
			abajo =false;
		}
		if(app.keyCode== app.RIGHT){
			derecha = true;
		}else {
			derecha = false;
		}
		if(app.keyCode== app.LEFT){
			izquierda = true;
		}else {
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
