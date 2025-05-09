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
	
	public int crearUser(Usuario u) {
		return dao.crearUser(u);
	}
	
	public void eliminarUser(Usuario u) {
		Usuario existe = dao.traer(u.getIdUser());
		if(existe == null) {
			throw new RuntimeException("El usuaro no existe.");
		}
		dao.eliminarUser(u);
	}
	
	public void modificarUser(Usuario u) {
		Usuario existe = dao.traer(u.getIdUser());
		if(existe == null) {
			throw new RuntimeException("El usuaro no existe.");
		}
		dao.modificarUser(u);
	}
	
	public Usuario traerUser(int idUser) {
		return dao.traer(idUser);
	}
	
    
}
	
