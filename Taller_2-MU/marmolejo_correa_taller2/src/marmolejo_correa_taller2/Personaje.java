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
	private int contadorPower;
	private PVector vel;
	private int contadorM;
	private int contador;
	private PImage Mike;
	private boolean vivo;
	private boolean soltar = true;
	private boolean escudo = false;
	private boolean detenido,acelerado,ralentizado = false;
	private boolean arriba, abajo, izquierda, derecha, diagonal1 = false;
	private Logica log;

	public Personaje(PApplet app, Logica log) {
		this.app = app;
		this.log = log;
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
				
				
			/*	if(detenido ==true &&app.frameCount%180==0) {
					detenido = false;
					vel = new PVector(3,3);
				}*/
				if(detenido ==true && app.frameCount > contador + 180) {
					detenido = false;
					vel = new PVector(3,3);
				}
				if(acelerado ==true && app.frameCount > contador + 180) {
					acelerado = false;
					vel = new PVector(3,3);
				}
				if(ralentizado ==true && app.frameCount > contador + 180) {
					ralentizado = false;
					vel = new PVector(3,3);
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
		
		if(detenido == true && app.frameCount < contador+180) {
			app.fill(240, 203, 53);
			app.noStroke();
			app.rect(336, 16,  190+(app.frameCount -contador)*(-1), 35,15);
			app.fill(255);
			app.textSize(32);
			app.text("PARALIZADO", 420, 30);
		}
		if(acelerado == true && app.frameCount < contador+180) {
			app.fill(72, 206, 67);
			app.noStroke();
			app.rect(905, 16, 180+(app.frameCount -contador)*(-1), 35,15);
			app.fill(255);
			app.textSize(32);
			app.text("ACELERADO", 990, 30);
		}
		if(ralentizado == true && app.frameCount < contador+180) {
			app.fill(219, 75, 217);
			app.noStroke();
			app.rect(47, 16,  180+(app.frameCount -contador)*(-1), 35,15);
			app.fill(255);
			app.textSize(32);
			app.text("RALENTIZADO", 135, 30);
		}
		if(escudo == true) {
			app.fill(50, 50, 255);
			app.noStroke();
			app.rect(635, 16, 180, 35,15);
			app.fill(255);
			app.textSize(32);
			app.text("PROTEGIDO", 700, 30);
		}
		
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

	public void validarRecoger(LinkedList<Objeto> objs) {
		LinkedList<Objeto> objetos = objs;
		for (int i = objetos.size() - 1; i >= 0; i--) {
			Objeto o = objetos.get(i);
			if (PApplet.dist(pos.x, pos.y, o.getPos().x, o.getPos().y) < 83) {
				if (o instanceof Tanque) {
					// Lo que pasa cuando agarre el tanque, y asi mismo con los demas
					contadorM++;
					log.conTankMundo--;
					System.out.println("JIJIJI");
				}
				if (o instanceof Calcetin) {

						
						vel= new PVector(0,0);
						detenido = true;
						contador = app.frameCount;
						System.out.println("Quieto mi so");
						log.conMediaMundo--;
				}
				if (o instanceof Taza) {
					vel = new PVector(5,5);
					acelerado = true;
					contador = app.frameCount;
					log.conCafeMundo--;

				}
				if (o instanceof Erizo) {
					vel = new PVector(1,1);
					ralentizado = true;
					contador = app.frameCount;
					log.conVenenoMundo--;
				}
				
				if (o instanceof Gorra) {
					escudo = true;
					log.conGorraMundo--;
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

public void setContadorM(int c) {
	contadorM = c;
}
public boolean getEscudo() {
	return escudo;
}
public void setEscudo(boolean e) {
	escudo = e;
}


}
