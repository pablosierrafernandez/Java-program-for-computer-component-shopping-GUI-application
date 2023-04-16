
public class ListaProductos {
	private Producto[] lista;
	private int numObj;
	private int prodTotal;
	private int max;
	public ListaProductos(int max) {
		this.max=max;
		lista = new Producto[max];
		prodTotal=0;
		numObj=0;
	}
	
	public boolean addProducto(Producto producto) {
		for (int i = 0; i<numObj;i++) {
			if(producto.getNombre()==lista[i].getNombre()) {
				lista[i].setStock(lista[i].getStock()+producto.getStock());
				prodTotal+=producto.getStock();
				return true;
			}
		}
		if(numObj<max) {
			lista[numObj]=producto.copia();
			prodTotal+=producto.getStock();
			return true;
		}
		return false;
	}
	
	public boolean borrarItem(String name) {
		for(int i = 0; i<numObj; i++) {
			if(name==lista[i].getNombre()) {
				numObj--;
				while(i<numObj) {
					lista[i]=lista[i+1];
				}
				return true;
			}
		}
		
		return false;
	}
	
	public int quitarStock(String name, int stock) {
		for(int i = 0; i<numObj;i++) {
			if(name==lista[i].getNombre()) {
				if(lista[i].getStock()-stock<0) {
					int eliminar=stock-lista[i].getStock();
					lista[i].setStock(0);
					return eliminar; //devuelve no eliminados
				}else {
					lista[i].setStock(lista[i].getStock()-stock);
					return 0;		//0 si todo eliminado
				}
				
			}
		}return -1;
	}
	public int itemRepetidoYPosicion(String name) {    // PABLO: He añadido esto.
		for(int i = 0; i<numObj;i++) {
			if(name==lista[i].getNombre())
				return i;
		}
		return -1;
	}
	public int buscarItem(String name) {
		for(int i = 0; i<numObj;i++) {
			if(name==lista[i].getNombre())
				return lista[i].getStock();
		}
		return -1;
	}
	
	public int itemRepetido() {
		for (int i = 0; i < numObj-1;i++) {
			for (int j =i+1; j<numObj;j++) {
				if(lista[i].getNombre()==lista[j].getNombre()) {
					return j;
				}
			}
		}
		return -1;
	}
	
	public int transfere(ListaProductos destino, String nombreProducto, int stock) {
		int transferido=stock-quitarStock(nombreProducto, stock);
		if(transferido>stock) {
			return -1;
		}else {
			Producto copia=lista[0].copia();
			for(int i = 0; i<numObj;i++) {
				if(nombreProducto==lista[i].getNombre()) {
					copia=lista[i].copia();
					i=numObj;
				}		
			}
			copia.setStock(transferido);
			if(!destino.addProducto(copia)) {
				addProducto(copia);
				return -2;					//No se puede añadir porque esta llena
			}	
			return transferido;				//devuelve los que se han podido transferir
		}
		
	}
	public Producto maxComandas() {       /* la creo para el main, soy Jorge*/
		int max=0;
		int posicion=0;
		for(int i=0; i<lista.length;i++) {
			if(max<lista[i].getNumComandas()) {
				max=lista[i].getNumComandas();
				posicion=i;
			}
		}		
							/*aqui se puede hacer una itinerancia*/
		return (lista[posicion]);
	}
	
	public Producto[] getLista() {
		return lista;
	}

	public void setLista(Producto[] lista) {
		this.lista = lista;
	}
	
	
	
	public int getProdTotal() {
		return prodTotal;
	}
	
	public int getNumObj() {
		return numObj;
	}
	
	public String toString() {
		String resumen;
		resumen="Numero de productos distintos: "+ numObj;
		resumen+=" Numero total de productos: "+prodTotal;
		for (int i = 0; i <numObj;i++) {
			resumen+="\n"+lista[i].toString();
		}
		return resumen;
	}
	

}
