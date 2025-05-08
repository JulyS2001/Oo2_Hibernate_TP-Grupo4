package datos;

import java.util.Set;
import java.util.HashSet;

public class Prioridad {
	private long idPrioridad;
	private String nombre;


	public Prioridad() {}

	public Prioridad (String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void SetNombre (String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Prioridad [idPioridad=" + idPrioridad + ", nombre=" + nombre + "]";
	}


	}

