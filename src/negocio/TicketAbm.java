package negocio;

import java.util.List;
import java.time.LocalDateTime;

import dao.TicketDao;
import datos.Ticket;
import datos.Categoria;
import datos.Estado;
import datos.Prioridad;
import datos.Cliente;
import datos.Usuario;

public class TicketAbm {
	
	private TicketDao ticketDao = new TicketDao();
	
	
	public Ticket crearTicket(String titulo, String descripcion, Cliente cliente,
            Categoria categoria, Estado estado, Prioridad prioridad) {
Ticket t = new Ticket();
t.setTitulo(titulo);
t.setDescripcion(descripcion);
t.setFechaCreacion(LocalDateTime.now());
t.setCliente(cliente);
t.setCategoria(categoria);
t.setPrioridad(prioridad);
t.setEstado(estado);

int id = ticketDao.crearTicket(t);
t.setIdTicket(id); // Asignar ID generado
return t;
}
	
	/*public int agregarTicket(String titulo, String descripcion, int idCategoria, int idEstado, int idPrioridad, int idCliente) throws Exception {
		if (titulo == null || titulo.trim().isEmpty()) {
			throw new Exception("El título del ticket no puede estar vacío.");
		}
		
	    Categoria categoria = new CategoriaAbm().traerCategoria(idCategoria);
	    Estado estado = new EstadoAbm().traerEstado(idEstado);
	    Prioridad prioridad = new PrioridadAbm().traerPrioridad(idPrioridad);
	    Usuario usuario = new UsuarioAbm().traerUsuario(idCliente);
	    
		Ticket ticket = new Ticket();
		ticket.setTitulo(titulo);
		ticket.setDescripcion(descripcion);
		ticket.setFechaCreacion(LocalDateTime.now());
		ticket.setFechaCierre(null);
		ticket.setCategoria(categoria);
	    ticket.setEstado(estado);
	    ticket.setPrioridad(prioridad);
	    ticket.setCliente(usuario);
	    
		return ticketDao.crearTicket(ticket);
	}*/
	
	public Ticket traerTicket(int idTicket) {
		// podrías agregar validaciones, logs, etc.
		return ticketDao.traerTicket(idTicket);
	}
	
	public List<Ticket> traerTodos() {
		return ticketDao.traerTodos();
	}
	
	public void actualizarTicket(Ticket ticket) throws Exception {
		if (ticket == null || ticket.getIdTicket() <= 0) {
			throw new Exception("Ticket inválido.");
		}
		ticketDao.actualizar(ticket);
	}
	
	public void eliminarTicket(int idTicket) throws Exception {
		Ticket ticket = ticketDao.traerTicket(idTicket);
		if (ticket == null) {
			throw new Exception("El ticket no existe.");
		}
		ticketDao.eliminar(ticket);
	}
}