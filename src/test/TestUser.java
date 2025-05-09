package test;

import datos.Cliente; 
import datos.Empleado; 
import negocio.UsuarioAbm;

public class TestUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UsuarioAbm user = UsuarioAbm.getInstance();
		
		Cliente e = new Cliente();
		e.setNombre("Roberto");
		e.setEmail("robertito@gmail.com");
		int idEmisor = user.crearUser(e);

	}

}
