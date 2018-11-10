package marmolejo_correa_taller2;

import java.util.ArrayList;
import java.util.LinkedList;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
import processing.core.PFont;

public class Logica {
	int pantalla = 0;
	int s;

	private PApplet app;
	private PVector pos;
	int conTankMundo, conCafeMundo, conGorraMundo, conVenenoMundo, conMediaMundo;
	private PFont font1;
	private PFont font2;
	private PImage play, play2, media, barraCafe, barraGorra, barraMedia, barraVeneno, cafe, fondo, ganaste, gorra,
			inicio, instrucciones, mike, perdiste, recurso, reloj, score, sully, veneno,pgritos;
	private Personaje per;
	private ArrayList<Enemigo> enemigos;
	private LinkedList<Tanque> tank;
	private LinkedList<Objeto> objetos;

	public Logica(PApplet app) {
		this.app = app;

		font1 = app.createFont("big_noodle_titling.ttf", 48);
		font2 = app.createFont("athletic_regular.ttf", 48);
		
		pgritos= app.loadImage("pgritos.png");
		barraCafe = app.loadImage("BarraCafe.png");
		barraGorra = app.loadImage("BarraGorra.png");
		barraMedia = app.loadImage("BarraMedia.png");
		barraVeneno = app.loadImage("BarraVeneno.png");
		cafe = app.loadImage("Cafe.png");
		fondo = app.loadImage("fondo.png");
		ganaste = app.loadImage("Ganaste.png");
		gorra = app.loadImage("Gorra.png");
		inicio = app.loadImage("inicio.png");
		instrucciones = app.loadImage("instrucciones.png");
		media = app.loadImage("Media.png");
		mike = app.loadImage("Mike.png");
		perdiste = app.loadImage("Perdiste.png");
		recurso = app.loadImage("Recurso.png");
		reloj = app.loadImage("Reloj.png");
		score = app.loadImage("score.png");
		sully = app.loadImage("Sully.png");
		veneno = app.loadImage("Veneno.png");
		play = app.loadImage("play.png");
		play2 = app.loadImage("play2.png");

		per = new Personaje(app, this);

		enemigos = new ArrayList<Enemigo>();
		objetos = new LinkedList<Objeto>();
		tank = new LinkedList<Tanque>();

		conTankMundo = 0;
		conCafeMundo = 0;
		conGorraMundo = 0;
		conVenenoMundo = 0;
		conMediaMundo = 0;
		
		agregarEnemigos();
		
			
		
		
		
		
	}
	
	public void agregarEnemigos() {
		for (int i = 0; i < 3; i++) {
			enemigos.add(new Enemigo(app,this));
		}

	}
	
	public void levantarHiloEnemigo() {
		for (int i = 0; i < enemigos.size(); i++) {
			enemigos.get(i).start();
		}
	}
	
	

