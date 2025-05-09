package datos;

public abstract class Usuario {

	private int idUsuario;

	private String nombre;

	private String email;

	public Usuario() {
	}

	public Usuario(String nombre, String email) {
		super();
		this.nombre = nombre;
		this.email = email; 
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	protected void setIdUser(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	@Override
	public String toString() {
		return "User [idUsuario=" + idUsuario + ", nombre=" + nombre + ", email=" + email +  "]";
	}

}