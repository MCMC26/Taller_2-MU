package marmolejo_correa_taller2;

import processing.core.PApplet;
import processing.core.PVector;

public class Taza extends Objeto{

	public Taza(PApplet app) {
		super(app);
		Aleatorio1  = app.random(100,1000);
		Aleatorio2  = app.random(100,600);
		pos = new PVector(Aleatorio1,Aleatorio2);
		// TODO Auto-generated constructor stub
	}
	
	public void pintar() {
		app.image(cafe,pos.x,pos.y);
	}
	
	public void morir() {
		
	}

	
	
}
