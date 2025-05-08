package negocio;

import dao.EstadoDao;
import datos.Estado;

public class EstadoAbm {
	
	private EstadoDao dao = new EstadoDao();
	
	public int crearEstado(Estado e) {
		return dao.crearEstado(e);
	}
	
	public void actualizarEstado(Estado e) {
		Estado existe = dao.traerEstado(e.getIdEstado());
		if(existe == null) {
			throw new RuntimeException("Error, el estado no existe.");
		}
		dao.actualizarEstado(e);
	}
	
	public Estado traerEstado(int idEstado) {
		return dao.traerEstado(idEstado);
	}

}
