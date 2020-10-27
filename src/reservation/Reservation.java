package reservation;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import gestion_vol.Vol;

public class Reservation {
	private int numero;
	private ZonedDateTime date;
	private Client nom;
	private int id_vol;
	private Passager passager;

	public Reservation(int num, ZonedDateTime d, Client client, int v, Passager passager){
		this.numero = num;
		this.date = d;
		this.nom=client;
		this.id_vol=v;
		this.passager=passager;
	}

	public void confirmer(){

	}

	public void annuler(){
		
	}

	public void print_all(){
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm, dd MMM yyyy");
		System.out.println("Réservation n° " + this.numero);
		System.out.println("Client : " + this.nom.get_nom());
		System.out.println("Passager : "+ this.passager.get_nom());
		System.out.println("Vol : " + this.id_vol);
		System.out.println("Date : " + format.format(this.date));
		System.out.println("-----------------------------------------------------------------");

	}
}