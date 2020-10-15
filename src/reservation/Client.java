package reservation;

public class Client {
	private String nom;
	private String reference;
	private String paiement;
	private String contact;

	public Client(String n, String ref, String paiement, String contact){
		this.nom = n;
		this.reference = ref;
		this.paiement = paiement;
		this.contact = contact;
	}
}