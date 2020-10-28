package reservation;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import gestion_vol.Vol;

public class Client {
	private String nom;
	private int paiement=1;
	private List<Reservation> reference = new ArrayList<Reservation>();

	public Client(String n){
		this.nom = n;
	}

	public void creer_reservation(ZonedDateTime date, Client client, Vol vol, Passager passager){
		Reservation r = new Reservation(this.get_id(), date, this, vol, passager);
		this.reference.add(r);
		r.print_all();
	}

	public int get_id(){
		return this.paiement++;
	}

	public String get_nom(){
		return this.nom;
	}
}