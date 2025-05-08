package negocio;

import dao.HibernateUtil;
import datos.Categoria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CategoriaAbm {

    public void agregarCategoria(Categoria categoria) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(categoria);
        tx.commit();
        session.close();
    }

    public void modificarCategoria(Categoria categoria) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(categoria);
        tx.commit();
        session.close();
    }

    public void eliminarCategoria(long idCategoria) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Categoria categoria = session.get(Categoria.class, idCategoria);

        // Validar si está relacionada a tickets
        Query<Long> query = session.createQuery(
            "select count(*) from Ticket t where t.categoria.id = :id", Long.class);
        query.setParameter("id", idCategoria);
        Long cantidad = query.uniqueResult();

        if (cantidad > 0) {
            session.close();
            throw new Exception("No se puede eliminar la categoría porque está asociada a tickets.");
        }

        session.delete(categoria);
        tx.commit();
        session.close();
    }

    public Categoria traerCategoria(long idCategoria) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Categoria categoria = session.get(Categoria.class, idCategoria);
        session.close();
        return categoria;
    }
}
