package marmolejo_correa_taller2;

import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Personaje extends Thread {

	private PApplet app;
	private PVector pos;
	private PVector ace;
	private PVector neu;
	private PVector desace;
	private int tam;
	private PVector vel;
	private int contadorM;
	private PImage Mike;
	private boolean vivo;
	private boolean soltar = true;
	private boolean arriba, abajo, izquierda, derecha, diagonal1 = false;

	public Personaje(PApplet app) {
		this.app = app;
		Mike = app.loadImage("Mike.png");
		desace = new PVector(-2, -2);
		neu = new PVector(-3, -3);
		ace = new PVector(2, 2);
		pos = new PVector(app.width / 2, app.height / 2);
		vel = new PVector(3, 3);
		// vel.add(acceleration);

	}

	public void run() {
		while (true) {

			try {
				sleep(16);
				if (arriba == true) {
					pos.y = pos.y - vel.y;
				}
				if (abajo == true) {
					pos.y = pos.y + vel.y;
				}
				if (derecha == true) {
					pos.x = pos.x + vel.x;
				}
				if (izquierda == true) {
					pos.x = pos.x - vel.x;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void pintar() {

		app.image(Mike, pos.x, pos.y);

		// if(diagonal1==true) {pos.y=pos.y-vel.y; pos.x=pos.x-vel.x; }
		app.stroke(147, 182, 53);
		app.noFill();
		app.ellipse(pos.x + 95, pos.y - 1, 20, 20);
		app.fill(147, 182, 53);
		app.textSize(20);
		app.text(contadorM, pos.x + 95, pos.y - 2);
	}

	public void mover() {
		soltar = false;
		if (app.keyCode == app.UP) {
			// pos.y=pos.y-vel.y;
			arriba = true;
		}

		if (app.keyCode == app.DOWN) {
			abajo = true;
		}
		if (app.keyCode == app.RIGHT) {
			derecha = true;

		}
		if (app.keyCode == app.LEFT) {
			izquierda = true;

		}
		/*
		 * if(app.keyCode== app.LEFT && app.keyCode==app.UP){ diagonal1 = true; }
		 */

	}

	public void soltar() {
		soltar = true;
		if (app.keyCode == app.UP) {
			// pos.y=pos.y-vel.y;
			arriba = false;
		}

		if (app.keyCode == app.DOWN) {
			abajo = false;
		}
		if (app.keyCode == app.RIGHT) {
			derecha = false;

		}
		if (app.keyCode == app.LEFT) {
			izquierda = false;

		}

	}

	public void validarChoque() {

	}

	public void validarRecoger(LinkedList<Objeto> objs) {
		LinkedList<Objeto> objetos = objs;
		for (int i = objetos.size() - 1; i >= 0; i--) {
			Objeto o = objetos.get(i);
			if (PApplet.dist(pos.x, pos.y, o.getPos().x, o.getPos().y) < 83) {
				if (o instanceof Tanque) {
					// Lo que pasa cuando agarre el tanque, y asi mismo con los demas
					contadorM++;
					System.out.println("JIJIJI");
				}
				if (o instanceof Calcetin) {

						app.fill(255, 0, 0);
						app.rect(506, 50, -170, -30);
						vel.add(neu);

					

				}
				if (o instanceof Taza) {
					vel.add(ace);

				}
				if (o instanceof Erizo) {
					vel.add(desace);

				}
				objetos.remove(o);
			}
		}
	}

	public PVector getPos() {
		return pos;
	}


public int getcontadorM() {
	return contadorM;
}
}
