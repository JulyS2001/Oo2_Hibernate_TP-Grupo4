package datos;

public class Categoria {

	private int idCategoria;
	private String nombre;
	private Ticket ticket;

	public Categoria() {
	}

	public Categoria(String nombre, Ticket ticket) {
		super();
		this.nombre = nombre;
		this.ticket = ticket;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", nombre=" + nombre + ", ticket=" + ticket + "]";
	}

}