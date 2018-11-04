package marmolejo_correa_taller2;

import processing.core.PApplet;
import processing.core.PVector;

public class Tanque extends Objeto{
	
	
	public Tanque(PApplet app, PVector pos) {
		super(app,pos);
		// TODO Auto-generated constructor stub
	}
	
	public void pintar() {
		app.image(recurso,pos.x,pos.y);
	}
	
	public void morir() {
		
	}

	
	
}
