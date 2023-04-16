
public class Clients {
	private String DNI,correu,adreça;
	
	public Clients (String identificador,String email,String direccio)
	{
	DNI=identificador;
	correu=email;
	adreça=direccio;
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

	public String getAdreça() {
		return adreça;
	}

	public void setAdreça(String adreça) {
		this.adreça=adreça;
	}
	public String toString() {
		return "DNI:"+DNI+"\nCorreu:"+correu+"\nAdreça:"+adreça;
	}
	
	public Clients copia() {
		return new Clients(DNI, correu, adreça);
	}
}
