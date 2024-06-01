package controlador;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JButton;

import controlador.logic_Menu.VENTANA_TIPO;

public interface Dimensiones {
	
	public final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	
	public final int ANCHO = SCREEN_SIZE.width / 2;
	public final int ALTO = SCREEN_SIZE.height / 2;
	
	public final int POS_X = SCREEN_SIZE.width / 2 - ANCHO / 2;
	public final int POS_Y = SCREEN_SIZE.height / 2 - ALTO / 2;

	public default Rectangle dimensiones_gestion(VENTANA_TIPO tipo) {
		return switch (tipo) {
		case CLIENTE -> new Rectangle(POS_X / 2, POS_Y + (ALTO / 8), ANCHO, ALTO * 3 / 4);
		case PROVEEDOR -> new Rectangle(POS_X, POS_Y + (ALTO / 8), ANCHO, ALTO * 3 / 4);
		case PRODUCTO -> new Rectangle(POS_X, POS_Y + (ALTO / 8), ANCHO, ALTO * 3 / 4);
		case VENTA -> new Rectangle(POS_X * 3 / 2, POS_Y + (ALTO / 8), ANCHO, ALTO * 3 / 4);
		};
	}
	
	public default Rectangle dimensiones_formulario(VENTANA_TIPO tipo, JButton boton) {
		Rectangle boton_aux = boton.getBounds();
		return switch (tipo) {
		case CLIENTE -> new Rectangle(boton_aux.x + boton_aux.width, boton_aux.y, ANCHO * 3 / 4, ALTO * 3 / 4);
		case PROVEEDOR -> new Rectangle(boton_aux.x + boton_aux.width, boton_aux.y, ANCHO * 3 / 4, ALTO * 3 / 4);
		case PRODUCTO -> new Rectangle(boton_aux.x + boton_aux.width, boton_aux.y, ANCHO * 3 / 4, ALTO * 3 / 4);
		case VENTA -> new Rectangle(boton_aux.x + boton_aux.width, boton_aux.y, ANCHO * 5 / 4, ALTO * 3 / 4);
		};
	}
	
	public default Rectangle dimensiones_login() {
		return new Rectangle(ANCHO - ANCHO / 4, ALTO - ALTO / 4, ANCHO / 2, ALTO / 2);
	}
}
