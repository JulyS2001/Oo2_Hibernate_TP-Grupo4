package datos;

public class Estado {

	private int idEstado;
	private String tipo;
	private Ticket ticket;

	public Estado() {
	}

	public Estado(String tipo, Ticket ticket) {
		super();
		this.tipo = tipo;
		this.ticket = ticket;
	}

	public int getIdEstado() {
		return idEstado;
	}

	protected void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "Estado [idEstado=" + idEstado + ", tipo=" + tipo + ", ticket=" + ticket + "]";
	}
	
}
