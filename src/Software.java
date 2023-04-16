

public class Software extends Producto {
	public boolean SistOp;
	public enum instalable {LINUX,UBUNTU,MACOS,MICROSOFT,ANDROID,IOS}
	public instalable compatible;
	
	public Software(String nombre, float precio, int stock, int id, int numComandas, boolean SistOp, instalable compatible) { 
		super(nombre, precio, stock, id, numComandas);							
		this.SistOp=SistOp;
		this.compatible=compatible;		
	}
	
	public boolean getSistOp() {
		return SistOp;
	}
	public void setSistOp(boolean SistOp) {
		this.SistOp = SistOp;
	}

	public instalable getCompatible() {
		return compatible;
	}

	public void setCompatible(instalable compatible) {
		this.compatible = compatible;
	}
	public String toString() {
		return ( super.toString()+"Software [disponible para=" + compatible + "]");
	}
	
	
}