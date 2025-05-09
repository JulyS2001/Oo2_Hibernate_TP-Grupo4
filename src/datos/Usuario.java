package datos;

public abstract class Usuario {

	private int idUser;

	private String nombre;

	private String email;

	public Usuario() {
	}

	public Usuario(String nombre, String email) {
		super();
		this.nombre = nombre;
		this.email = email; 
	}

	public int getIdUser() {
		return idUser;
	}

	protected void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nombre=" + nombre + ", email=" + email +  "]";
	}

}