package datos;

public class Empleado extends Usuario {
	
	private String rol;
	
	public Empleado() {}
	
	public Empleado(String nombre, String email, String rol) {
		super(nombre, email);
		this.rol = rol; 
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Receptor [rol=" + rol + "]";
	}
	
	

}
