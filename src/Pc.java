

public class Pc extends Producto {
	   
	public ListaProductos listaSoftware;
	public ListaProductos listaHardware;


	public Pc(String nombre, float precio, int stock, int id, int numComandas,ListaProductos listaSoftware,ListaProductos listaHardware ) {
		super(nombre, precio, stock, id, numComandas);
		this.listaSoftware=listaSoftware;
		this.listaHardware=listaHardware;
	}
	
	

	
	public boolean comprobarRequisitos() {
		Producto sacar[];
		sacar=listaHardware.getLista();
		boolean apto=false, apto2=false;
		boolean hayCPU=false, hayMB=false, hayHDD=false, hayRAM=false, hayGPU=false, hayPERIFERICO=false;
		for(int i=0;apto==false && i<listaHardware.getLista().length;i++) {	
			switch (((Hardware)sacar[i]).getTipo()) {		/* como copio lo q me interesa*/
				case CPU: hayCPU=true; break;
				case MB: hayMB=true; break;
				case HDD: hayHDD=true;break;
				case RAM: hayRAM=true; break;
				case GPU: hayGPU=true; break;
				case PERIFERICO: hayPERIFERICO=true; break;
			}
			if((hayCPU)&&(hayMB)&&(hayHDD)&&(hayRAM)&&(hayGPU)&&(hayPERIFERICO)) {
				apto=true;
			}
		sacar=listaSoftware.getLista();
		for(i=0; apto2==false && i<listaHardware.getLista().length; i++){
			if(((Software)sacar[i]).getSistOp()==true)  {
				apto2=true; break;
			}
		}
		if(apto!=true || apto2!=true) {
			apto=false;
		}
		}
	return(apto);
	}
	
	public boolean añadirSoftware(Software nuevo) {  //*devuelve true si se añade correctamente*//
		boolean añadidoS=false;
		añadidoS=listaSoftware.addProducto(nuevo);
		return añadidoS;
	}
	public boolean añadirHardware(Hardware nuevo) {
		boolean añadidoH=false;
		añadidoH=listaHardware.addProducto(nuevo);
		return añadidoH;
	}
	public float calcularPrecio() {			/*dudas con que listas seleccionar*/
		float precioFinal=0;
		Producto individuo[];
		individuo=listaHardware.getLista();
		int i;
		for(i=0; i<listaHardware.getLista().length;i++) {
			precioFinal=individuo[i].getPrecio()+precioFinal;
			}
		for(i=0; i<listaSoftware.getLista().length;i++) {
			precioFinal=individuo[i].getPrecio()+precioFinal;
			}
		precioFinal=precioFinal-precioFinal*10/100;
	return(precioFinal);
	}


	public ListaProductos getListaSoftware() {
		return listaSoftware;
	}


	public void setListaSoftware(ListaProductos listaSoftware) {
		this.listaSoftware = listaSoftware;
	}


	public ListaProductos getListaHardware() {
		return listaHardware;
	}


	public void setListaHardware(ListaProductos listaHardware) {
		this.listaHardware = listaHardware;
	}


	public String toString() {
		return "Pc [listaSoftware=" + listaSoftware + ", listaHardware=" + listaHardware + "]";
	}
	
}
