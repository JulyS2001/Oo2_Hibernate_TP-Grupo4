package datos;

public abstract class User {

	private int idUser;

	private String nombre;

	private String email;

	private Sistema sistema;

	public User() {
	}

	public User(String nombre, String email) {
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

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nombre=" + nombre + ", email=" + email + ", sistema=" + sistema + "]";
	}

}