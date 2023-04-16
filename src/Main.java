import java.util.Scanner;


public class Main {
	static Scanner llegir = new Scanner(System.in);
	/*menu:conjunt de prints que mostren el menu d'opcions*/
	public static void menu() {

		System.out.println("\n\n Opcions de l'aplicació:");
		System.out.println("\n\t1.Afegir un producte de software.");
		System.out.println("\t2.Afegir un producte de hardware.");
		System.out.println("\t3.Afegir una configuració completa.");
		System.out.println("\t4.Donar d'alta un client.");
		System.out.println("\t5.Donar de baixa un client.");
		System.out.println("\t6.Treure llistat de tots els productes que tenen alguna comanda.");
		System.out.println("\t7.Modificar l'estoc.");
		System.out.println("\t8.Llistat de productes amb estoc>=1.");
		System.out.println("\t9.Llistat de productes que formen alguna configuració.");
		System.out.println("\t10.Producte més venut.");
		System.out.println("\t11.Elements de la llista.");
		System.out.println("\t0.Fi del programa.");
		System.out.print("\n\tTria una opció:\n");
	}
	public static void alta_client (ListaClients lista)
	{
		System.out.println("Anem a donar d'alta a un client:");
		System.out.println("\tDNI:");
		String Dni=llegir.next();
		System.out.println("\tCorreu:");
		String correu=llegir.next();
		System.out.println("\tAdreça:");
		String adreça=llegir.next();
		Clients client=new Clients(Dni,correu,adreça);
		if (lista.buscarCliente(Dni)!=-1)
			if(lista.addCliente(client))
				System.out.println("Client donat d'alta correctament");
			else
				System.out.println("ERROR:Maxim de clients assolit");
		else
			System.out.println("ERROR:Client ja existent");
			
	}
	public static void baixa_client (ListaClients lista)
	{
		System.out.println("Anem a donar de baixa a un client:");
		System.out.println("\tDNI:");
		String Dni=llegir.next();
		if (lista.buscarCliente(Dni)==-1)
			if(lista.borrarCliente(Dni))
				System.out.println("Client donat de baixa correctament");
			else
				System.out.println("ERROR al donar de baixa");
		else
			System.out.println("ERROR:Client no existent");
			
	}
	public static void partesPc9(ListaProductos parte_Software, ListaProductos parte_Hardware) {
		Pc partes;
		partes.listaHardware=parte_Software;
		Producto imprimir[];
		imprimir=partes.listaSoftware.getLista();
		System.out.println("El Pc pose los siguientes Softwares:");
		for(int i=0; i<partes.listaSoftware.getLista().length;i++) {
			System.out.println("\n"+imprimir[i].getNombre());/* hay	que CAMBIARLO*/
		}
		System.out.println("Y los siguientes Hardwares:");
		for(int i=0; i<partes.listaHardware.getLista().length;i++) {
			System.out.println("\n"+imprimir[i].getNombre());/* hay	que CAMBIARLO*/
		}	
		}
	public static void añadirSoftware ( ListaProductos listaTienda){   
		boolean loes=false;
		Software.instalable tipo;
		System.out.println("¿De qué tipo quieres añadir? (1)-Sistema Operativo. \n(2)-Otros.");
		boolean nopasa4=true;
		while(nopasa4==true) {
		try {
		int soOtros =llegir.nextInt();
		nopasa4=false;
		if(soOtros==1) {
			loes=true;
			System.out.println("¿Que SO es? (1)-Linux. \n(2)-Ubuntu.\n(3)-Macos.\n(4)-Microsoft.\n(5)-Android.\n(6)-Ios.");
			int op;
			while((op<1)||(op>6)) {
			try {
			op=llegir.nextInt();
			switch(op) {
			case 1: tipo=Software.instalable.LINUX; 
			case 2: tipo=Software.instalable.UBUNTU;
			case 3: tipo=Software.instalable.MACOS;
			case 4: tipo=Software.instalable.MICROSOFT;
			case 5: tipo=Software.instalable.ANDROID;
			case 6: tipo=Software.instalable.IOS;
			}}
			catch (NumberFormatException e){
				System.out.println("Error, tiene que escribir un numero del 1 al 6");
				
			}}
		}
		System.out.println("¿Cómo se llama el producto?");
		
		String nombre=llegir.next();
		int repetido=listaTienda.itemRepetidoYPosicion(nombre);
		if(repetido!=-1) {
			System.out.println("El producto "+nombre+" ya esta!");
			System.out.println("¿Cúantos quiere añadir/eliminar(-)?");
			boolean nopasa=true;
			while(nopasa==true) {
			try {
			int añadir=llegir.nextInt();
			listaTienda.getLista()[repetido].modificarStock(añadir);
			nopasa=false;
			}
		
		catch (NumberFormatException e){
			System.out.println("Error, tiene que escribir un numero, intentelo nuevamente");
			nopasa=true;
			
		}
			}
			
		}
		else {
			boolean nopasa2=true;
			while(nopasa2==true) {
			try {
			System.out.println("¿Cúanto cuesta cada producto?");
			float precio =llegir.nextFloat();
			nopasa2=false;
			}
			catch (NumberFormatException e){
				System.out.println("Error, tiene que escribir un numero, intentelo nuevamente");
				nopasa2=true;
				
			}catch (NegativeArraySizeException e){
				System.out.println("Error, tiene que escribir un numero positivo");
				nopasa2=true;
			}}
			System.out.println("Inserte un ID");    //¿como va esto?
			int id=llegir.nextInt();
			boolean nopasa3=true;
			System.out.println("¿Cúantos quiere añadir?");
			while(nopasa3==true) {
			try {
			
				int añadir=llegir.nextInt();
				nopasa3=false;
				
				
				
				Software nuevoS=new Software (nombre, precio, añadir,id, 0,loes, tipo);	
				boolean correcto=listaTienda.addProducto(nuevoS);
				if(correcto==true) {
					System.out.println("El producto se ha añadido perfectamente");
				}
				else {
					System.out.println("No se ha podido añadir.");
				}
				
			}
			
			catch (NumberFormatException e){
				System.out.println("Error, tiene que escribir un numero");
				nopasa3=true;
			}
			catch (NegativeArraySizeException e){
				System.out.println("Error, tiene que escribir un numero positivo");
				nopasa3=true;
			}
			}
			}
		}
			catch (NumberFormatException e){
				System.out.println("Error, tiene que escribir un numero, intentelo nuevamente");
				nopasa4=true;
				
				
			}catch (NegativeArraySizeException e){
				System.out.println("Error, tiene que escribir un numero positivo");
				nopasa4=true;
			}}}
			
			
			
			
			
	
		
	
	public static void añadirHardware (ListaProductos listaTienda) {
		Hardware.tipos tipo;
		String nombre;
		System.out.println("¿Qué producto quiere añadir?");
		nombre=llegir.next();
		
		int repetido=listaTienda.itemRepetidoYPosicion(nombre);
		if(repetido!=-1) {
			System.out.println("El producto "+nombre+" ya esta!");
			System.out.println("¿Cúantos quiere añadir/eliminar(-)?");
			boolean nopasa=true;
			while(nopasa==true) {
			try {
			int añadir=llegir.nextInt();
			listaTienda.getLista()[repetido].modificarStock(añadir);
			nopasa=false;
			listaTienda.getLista()[repetido].modificarStock(añadir);
			}
		
		catch (NumberFormatException e){
			System.out.println("Error, tiene que escribir un numero, intentelo nuevamente");
			nopasa=true;
			
		}
			}
			
			
			
		}
		else {
			try {
			System.out.println("El producto no existe, de que tipo es?\n (1).CPU  (2).MB  (3).HDD  (4).RAM  (5).GPU");
			int producto=llegir.nextInt();
			switch(producto) {
			case 1: tipo=Hardware.tipos.CPU; 
			case 2: tipo=Hardware.tipos.MB;
			case 3: tipo=Hardware.tipos.HDD;
			case 4: tipo=Hardware.tipos.RAM;
			case 5: tipo=Hardware.tipos.GPU;
			
			}
			
			System.out.println("¿Cúanto cuesta cada producto?");
			float precio =llegir.nextFloat();
			System.out.println("¿Cúantos quiere añadir?");
			int añadir=llegir.nextInt();
			
			int a=listaTienda.getLista().length;
			int	id=listaTienda.getLista()[a].getId();
			
			Hardware nuevoH=new Hardware (nombre, precio, añadir,id,0,tipo);
			boolean correcto=listaTienda.addProducto(nuevoH);
			if(correcto==true) {
				System.out.println("El producto se ha añadido perfectamente");
			}
			else {
				System.out.println("No se ha podido añadir.");
			}}catch (NumberFormatException e){
				System.out.println("Error, tiene que escribir un numero");
				
			}
			catch (NegativeArraySizeException e){
				System.out.println("Error, tiene que escribir un numero positivo");
				
			}
			
		}
		
	}
	public static void crearPC (ListaProductos listaTienda) throws NoConstruido {
		int DIM=500;
		ListaProductos nuevoHardware=new ListaProductos(DIM);	
		ListaProductos nuevoSoftware=new ListaProductos(DIM);
		
		System.out.println("Escriba el nombre del PC");
		String nombre=llegir.nextLine();
		boolean nopasa=true;
		System.out.println("(1)AÑADIR SOFTWARE (2)AÑADIR HARDWARE (0)SALIR");
		while(nopasa==true)
		try {
		int menu=llegir.nextInt();
		while(menu!=0) {
			
			switch(menu) {
			case 1: System.out.println("Inserte un Software");
			String software=llegir.next();
			int esta=listaTienda.itemRepetidoYPosicion(software);
			if(esta!=-1) {
				
				boolean correcto=nuevoSoftware.addProducto(listaTienda.getLista()[esta]);
				
				if(correcto==true) {
					System.out.println("El producto se ha añadido");
					listaTienda.getLista()[esta].modificarStock(-1);
				}
				else {
					System.out.println("El producto no se ha añadido");
				}
				
			}
			else {
				System.out.println("El producto no está en la tienda");
			}
			break;
			case 2: System.out.println("Inserte un Hardware");
			String hardware=llegir.next();
			int esta2=listaTienda.itemRepetidoYPosicion(hardware);
			if(esta2!=-1) {
				
				boolean correcto=nuevoHardware.addProducto(listaTienda.getLista()[esta2]);
				
				if(correcto==true) {
					System.out.println("El producto se ha añadido");
					listaTienda.getLista()[esta2].modificarStock(-1);
				}
				else {
					 throw new NoConstruido();
					
				}
				
			}
			else {
				System.out.println("El producto no está en la tienda");
			}
			break;
			}
			System.out.println("(1)AÑADIR SOFTWARE (2)AÑADIR HARDWARE (0)SALIR");
			menu=llegir.nextInt();
		}
		int a=listaTienda.getLista().length;
	int	id=listaTienda.getLista()[a].getId();
		Pc nuevoPc=new Pc(nombre,0,1, id, 0, nuevoSoftware, nuevoHardware);
		
		boolean apto=nuevoPc.comprobarRequisitos();
		if(apto==true) {
			listaTienda.addProducto(nuevoPc);
			nuevoPc.modificarStock(1);
			System.out.println("El PC se ha añadido a la tienda");
			nuevoPc.setPrecio(nuevoPc.calcularPrecio());
		}
		else {
			System.out.println("El PC no cumple con los requisitos y no ha podido ser añadido");
			
		}}catch (NumberFormatException e){
			System.out.println("Error, tiene que escribir un numero");
			nopasa=true;
			
		}
		catch (NegativeArraySizeException e){
			System.out.println("Error, tiene que escribir un numero positivo");
			nopasa=true;
		}
		
	}
	
		
	}
	public static void main(String[] args) {
		int DIM=500;
		ListaProductos lista_tienda=new ListaProductos (DIM);
		ListaClients lista_clientes=new ListaClients (DIM);
		ListaComandes lista_comandas=new ListaComandes (DIM);
		int opcio=-1;
		while (opcio != 0) {

			menu();

			opcio = llegir.nextInt();

			switch (opcio) {

			case 1:
					añadirSoftware(lista_tienda);
				
				break;
			case 2:
					añadirHardware(lista_tienda);
				
				break;
			case 3: try {
					crearPC(lista_tienda);}
			catch(NoConstruido ex){
				System.out.println(ex.toString());
			}
				
				break;
			case 4:
					alta_client(lista_clientes);
				break;
			case 5:
					baixa_client(lista_clientes);
				break;
			case 6:
				
				break;
			case 7:
				
				break;
			case 8:
				
				break;
			case 9:
				partesPc9(lista_tienda);
				
				break;
			case 10:
				
				break;
			case 11:
				
				break;
			case 0:
				System.out.println("FI DEL PROGRAMA");
				break;
			default:
				System.out.println("OPCIO NO VALIDA");

			}

		}

		llegir.close();
		
	}

}
