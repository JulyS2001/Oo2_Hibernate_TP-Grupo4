package test;

import negocio.EstadoAbm;

public class TestEstado {

	public static void main(String[] args) {

		EstadoAbm eABM = new EstadoAbm();
		
		int idEstadoAbierto = eABM.crearEstado("abierto");
		System.out.println("se creo estado 'abierto', id: " + idEstadoAbierto);

		int idEstadoEnProceso = eABM.crearEstado("en proceso");
		System.out.println("se creo estado 'en proceso', id: " + idEstadoEnProceso);
		
		int idEstadoCerrado = eABM.crearEstado("cerrado");
		System.out.println("se creo estado 'cerrado', id: " + idEstadoCerrado);
	}

}
