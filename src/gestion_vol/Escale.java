package gestion_vol;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Escale {
	private ZonedDateTime date_depart;
	private ZonedDateTime date_arrivee;
	private Vol vol;
	private Aeroport aeroport_escale;

	public Escale(ZonedDateTime depart, ZonedDateTime arrive, Aeroport aeroport, Vol vol){
		this.date_depart=depart;
		this.date_arrivee=arrive;
		this.aeroport_escale=aeroport;
		this.vol=vol;
		this.verif();
	}

	public String get_duree(){
		String duree = Duration.between(this.date_arrivee, this.date_depart).toString();
		duree = (duree == null) ? null : duree.replaceAll("PT", "");
		duree = (duree == null) ? null : duree.replaceAll("M", "");

		return duree;
	}

	public void verif(){
		if (this.date_arrivee.isAfter(this.date_depart)){
			throw new IllegalArgumentException("The flight cannot arrive after its departure");
		}
		if (this.date_arrivee.isBefore(this.vol.date_depart)){
			throw new IllegalArgumentException("The flight cannot arrive at the stopover before taking off");
		}
		if (this.date_depart.isAfter(this.vol.date_arrivee)){
			throw new IllegalArgumentException("The flight cannot leave the stopover after landing");
		}
	}

	public void print_all(){
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm, dd MMM yyyy");
		System.out.println("Stopover : "+this.aeroport_escale.get_nom()+"("+this.aeroport_escale.get_nom_ville()+")"+" from "+ format
				.format(date_arrivee)+" to "+format.format(date_depart)+"("+this.get_duree()+")");
	}
}
