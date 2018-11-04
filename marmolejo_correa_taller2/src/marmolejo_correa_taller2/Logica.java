package marmolejo_correa_taller2;

import java.util.ArrayList;
import java.util.LinkedList;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Logica {
	int pantalla = 0;
	private PApplet app;
	private PVector pos;
	
	private PImage play,play2,Media,barraCafe,barraGorra, barraMedia, barraVeneno, Cafe,fondo,Ganaste,Gorra,inicio,instrucciones,Mike,Perdiste,Recurso,Reloj,score,Sully,Veneno;
	private Personaje per;
	private Enemigo ene;
	private ArrayList<Objeto> objetos;
	
	public Logica (PApplet app) {
		this.app = app;
		
	
		barraCafe = app.loadImage("BarraCafe.png");
		barraGorra = app.loadImage("BarraGorra.png");
		barraMedia = app.loadImage("BarraMedia.png");
		barraVeneno = app.loadImage("BarraVeneno.png");
		Cafe = app.loadImage("Cafe.png");
		fondo = app.loadImage("fondo.png");
		Ganaste = app.loadImage("Ganaste.png");
		Gorra = app.loadImage("Gorra.png");
		inicio = app.loadImage("inicio.png");
		instrucciones = app.loadImage("instrucciones.png");
		Media = app.loadImage("Media.png");
		Mike = app.loadImage("Mike.png");
		Perdiste = app.loadImage("Perdiste.png");
		Recurso = app.loadImage("Recurso.png");
		Reloj = app.loadImage("Reloj.png");
		score = app.loadImage("score.png");
		Sully = app.loadImage("Sully.png");
		Veneno = app.loadImage("Veneno.png");
		play = app.loadImage("play.png");
		play2 = app.loadImage("play2.png");
		
		per = new Personaje(app);
		ene= new Enemigo (app ,this);
		objetos = new ArrayList<Objeto>();
		
		
		
		
		
	}
	
	public void dibujar() {
		switch(pantalla) {
		case 0:
		app.image(inicio, 0, 0);
		if (app.mouseX >346 && app.mouseX < 612 && app.mouseY >525 && app.mouseY < 658) {
			app.image(play2, 290, 522,play2.width*1.1f,play2.height*1.1f);
		}
		break;
		
		case 1:
		app.image(instrucciones, 0, 0);
		app.fill(104,203,25);
		app.noStroke();
	    app.rect(app.width/2-170, app.height/2+180, 270, 120, 30, 30, 30, 30);
	    app.noFill();
		app.image(play, app.width/2 -155, app.height/2 +195);
		
		if(app.mouseX >430 && app.mouseX < 695 && app.mouseY >529 && app.mouseY < 646 ) {
			app.fill(104,203,25);
			app.noStroke();
		    app.rect(app.width/2-180, app.height/2+170, 270*1.2f, 120*1.2f, 30, 30, 30, 30);
		    app.noFill();
			app.image(play, app.width/2 -155, app.height/2 +195,play.width*1.1f,play.height*1.1f);
		}
		
		break;
		
		case 2:
			app.image(fondo, 0, 0);
			app.image(barraGorra, 638, 11);
			app.image(barraMedia, 335,11);
			app.image(barraVeneno, 46,11);
			app.image(barraCafe,903,11);
			per.pintar();
			ene.pintar();
			if(ene.getState().name().equals("NEW")) {
				ene.start();
			}
		break;
		}
	}
	
	public void clickear() {
		switch(pantalla) {
		case 0:
		if (app.mouseX >346 && app.mouseX < 612 && app.mouseY >525 && app.mouseY < 658) {
			pantalla++;
		}
		break;
		
		case 1:
		if(app.mouseX >430 && app.mouseX < 695 && app.mouseY >529 && app.mouseY < 646 ) {
			pantalla++;
		}
		break;
		
		case 2:
		
		break;
		}
	}
	
	
	
	
	public void teclear() {
		switch(pantalla) {
		case 2:
		per.mover();
		break;
		}
	}
	
	public void soltado() {
		switch(pantalla) {
		case 2:
			per.soltar();
			break;
		}
	}
	
	public Personaje getPer() {
		return per;
		}
	public Enemigo getEne() {
		return ene;
	}
}
