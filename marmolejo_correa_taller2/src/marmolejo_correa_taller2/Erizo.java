package marmolejo_correa_taller2;

import processing.core.PApplet;
import processing.core.PVector;

public class Erizo extends Objeto{
	
	
	public Erizo(PApplet app, PVector pos) {
		super(app,pos);
		// TODO Auto-generated constructor stub
	}
	
	public void pintar() {
		app.image(veneno,pos.x,pos.y);
	}
	
	public void morir() {
		
	}

	
	
}