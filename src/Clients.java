
public class Clients {
	private String DNI,correu,adre�a;
	
	public Clients (String identificador,String email,String direccio)
	{
	DNI=identificador;
	correu=email;
	adre�a=direccio;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}

	public String getCorreu() {
		return correu;
	}

	public void setCorreu(String correu) {
		this.correu = correu;
	}

	public String getAdre�a() {
		return adre�a;
	}

	public void setAdre�a(String adre�a) {
		this.adre�a=adre�a;
	}
	public String toString() {
		return "DNI:"+DNI+"\nCorreu:"+correu+"\nAdre�a:"+adre�a;
	}
	
	public Clients copia() {
		return new Clients(DNI, correu, adre�a);
	}
}
