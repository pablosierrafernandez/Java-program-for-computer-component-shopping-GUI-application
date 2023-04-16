
public class ListaClients {

	private Clients[] lista;
	private int clients;
	private int max;
	public ListaClients(int max) {
		this.max=max;
		lista = new Clients[max];
		clients=0;
	}
	
	public boolean addCliente(Clients cliente) {
		if(clients<max) {
			lista[clients]=cliente;//.copia();
			clients++;
			return true;
		}return false;
	}
	
	public boolean borrarCliente(String dni) {
		for(int i = 0; i<clients; i++) {
			if(dni==lista[i].getDNI()) {
				clients--;
				while(i<clients) {
					lista[i]=lista[i+1];
				}
				return true;
			}
		}
		
		return false;
	}
	
	public int buscarCliente(String dni) {
		for(int i = 0; i<clients;i++) {
			if(dni==lista[i].getDNI())
				return i;
		}
		return -1;
	}
	
	public int clienteRepetido() {
		for (int i = 0; i < clients-1;i++) {
			for (int j = i+1; j<clients;j++) {
				if(lista[i].getDNI()==lista[j].getDNI()) {
					return j;
					//return lista[j];
				}
			}
		}
		return -1;
	}
	

	
	
	
	public int getClients() {
		return clients;
	}
	
	public String toString() {
		String resumen;
		resumen="Numero de clientes: "+ clients;
		resumen+="\nClientes: ";
		for (int i =0; i <clients;i++) {
			resumen+="\n"+lista[i].toString();
		}
		return resumen;
	}

}
