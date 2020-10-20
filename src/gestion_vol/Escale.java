package gestion_vol;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Escale {
	private ZonedDateTime date_depart;
	private ZonedDateTime date_arrivee;
	private Aeroport aeroport_escale;

	public Escale(ZonedDateTime depart, ZonedDateTime arrive, Aeroport aeroport){
		this.date_depart=depart;
		this.date_arrivee=arrive;
		this.aeroport_escale=aeroport;
	}

	public String get_duree(){
		String duree = Duration.between(this.date_depart, this.date_arrivee).toString();
		duree = (duree == null) ? null : duree.replaceAll("PT", "");
		duree = (duree == null) ? null : duree.replaceAll("M", "");

		return duree;
	}

	public void print_all(){
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm, dd MMM yyyy");
		System.out.println("Escale : "+this.aeroport_escale.get_nom()+"("+this.aeroport_escale.get_nom_ville()+")"+" de "+ format
				.format(date_depart)+" à "+format.format(date_arrivee)+"("+this.get_duree()+")");
	}
}
