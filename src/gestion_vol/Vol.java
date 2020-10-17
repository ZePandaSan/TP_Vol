package gestion_vol;

import java.time.Duration;
import java.time.ZonedDateTime;


public class Vol {
	private String id;
	private ZonedDateTime depart;
	private ZonedDateTime arrivee;

	public Vol(String id, ZonedDateTime dep, ZonedDateTime arr){
		this.id=id;
		this.depart=dep;
		this.arrivee=arr;
		if (this.arrivee.isBefore(this.depart)){
			throw new IllegalArgumentException("Arrival cannot be prior to departure");
		}
		if (this.depart.equals(this.arrivee)){
			throw new IllegalArgumentException("Arrival cannot be at the same time as departure");
		}
	}

	private void ouvrir(){

	}

	private void fermer(){

	}

	public String get_Duree(){ 
		String duree=Duration.between(this.depart, this.arrivee).toString();
		duree=(duree == null) ? null : duree.replaceAll("PT", "");
		duree=(duree == null) ? null : duree.replaceAll("H", ":");
		duree = (duree == null) ? null : duree.replaceAll("M", "");
		return duree;
	}

	public String get_ID(){
		return this.id;
	}


	
}