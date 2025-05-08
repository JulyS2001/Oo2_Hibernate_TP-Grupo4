package negocio;

import dao.UserDao;
import datos.User;


public class UserAbm {
	
	private static UserAbm instancia = null; 
	private UserDao dao; 
	protected UserAbm() {
		dao = UserDao.getInstance();
	}
	
	public static UserAbm getInstance() {
		if(instancia == null)
			instancia = new UserAbm();
		return instancia; 
	}
	
	public int crearUser(User u) {
		return dao.crearUser(u);
	}
	
	public void eliminarUser(User u) {
		User existe = dao.traer(u.getIdUser());
		if(existe == null) {
			throw new RuntimeException("El usuaro no existe.");
		}
		dao.eliminarUser(u);
	}
	
	public void modificarUser(User u) {
		User existe = dao.traer(u.getIdUser());
		if(existe == null) {
			throw new RuntimeException("El usuaro no existe.");
		}
		dao.modificarUser(u);
	}
	
	public User traerUser(int idUser) {
		return dao.traer(idUser);
	}
	
    
}
	
