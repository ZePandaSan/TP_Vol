package reservation;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import gestion_vol.Vol;

public class Reservation {
	private int numero;
	private ZonedDateTime date;
	private Client nom;
	private Vol vol;
	private Passager passager;

	public Reservation(int num, ZonedDateTime d, Client client, Vol v, Passager passager){
		this.numero = num;
		this.date = d;
		this.nom=client;
		this.vol=v;
		this.passager=passager;
		v.reservation.add(this);
		this.verif();
	}

	public void verif(){
		if (this.date.isAfter(this.vol.date_depart)){
			throw new IllegalArgumentException("The flight is already gone!");
		}
	}

	public void print_all(){
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm, dd MMM yyyy");
		System.out.println("Réservation n° " + this.numero);
		System.out.println("Client : " + this.nom.get_nom());
		System.out.println("Passager : "+ this.passager.get_nom());
		System.out.println("Vol : " + this.vol.get_compagnie()+" "+this.vol.get_id());
		System.out.println("Date : " + format.format(this.date));
		System.out.println("-----------------------------------------------------------------");

	}
}