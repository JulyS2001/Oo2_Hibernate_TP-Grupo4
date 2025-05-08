package datos;

public class Sistema {

private int idSistema;
	
	public Sistema() {
		// TODO Auto-generated constructor stub
	}

	public int getIdSistema() {
		return idSistema;
	}

	protected void setIdSistema(int idSistema) {
		this.idSistema = idSistema;
	}

	@Override
	public String toString() {
		return "SistemaDao [idSistema=" + idSistema + "]";
	}
	
	
}
