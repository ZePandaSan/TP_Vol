package gestion_vol;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.ArrayList;


public class Vol {
	private int id=1;
	private ZonedDateTime date_depart;
	private ZonedDateTime date_arrivee;
	private Aeroport depart;
	private Aeroport arrivee;
	private ArrayList <Escale> escales = new ArrayList<Escale>();

	public Vol(ZonedDateTime dep, ZonedDateTime arr){
		this.date_depart=dep;
		this.date_arrivee=arr;
		if (this.date_arrivee.isBefore(this.date_depart)){
			throw new IllegalArgumentException("Arrival cannot be prior to departure");
		}
		if (this.date_depart.equals(this.date_arrivee)){
			throw new IllegalArgumentException("Arrival cannot be at the same time as departure");
		}
		//this.mise_a_jour();
	}

	private void ouvrir(){

	}

	private void fermer(){

	}

	public String get_Duree(){ 
		String duree=Duration.between(this.date_depart, this.date_arrivee).toString();
		duree=(duree == null) ? null : duree.replaceAll("PT", "");
		duree=(duree == null) ? null : duree.replaceAll("H", ":");
		duree = (duree == null) ? null : duree.replaceAll("M", "");
		return duree;
	}

	public int get_ID(){
		return this.id;
	}

	public void mise_a_jour(){
		this.id++;
	}


	
}