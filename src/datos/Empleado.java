package datos;

public class Empleado extends Usuario {
	
	private String rol;
	private int legajo; 
	
	public Empleado() {}
	
	public Empleado(String nombre, String apellido, int dni, String rol) {
		super(nombre, apellido, dni);
		this.rol = rol; 
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	@Override
	public String toString() {
		return "Empleado [rol=" + rol + ", legajo=" + legajo + "]";
	}

	
	

}
