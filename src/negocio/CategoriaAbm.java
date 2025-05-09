package negocio;

import dao.CategoriaDao;
import datos.Categoria;

public class CategoriaAbm {
    private CategoriaDao dao = new CategoriaDao();

    public int agregarCategoria(String tipo) {
    	Categoria categoria = new Categoria();
    	categoria.setTipo(tipo);
        return dao.agregar(categoria);
    }

    public Categoria traerCategoria(int idCategoria) {
        return dao.traer(idCategoria);
    }

    public void modificarCategoria(Categoria categoria) {
        if (dao.estaAsociadaATickets(categoria.getIdCategoria())) {
            throw new RuntimeException("No se puede modificar la categoría porque está asociada a tickets.");
        }
        dao.actualizar(categoria);
    }

    public void eliminarCategoria(int idCategoria) throws Exception {
        if (dao.estaAsociadaATickets(idCategoria)) {
            throw new RuntimeException("No se puede eliminar la categoría porque está asociada a tickets.");
        }
        Categoria categoria = dao.traer(idCategoria);
        if (categoria == null) {
            throw new Exception("Categoría no encontrada.");
        }
        dao.eliminar(categoria);
    }
}