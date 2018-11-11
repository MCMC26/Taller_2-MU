package marmolejo_correa_taller2;

import processing.core.PApplet;
import processing.core.PVector;

public class Tanque extends Objeto{

	
	
	private Logica log;
	public Tanque(PApplet app) {
		super(app);
		Aleatorio1  = app.random(100,1000);
		Aleatorio2  = app.random(100,600);
		pos = new PVector(Aleatorio1,Aleatorio2);
		
		// TODO Auto-generated constructor stub
	}
	
	public void pintar() {
		
		app.image(recurso,pos.x,pos.y);
	}
	
	public void morir() {
		
	}

	//Este metodo sobra
	public boolean borrar() {
		if(app.dist(log.getPer().getPos().x,log.getPer().getPos().y, pos.x,pos.y)<=100) {
			return true;
		}else return false;
	}
	
	
}
