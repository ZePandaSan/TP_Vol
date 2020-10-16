package gestion_vol;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;


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
		/*if (this.depart.minus(2,ChronoUnit.DAYS).isSupported(ChronoUnit.DAYS) && this.depart.getHour()<this.arrivee.getHour()+1){
			throw new IllegalArgumentException("Flights over 23 hours are not supported");
		}*/
	}

	private void ouvrir(){

	}

	private void fermer(){

	}

	public String get_Duree(){
		int duree_heure=this.arrivee.getHour()-this.depart.getHour();
		int duree_minute=this.arrivee.getMinute()-this.depart.getMinute();
		if (duree_heure<0){
			duree_heure=(24-this.depart.getHour())+this.arrivee.getHour();
		}
		if (duree_minute < 0) {
			duree_minute = (60 - this.depart.getMinute()) + this.arrivee.getMinute();
			if(this.arrivee.getDayOfMonth()==this.depart.getDayOfMonth())
			duree_heure--;
		}
		if (this.arrivee.getDayOfMonth() != this.depart.getDayOfMonth() && this.arrivee.getHour() != this.depart
				.getHour() && this.arrivee.getMinute() != this.depart.getMinute())
				{
					duree_heure--;
				}


		return duree_heure+":"+duree_minute;
	}

	public String get_ID(){
		return this.id;
	}


	
}