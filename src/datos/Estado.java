package datos;

public class Estado {

	private int idEstado;
	private String nombre;
	private Ticket ticket;

	public Estado() {
	}

	public Estado(String nombre) {
		super();
		this.nombre = nombre;
	}

	public int getIdEstado() {
		return idEstado;
	}

	protected void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
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
		return "Estado [idEstado=" + idEstado + ", nombre=" + nombre + ", ticket=" + ticket + "]";
	}

	

}
