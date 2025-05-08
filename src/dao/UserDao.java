package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session; 
import org.hibernate.Transaction; 

import datos.User;

public class UserDao {
	
	private static Session session; 
	private Transaction tx; 
	private static UserDao instancia = null; 
	
	protected UserDao() {}
	
	public static UserDao getInstance() {
		if(instancia == null)
			instancia = new UserDao();
		return instancia;
	}
	
	protected void iniciaOperacion() throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	protected void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("Error en la capa de acceso a datos", he);
	}
	
	public int crearUser(User u) {
		int id = 0; 
		try {
			iniciaOperacion();
			id = (int)session.save(u);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		return id;
	}
	
	public void eliminarUser(User u) {
		try {
			iniciaOperacion();
			session.delete(u);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
	}
	
	public void modificarUser(User u) {
		try {
			iniciaOperacion();
			session.update(u);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he; 
		}finally {
			session.close();
		}
	}
	
	public User traer(int idUser) {
		User u = null; 
		try {
			iniciaOperacion();
			u = (User) session.get(User.class, idUser);
		}finally {
			session.close();
		}
		return u;
	}
	
	
	

}
