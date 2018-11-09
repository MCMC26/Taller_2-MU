package marmolejo_correa_taller2;


import processing.core.PApplet;
import processing.core.PImage;

public class Logica {
	int pantalla = 0;
	private PApplet app;
	
	private PImage play,play2,Media,barraGorra, barraMedia, barraVeneno, cafe,fondo,ganaste,gorra,inicio,instrucciones,mike,perdiste,recurso,reloj,score,sully,veneno;
	private Personaje per;
	private Enemigo ene;
	public Logica (PApplet app) {
		this.app = app;
		barraGorra = app.loadImage("BarraGorra.png");
		barraMedia = app.loadImage("BarraMedia.png");
		barraVeneno = app.loadImage("BarraVeneno.png");
		cafe = app.loadImage("Cafe.png");
		fondo = app.loadImage("fondo.png");
		ganaste = app.loadImage("Ganaste.png");
		gorra = app.loadImage("Gorra.png");
		inicio = app.loadImage("inicio.png");
		instrucciones = app.loadImage("instrucciones.png");
		Media = app.loadImage("Media.png");
		mike = app.loadImage("Mike.png");
		perdiste = app.loadImage("Perdiste.png");
		recurso = app.loadImage("Recurso.png");
		reloj = app.loadImage("Reloj.png");
		score = app.loadImage("score.png");
		sully = app.loadImage("Sully.png");
		veneno = app.loadImage("Veneno.png");
		play = app.loadImage("play.png");
		play2 = app.loadImage("play2.png");
		
		per = new Personaje(app);
		ene= new Enemigo (app ,this);
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
			app.image(barraGorra, app.width/2, 0);
			app.image(barraMedia, app.width/3, 0);
			app.image(barraVeneno, app.width/4,0);
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
	
	public Personaje getPer() {
		return per;
		}
	public Enemigo getEne() {
		return ene;
	}
	
}
