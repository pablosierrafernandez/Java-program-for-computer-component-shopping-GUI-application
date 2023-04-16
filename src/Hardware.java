

public class Hardware extends Producto {
	public enum tipos {CPU,MB,HDD,RAM,GPU,PERIFERICO}
	public tipos tipo;
	
	public Hardware(String nombre, float precio, int stock, int id, int numComandas, tipos tipo) {
		super(nombre, precio, stock, id, numComandas);
		this.tipo=tipo;
		
	}
	
	public tipos getTipo() {
		return tipo;
	}
	
	public void setTipo(tipos tipo) {
	this.tipo =tipo;
	}


	public String toString() {
		return "Hardware [tipo=" + tipo + "]";
	}
	
}