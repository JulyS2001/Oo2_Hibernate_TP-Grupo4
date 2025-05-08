package negocio;

import dao.HibernateUtil;
import datos.Prioridad;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PrioridadAbm {

    public void agregarPrioridad(Prioridad prioridad) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(prioridad);
        tx.commit();
        session.close();
    }

    public void modificarPrioridad(Prioridad prioridad) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(prioridad);
        tx.commit();
        session.close();
    }

    public void eliminarPrioridad(long idPrioridad) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Prioridad prioridad = session.get(Prioridad.class, idPrioridad);
        session.delete(prioridad);
        tx.commit();
        session.close();
    }

    public Prioridad traerPrioridad(long idPrioridad) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Prioridad prioridad = session.get(Prioridad.class, idPrioridad);
        session.close();
        return prioridad;
    }
}
