
public class ListaComandes {
	private Comandes[] lista;
	private int comandes;
	private int max;
	
	public ListaComandes(int max) {
		lista= new Comandes[max];
		this.max=max;
		comandes=0;		
	}
	
	public boolean addComanda(Comandes add) {
		if(comandes<max) {
			lista[comandes]=add;//.copia();
			comandes++;
			return true;
		}
		return false;
	}
	
	public Comandes buscarComanda(String id) {
		for(int i =0; i<comandes;i++) {
			if(id==lista[i].getId())
				return lista[i];//.copy();
		}
		return null;
	}
	
	public int getComandes() {
		return comandes;
	}

}
