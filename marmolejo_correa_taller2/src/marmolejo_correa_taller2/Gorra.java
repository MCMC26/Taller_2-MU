package marmolejo_correa_taller2;

import processing.core.PApplet;
import processing.core.PVector;

public class Gorra extends Objeto{
	
	
	public Gorra(PApplet app, PVector pos) {
		super(app,pos);
		// TODO Auto-generated constructor stub
	}
	
	public void pintar() {
		app.image(gorra,pos.x,pos.y);
	}
	
	public void morir() {
		
	}

	
	
}