	public void dibujar() {
		switch (pantalla) {
		case 0:
			app.image(inicio, 0, 0);
			if (app.mouseX > 346 && app.mouseX < 612 && app.mouseY > 525 && app.mouseY < 658) {
				app.image(play2, 290, 522, play2.width * 1.1f, play2.height * 1.1f);
			}
			break;

		case 1:
			app.image(instrucciones, 0, 0);
			app.fill(104, 203, 25);
			app.noStroke();
			app.rect(app.width / 2 - 170, app.height / 2 + 180, 270, 120, 30, 30, 30, 30);
			app.noFill();
			app.image(play, app.width / 2 - 155, app.height / 2 + 195);

			if (app.mouseX > 430 && app.mouseX < 695 && app.mouseY > 529 && app.mouseY < 646) {
				app.fill(104, 203, 25);
				app.noStroke();
				app.rect(app.width / 2 - 180, app.height / 2 + 170, 270 * 1.2f, 120 * 1.2f, 30, 30, 30, 30);
				app.noFill();
				app.image(play, app.width / 2 - 155, app.height / 2 + 195, play.width * 1.1f, play.height * 1.1f);
			}

			break;

		case 2:
			s = app.frameCount / 60;
			app.image(fondo, 0, 0);
			app.fill(255);
			app.textFont(font1);
			app.textAlign(app.CENTER, app.CENTER);
			app.text(30 - s, app.width / 2, 650);
			app.noFill();
			app.image(barraGorra, 638, 11);
			app.image(barraMedia, 335, 11);
			app.image(barraVeneno, 46, 11);
			app.image(barraCafe, 903, 11);
			per.pintar();
			
		for (int i = 0; i < enemigos.size(); i++) {
			enemigos.get(i).pintar();
			
			if(enemigos.get(i).getState().name().equals("NEW")) {
				 per.start();
				 levantarHiloEnemigo();
			}
			}

			if (app.frameCount % 60 == 0 && conTankMundo != 3) { 
																
				objetos.add(new Tanque(app));
				conTankMundo++;
			}

			/*
			 * if(tank.borrar()==true) { objetos.remove(new Tanque(app)); conTankMundo--; }
			 */

			if (app.frameCount % 65 == 0 && conVenenoMundo != 3) {
				objetos.add(new Erizo(app));
				conVenenoMundo++;
			}

			if (app.frameCount % 300 == 0 && conCafeMundo != 1) {
				objetos.add(new Taza(app));
				conCafeMundo++;
			}

			if (app.frameCount % 600 == 0 && conGorraMundo != 1) {
				objetos.add(new Gorra(app));
				conGorraMundo++;
			}

			if (app.frameCount % 300 == 0 && conMediaMundo != 1) {
				objetos.add(new Calcetin(app));
				conMediaMundo++;
			}

			for (int i = 0; i < objetos.size(); i++) {
				Objeto o = objetos.get(i);
				o.pintar();
			}

		

//			for(int i =0; i<objetos.size();i++) {
//				if(tank.borrar()==true) {
//					objetos.remove();
//					
//				}
//			}
			synchronized (per) {
				per.validarRecoger(objetos);
				for (int i = 0; i < enemigos.size(); i++) {
					enemigos.get(i).validarRecoger(objetos);
					
				}
				if (s ==30) {
					pantalla ++;
					
				}
			}
			break;
		case 3:
			app.image(score, 0, 0);
			if (per.getcontadorM()>=10 ) {
				app.image(ganaste, 532, 249);
				app.image(pgritos, 523, 361);	
				app.textFont(font1);
				app.textSize(25);
				app.fill(226,173,96);
				
				app.text(per.getcontadorM() +"x1000 = " + per.getcontadorM()+"000 ", 604, 397);
				}else {
					app.image(perdiste, 532, 238);	
					app.image(pgritos, 523, 361);	
					app.textFont(font1);
					app.textSize(25);
					app.fill(226,173,96);
					
					app.text(per.getcontadorM() +"x1000 = " + per.getcontadorM()+"000 ", 604, 397);
					
				}
			}
	}

	public void clickear() {
		switch (pantalla) {
		case 0:
			if (app.mouseX > 346 && app.mouseX < 612 && app.mouseY > 525 && app.mouseY < 658) {
				pantalla++;
			}
			break;

		case 1:
			if (app.mouseX > 430 && app.mouseX < 695 && app.mouseY > 529 && app.mouseY < 646) {
				pantalla++;
				app.frameCount = 0;
			}
			break;

		case 2:
			System.out.println(app.mouseX);
			System.out.println(app.mouseY);

			break;
		}
	}

	public void teclear() {
		switch (pantalla) {
		case 2:
			per.mover();
			break;
		}
	}

	public void soltado() {
		switch (pantalla) {
		case 2:
			per.soltar();
			break;
		}
	}

	public Personaje getPer() {
		return per;
	}
	
	public LinkedList<Objeto> getObs(){
		return objetos;
		
	}

	public ArrayList<Enemigo> getEne() {
		return enemigos;
	}
}
