package datos;

import java.util.Set;

public abstract class User {

	protected int idUser;

	protected String nombre;

	protected String email;


	public User() {
	}
	

	public User(int idUser, String nombre, String email) {
		super();
		this.idUser = idUser;
		this.nombre = nombre;
		this.email = email;
	}


	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
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
		return "User [idUser=" + idUser + ", nombre=" + nombre + ", email=" + email + "]";
	}
	
	
}