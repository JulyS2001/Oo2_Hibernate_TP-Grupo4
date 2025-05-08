package datos;

public class Prioridad {
	private int idPrioridad;
	private String nombre;
	private Ticket ticket;

	public Prioridad() {
		// TODO Auto-generated constructor stub
	}

	public Prioridad(String nombre, Ticket ticket) {
		super();
		this.nombre = nombre;
		this.ticket = ticket;
	}

	public int getIdPrioridad() {
		return idPrioridad;
	}

	public void setIdPrioridad(int idPrioridad) {
		this.idPrioridad = idPrioridad;
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
		return "Prioridad [idPrioridad=" + idPrioridad + ", nombre=" + nombre + ", ticket=" + ticket + "]";
	}
	
	}

