package negocio;

import java.util.List;
import dao.UserDao;
import datos.User;
import datos.Receptor;
import datos.Emisor;

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
		dao.eliminarUser(u);
	}
	
	public void modificarUser(User u) {
		dao.modificarUser(u);
	}
	
	public User traerUser(int idUser) {
		return dao.traer(idUser);
	}
	
    
}
	
