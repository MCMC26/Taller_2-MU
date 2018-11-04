package marmolejo_correa_taller2;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Objeto {

	protected PApplet app;
	protected PVector pos;
	protected Tanque tank;
	
	protected int tam;
	protected float Aleatorio1;
	protected float Aleatorio2;
	protected PImage veneno, gorra, cafe, media, recurso;
	
	public Objeto(PApplet app, PVector pos) {
		this.app=app;
		this.pos = pos;
		Aleatorio1  = app.random(100,1100);
		Aleatorio2  = app.random(100,1100);
		
		veneno = app.loadImage("Veneno.png");
		gorra = app.loadImage("Gorra.png");
		cafe = app.loadImage("Cafe.png");
		media = app.loadImage("Media.png");
		recurso = app.loadImage("Recurso.png");
		
		pos = new PVector(Aleatorio1,Aleatorio2);
		tank = new Tanque(app, pos);
	}
	
	public void pintar() {
	
	}
	
	public void morir() {
		
	}
}
