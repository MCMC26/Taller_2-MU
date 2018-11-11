package marmolejo_correa_taller2;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public abstract class Objeto {

	protected PApplet app;
	protected PVector pos;
	protected Tanque tank;
	protected float Aleatorio1;
	protected float Aleatorio2;
	
	protected int tam;
	//protected float Aleatorio1;
	//protected float Aleatorio2;
	protected PImage veneno, gorra, cafe, media, recurso;
	
	public Objeto(PApplet app) {
		this.app=app;
		
		
		
		veneno = app.loadImage("Veneno.png");
		gorra = app.loadImage("Gorra.png");
		cafe = app.loadImage("Cafe.png");
		media = app.loadImage("Media.png");
		recurso = app.loadImage("Recurso.png");
		
		
		
	}
	
	public void pintar() {
	
	}
	
	public void morir() {
		
	}
	
	public PVector getPos() {
		return pos;
	}
	
}
