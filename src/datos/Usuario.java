package datos;

public abstract class Usuario {

	private int idUsuario;
	private String nombre;
	private String apellido;
	private int dni; 
	

	public Usuario() {
	}

	public Usuario(String nombre, String apellido, int dni ) {
		super();
		this.nombre = nombre;
		this.apellido = apellido; 
		this.dni = dni;
	}


	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ "]";
	}

	
}