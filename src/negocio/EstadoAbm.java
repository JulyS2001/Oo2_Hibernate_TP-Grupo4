package negocio;

import dao.EstadoDao;
import datos.Estado;

public class EstadoAbm {
	
	private EstadoDao dao = new EstadoDao();
	
	public int crearEstado(String tipo) throws Exception {
		Estado estadoExistente = traerEstadoPorTipo(tipo);
		if(estadoExistente!=null) throw new Exception ("Error: el estado ya existe, " + estadoExistente);
		
    	Estado estado = new Estado();
    	estado.setTipo(tipo);
        return dao.crearEstado(estado);
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
	
	public Estado traerEstadoPorTipo(String tipo) {
		return dao.traerEstadoPorTipo(tipo);
	}

}
