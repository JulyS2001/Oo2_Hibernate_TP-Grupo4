package test;

import datos.Ticket;
import datos.Estado;
import datos.Prioridad;
import datos.Categoria;
import datos.Cliente;
import negocio.EstadoAbm;
import negocio.PrioridadAbm;
import negocio.CategoriaAbm;
import negocio.UsuarioAbm;
import negocio.TicketAbm;

import java.util.List;

public class TestTicket {
	public static void main(String[] args) {
	    try {
	        // Instanciar ABMs
	        EstadoAbm estadoAbm       = new EstadoAbm();
	        PrioridadAbm prioridadAbm = new PrioridadAbm();
	        CategoriaAbm categoriaAbm = new CategoriaAbm();
	        UsuarioAbm usuarioAbm     = UsuarioAbm.getInstance();
	        TicketAbm ticketAbm       = new TicketAbm();

	        // Traer instancias existentes de otros tests

	        Estado estado       = estadoAbm.traerEstado(1);
	        Prioridad prioridad = prioridadAbm.traerPrioridad(2);
	        Categoria categoria = categoriaAbm.traerCategoria(6);
	        Cliente cliente     = (Cliente) usuarioAbm.traerUsuario(1);

	        // Crear el ticket enlazando entidades existentes
	        Ticket nuevoTicket = ticketAbm.crearTicket(
	            "Error en login",
	            "No puedo iniciar sesión con mis credenciales.",
	            cliente,
	            categoria,
	            estado,
	            prioridad
	        );
	        int idTicket = nuevoTicket.getIdTicket();
	        System.out.println("Ticket creado con ID: " + idTicket);

	        // Trae y muestra el ticket
	        Ticket tRecuperado = ticketAbm.traerTicket(idTicket);
	        System.out.println("Recuperado: " + tRecuperado);

	        // Actualizar estado a ID 2 ('en proceso')
	        Estado nuevoEstado = estadoAbm.traerEstado(2);
	        tRecuperado.setEstado(nuevoEstado);
	        ticketAbm.actualizarTicket(tRecuperado);
	        System.out.println("Actualizado: " + ticketAbm.traerTicket(idTicket));

	        // Listar todos los tickets
	        List<Ticket> todos = ticketAbm.traerTodos();
	        System.out.println("Todos los tickets:");
	        for (Ticket t : todos) {
	            System.out.println(t);
	        }
	        /*

	        // Eliminar el ticket
	        ticketAbm.eliminarTicket(idTicket);
	        System.out.println("Eliminado ticket ID " + idTicket);
	        */

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}