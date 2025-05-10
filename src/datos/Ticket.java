package datos;

import java.time.LocalDateTime;

public class Ticket {

	private int idTicket;

	private String titulo;

	private String descripcion;

	private LocalDateTime fechaCreacion;

	private LocalDateTime fechaCierre;

	private Categoria categoria;

	private Estado estado;

	private Prioridad prioridad;

	public Ticket() {
	}

	public Ticket(String titulo, String descripcion, LocalDateTime fechaCreacion, LocalDateTime fechaCierre) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.fechaCierre = fechaCierre;
	}

	// Getters y Setters

	public int getIdTicket() {
		return idTicket;
	}

	protected void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(LocalDateTime fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Prioridad getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}

	@Override
	public String toString() {
		return "Ticket [idTicket=" + idTicket + ", titulo=" + titulo + ", descripcion=" + descripcion
				+ ", fechaCreacion=" + fechaCreacion + ", fechaCierre=" + fechaCierre + ", categoria=" + categoria
				+ ", estado=" + estado + ", prioridad=" + prioridad + "]";
	}

	
}