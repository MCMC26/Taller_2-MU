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
	private int contadorAtacar;
	private PImage Sully;
	private boolean vivo;
	private Logica log;

	public Enemigo(PApplet app, Logica log) {
		this.app = app;
		this.log = log;
		contadorAtacar = 0;
		pos = new PVector(app.random(0, app.width / 2), app.random(0, app.height / 2));
		vel = new PVector(2, 2);
		Sully = app.loadImage("Sully.png");
		vivo = true;
	}

	public void run() {
		while (vivo) {
			// if( detectar() == true ){

			// vivo = false;
			// }else {
			validarChoque();
			contadorAtacar++;
			try {
				sleep(20);
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
//Si Mike tiene más puntos que el enemigo entonces...
			if(log.getPer().getcontadorM() > contadorS) {
				//Si mike esta a menos de 300 pixeles, los enemigos huyen 
				if ((PApplet.dist(pos.x, pos.y, log.getPer().getPos().x, log.getPer().getPos().y) < 200)) {
					vel = PVector.sub(log.getPer().getPos(), pos);
					vel.rotate(180);
					vel.mult(0.5f);
					vel.normalize();
					pos.add(vel);
				//Si no se cumple lo anterior entonces los enemigos irán por los tanques que vean
			}else if (log.getPer().getcontadorM() > contadorS && log.getObs().get(i) instanceof Tanque) {
					vel = PVector.sub(log.getObs().get(i).getPos(), pos);
				//	vel.mult(2);
					vel.normalize();
					pos.add(vel);

				} 
			
			}
			
			//Si mike no tiene mas puntos que el enemigo entonces...
			
			else if (log.getObs().get(i) instanceof Tanque) {
				//Si la distancia entre el objeto es menor que la distancia a mike entonces...
				if (PApplet.dist(pos.x, pos.y, log.getObs().get(i).getPos().x, log.getObs().get(i).getPos().y) < PApplet
						.dist(pos.x, pos.y, log.getPer().getPos().x, log.getPer().getPos().x)) {
					//Vaya hacia el objeto que da puntos (Tanque)
					vel = PVector.sub(log.getObs().get(i).getPos(), pos);
					vel.normalize();
				//	vel.mult(2);
					pos.add(vel);
					//Sino...
				} else {
					//Vaya a por Mike
					vel = PVector.sub(log.getPer().getPos(), pos);
					vel.normalize();
					//vel.mult(2);
					pos.add(vel);

				}
			} 
			}

		}

	

	public void validarChoque() {
		Personaje p = log.getPer();
		if(app.dist(p.getPos().x, p.getPos().y, pos.x, pos.y) < 87 && contadorAtacar > 60 && p.getEscudo()==false) {
			if(p.getcontadorM() < contadorS && p.getcontadorM()>=1) {
				p.setContadorM(p.getcontadorM()-1);
				contadorAtacar = 0;
				contadorS++;
				System.out.println("funciona");
			} else if(p.getcontadorM() > contadorS && contadorS>=1) {
				p.setContadorM(p.getcontadorM()+1);
				contadorAtacar = 0;
				contadorS--;
				System.out.println("funciona");
			}
			
		}
		
			if(app.dist(p.getPos().x, p.getPos().y, pos.x, pos.y) < 87 && contadorAtacar > 60 && p.getEscudo()==true) {
				if(p.getcontadorM() < contadorS && p.getcontadorM()>=1) {
					p.setEscudo(false);
					contadorAtacar = 0;
					
				} else if(p.getcontadorM() > contadorS && contadorS>=1) {
					p.setContadorM(p.getcontadorM()+1);
					contadorAtacar = 0;
					contadorS--;
					System.out.println("funciona");
				}
				
			}
			
			
		
	}

	public void validarRecoger(LinkedList<Objeto> objs) {
		LinkedList<Objeto> objetos = objs;
		for (int i = objetos.size() - 1; i >= 0; i--) {
			Objeto o = objetos.get(i);
			if (PApplet.dist(pos.x, pos.y, o.getPos().x, o.getPos().y) < 83) {
				if (o instanceof Tanque) {
					// Lo que pasa cuando agarre el tanque, y asi mismo con los demas
					contadorS++;
					log.conTankMundo--;
					System.out.println("JOJOJO");
				}
				
				if (o instanceof Calcetin) {

					
					vel= new PVector(0,0);
				//	detenido = true;
				//contador = app.frameCount;
					
					log.conMediaMundo--;
			}
				if (o instanceof Taza) {
					vel.mult(2);
					log.conCafeMundo--;

				}
				if (o instanceof Erizo) {
					vel.mult(0.5f);
					log.conVenenoMundo--;
				}
				
				
				objetos.remove(o);
			}
		}
	}

	public PVector getPos() {
		return pos;
	}
}
