package marmolejo_correa_taller2;

import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Enemigo extends Thread {

	private PApplet app;
	private PVector pos;
	private int tam;
	private PVector vel;
	private int contadorS;
	private PImage Sully;
	private boolean vivo;
	private Logica log;

	public Enemigo(PApplet app, Logica log) {
		this.app = app;
		this.log = log;
		pos = new PVector(app.random(0, app.width / 2), app.random(0, app.height / 2));
		vel = new PVector(0, 0);
		Sully = app.loadImage("Sully.png");
		vivo = true;
	}

	public void run() {
		while (vivo) {
			// if( detectar() == true ){

			// vivo = false;
			// }else {
			try {
				sleep(60);
				mover();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void pintar() {
		app.image(Sully, pos.x, pos.y);
		app.stroke(27, 153, 160);
		app.noFill();
		app.ellipse(pos.x + 95, pos.y - 1, 20, 20);
		app.fill(27, 153, 160);
		app.textSize(20);
		app.text(contadorS, pos.x + 95, pos.y - 2);
	}

	public void mover() {

		for (int i = 0; i < log.getObs().size(); i++) {

			if (log.getObs().get(i) instanceof Tanque) {
				if (PApplet.dist(pos.x, pos.y, log.getObs().get(i).getPos().x, log.getObs().get(i).getPos().y) < PApplet
						.dist(pos.x, pos.y, log.getPer().getPos().x, log.getPer().getPos().x)) {
					vel = PVector.sub(log.getObs().get(i).getPos(), pos);
					vel.normalize();
					vel.mult(app.random(2, 3)); 
					pos.add(vel);

				} else {
					vel = PVector.sub(log.getPer().getPos(), pos);
					vel.normalize();
					vel.mult(app.random(2, 3));
					pos.add(vel);

				}
			} else {
				vel = PVector.sub(log.getPer().getPos(), pos);
				vel.normalize();
				vel.mult(app.random(2, 3));
				pos.add(vel);
			}

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
					contadorS++;
					System.out.println("JOJOJO");
				}
				objetos.remove(o);
			}
		}
	}

	public PVector getPos() {
		return pos;
	}
}
