package marmolejo_correa_taller2;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Enemigo {

	private PApplet app;
	private PVector pos;
	private int tam;
	private PVector vel;
	private int contador;
	private PImage Sully;
	private boolean vivo;
	
	public Enemigo (PApplet app) {
		this.app = app;
	}
	
	public void pintar() {
		
	}
	public void mover() {
		
	}
	public void validarChoque(){
		
	}
	public void validarRecoger() {
		
	}
	
	public PVector getPos() {
		return pos;
	}
}
