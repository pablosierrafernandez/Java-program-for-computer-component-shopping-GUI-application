
public class Producto {
	public String nombre;
	public float precio;
	public int stock;
	public int id;
	public static int contID=-1;
	public int numComandas;

	public Producto(String nombre, float precio, int stock, int id, int numComandas) {
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.id = id;
		this.numComandas=numComandas; 
		if(id==-1) {
			contID++;
			this.id=contID;
			
		}
		
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock =stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getContID() {
		return contID;
	}

	public static void setContID(int contID) {
		Producto.contID = contID;
	}

	public int getNumComandas() {
		return numComandas;
	}

	public void setNumComandas(int numComandas) {
		this.numComandas = numComandas;
	}

	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + ", id=" + id
				+ ", numComandas=" + numComandas + "]";
	}
	
	public void modificarStock (int nuevoStock) {
		stock+=nuevoStock;
	}
	
	public Producto copia() {
		return new Producto(nombre, precio, stock, id, numComandas);
	}
}