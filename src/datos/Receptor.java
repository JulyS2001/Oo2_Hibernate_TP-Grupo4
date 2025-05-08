package datos;

public class Receptor extends User {
	
	private String rol;
	
	public Receptor() {}
	
	public Receptor(int idUser, String nombre, String email, String rol) {
		super(idUser, nombre, email);
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
