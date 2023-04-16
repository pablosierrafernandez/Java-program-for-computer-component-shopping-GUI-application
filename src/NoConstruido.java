
public class NoConstruido extends Exception {
	private static final long serialVersionUID= 1L;
	public NoConstruido(){
		super("No se ha podido crear un PC porque no cumple los requisitos");
	}
}
