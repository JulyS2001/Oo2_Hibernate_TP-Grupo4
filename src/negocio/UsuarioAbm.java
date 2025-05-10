package negocio;

import dao.UsuarioDao;
import datos.Usuario;


public class UsuarioAbm {
	
	private static UsuarioAbm instancia = null; 
	private UsuarioDao dao; 
	protected UsuarioAbm() {
		dao = UsuarioDao.getInstance();
	}
	
	public static UsuarioAbm getInstance() {
		if(instancia == null)
			instancia = new UsuarioAbm();
		return instancia; 
	}
	
	public int crearUsuario(Usuario u) {
		return dao.crearUsuario(u);
	}
	
	public void eliminarUsuario(Usuario u) {
		Usuario existe = dao.traerUsuario(u.getIdUsuario());
		if(existe == null) {
			throw new RuntimeException("El usuario no existe.");
		}
		dao.eliminarUsuario(u);
	}
	
	public void modificarUsuario(Usuario u) {
		Usuario existe = dao.traerUsuario(u.getIdUsuario());
		if(existe == null) {
			throw new RuntimeException("El usuario no existe.");
		}
		dao.modificarUsuario(u);
	}
	
	public Usuario traerUsuario(int idUsuario) {
		return dao.traerUsuario(idUsuario);
	}
	
    
}
	
