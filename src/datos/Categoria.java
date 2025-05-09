package datos;

public class Categoria {

	private int idCategoria;
	private String tipo;
	private Ticket ticket;

	public Categoria() {
	}

	public Categoria(String tipo, Ticket ticket) {
		super();
		this.tipo = tipo;
		this.ticket = ticket;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	protected void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
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
		return "Categoria [idCategoria=" + idCategoria + ", tipo=" + tipo + ", ticket=" + ticket + "]";
	}
	
}