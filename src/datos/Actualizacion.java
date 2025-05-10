package datos;

import java.time.LocalDateTime;

public class Actualizacion {
	private int idActualizacion;
	private String contenido;
	private LocalDateTime fechaActualizacion;
	private Empleado empleado;
	private Ticket ticket;
	
	
	public Actualizacion() {
		
	}
	
	public  Actualizacion (String contenido, LocalDateTime fechaActualizacion) {
		super();
		this.contenido = contenido;
		this.fechaActualizacion = fechaActualizacion;
	}
	
	
	//Getters y Setters
	public int getIdActualizacion() {
		return idActualizacion;
	}
	public void setIdActualizacion(int idActualizacion) {
		this.idActualizacion = idActualizacion;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "Actualizacion [idActualizacion=" + idActualizacion + ", contenido=" + contenido
				+ ", fechaActualizacion=" + fechaActualizacion + ", empleado=" + empleado + ", ticket=" + ticket + "]";
	}
	

}
