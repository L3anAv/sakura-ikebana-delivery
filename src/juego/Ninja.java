//Falta Mover hacia abajo y arriba al ninja y que dispare la estrella ninja


package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Ninja {
	private double x;
    private double y;
    private double alto;
    private double ancho;
    private double velocidad;
    private int direccion;

    
    
    public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}
	
	Ninja(double x, double y, double ancho, double alto, double velocidad,int dir){
    	this.x = x;
    	this.y = y;
    	this.alto = alto;
    	this.ancho = ancho;
    	this.velocidad = velocidad;
    	this.direccion = dir;
    	
    }
	
	public double getVelocidad() {
		return this.velocidad;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}
	
	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	//Mueve el ninja
		public void mover() {
			if (this.direccion == 1) {
				moverDerecha();
			} else if (this.direccion ==2) {
				moverIzquierda();
			}if (this.direccion ==3) {
				moverArriba();
			} else if (this.direccion == 4) {
				moverAbajo();
			}
			
		}
		//Mueve el ninja hacia la derecha en caso que corresponda
		private void moverDerecha() {
			if(this.x >= 800) {
				this.x = 0;
			}
			this.x = this.x + this.velocidad;
		}
		//Mueve el ninja hacia la izquierda enl caso que corresponda
		private void moverIzquierda() {
			if(this.x <= 0) {
				this.x = 800;
			}
			this.x = this.x - this.velocidad;
		}
		private void moverArriba() {
			if(this.y >= 800) {
				this.y = 0;
			}
			this.y = this.y + this.velocidad;
		}
		private void moverAbajo() {
			if(this.y <= 0) {
				this.y = 800;
			}
			this.y = this.y - this.velocidad;
		}
		boolean colisionRasengan(Rasengan rasengan, Ninja ninja ) {
			double posicionSupNinja;
			double posicionInfNinja;
			double posicionIzqNinja;
			double posicionDerNinja;
			
			double posicionSuprasengan;
			double posicionInfrasengan;
			double posicionIzqrasengan;
			double posicionDerrasengan;
					
			
			posicionSupNinja = ninja.getY() - ninja.getAlto()/2;
			posicionInfNinja = ninja.getY() + ninja.getAlto()/2;
			posicionIzqNinja = ninja.getX() - ninja.getAncho()/2;
			posicionDerNinja = ninja.getX() + ninja.getAncho()/2;
				
			posicionSuprasengan = rasengan.getY() - rasengan.getRadio();
			posicionInfrasengan = rasengan.getY() + rasengan.getRadio();
			posicionIzqrasengan = rasengan.getX() - rasengan.getRadio();
			posicionDerrasengan = rasengan.getX() + rasengan.getRadio();
												
			return !(posicionSupNinja > posicionInfrasengan || posicionInfNinja < posicionSuprasengan || posicionIzqNinja > posicionDerrasengan || posicionDerNinja < posicionIzqrasengan);		
	}
	    //Dibuja el ninja en este caso color negro
	 	public void Dibujarse(Entorno entorno) {
	    	entorno.dibujarRectangulo(this.x, this.y, ancho, alto,0.0, Color.BLUE);
		}
}
