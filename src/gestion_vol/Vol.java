package gestion_vol;

import java.time.Duration;
import java.time.ZonedDateTime;
//import java.util.concurrent.atomic.AtomicInteger;


public class Vol {
	private int id=1;
	private ZonedDateTime depart;
	private ZonedDateTime arrivee;

	public Vol(ZonedDateTime dep, ZonedDateTime arr){
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

	public int get_ID(){
		return this.id;
	}

	public void mise_a_jour(){
		this.id++;
	}


	
}