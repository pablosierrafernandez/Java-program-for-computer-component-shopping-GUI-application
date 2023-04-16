import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Comandes {
	final int MAX= 100;
	private static int num_correlatiu=1;
	private Clients client;
	private String id;
	private float preu_total;
	private String data;
	private ListaProductos llista_productes;
	
	public Comandes (Clients client)
	{
		this.client=client;
		id=num_correlatiu+client.getDNI();
		num_correlatiu++;
		preu_total=0;
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		data = format.format(cal.getTime());
		llista_productes=new ListaProductos(MAX);
	}

	public Clients getClient() {
		return client;
	}

	public void setClient(Clients client) {
		this.client =client;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getPreu_total() {
		return preu_total;
	}

	public void setPreu_total(float preu_total) {
		this.preu_total = preu_total;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public ListaProductos getLlista_productes() {
		return llista_productes;
	}

	public void setLlista_productes(ListaProductos llista_productes) {
		this.llista_productes = llista_productes;
	}
	public int afegirProducte (int quantitat,Producto producte_nou,ListaProductos lista)
	{
		quantitat= lista.transfere(llista_productes,producte_nou.getNombre(),quantitat);
		if (quantitat>=0)
			preu_total+=quantitat*producte_nou.getPrecio();
		return quantitat;
	}
	public int eliminar_producte (Producto prod_a_eliminar, int quantitat,ListaProductos lista)
	{
		quantitat= llista_productes.transfere(lista, prod_a_eliminar.getNombre(), quantitat);
		if (quantitat>=0)
			preu_total-=quantitat*prod_a_eliminar.getPrecio();
		return quantitat;
	}
	public String toString()
	{
		return "Comanda:"+id+"\nData:"+data+"Productes:"+llista_productes+"Preu total:"+preu_total;
	}
	
}
