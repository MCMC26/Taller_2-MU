package marmolejo_correa_taller2;

import processing.core.PApplet;
import processing.core.PVector;

public class Taza extends Objeto{
	
	
	public Taza(PApplet app, PVector pos) {
		super(app,pos);
		// TODO Auto-generated constructor stub
	}
	
	public void pintar() {
		app.image(cafe,pos.x,pos.y);
	}
	
	public void morir() {
		
	}

	
	
}
