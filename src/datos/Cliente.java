package datos;

public class Cliente extends Usuario {
	
	private int nroCliente; 
	
	public Cliente() {
	}
	
	public Cliente(String nombre, String apellido, int dni, int nroCliente) {
		super(nombre, apellido, dni);
		this.nroCliente = nroCliente;
	}

	public int getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(int nroCliente) {
		this.nroCliente = nroCliente;
	}

	@Override
	public String toString() {
		return "Cliente [nroCliente=" + nroCliente + "]";
	}
	
	
}
