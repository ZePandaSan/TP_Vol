package gestion_vol;

import java.time.ZonedDateTime;


public class Vol {
	private String id;
	private ZonedDateTime depart;
	private ZonedDateTime arrive;

	public Vol(String id, ZonedDateTime dep, ZonedDateTime arr){
		this.id=id;
		this.depart=dep;
		this.arrive=arr;
	}

	private void ouvrir(){

	}

	private void fermer(){

	}

	public String get_Duree(){
		int duree_heure=this.arrive.getHour()-this.depart.getHour();
		int duree_minute=this.arrive.getMinute()-this.depart.getMinute();
		if (duree_heure<0){
			duree_heure=(24-this.depart.getHour())+this.arrive.getHour();
		}
		if (duree_minute < 0) {
			duree_minute = (60 - this.depart.getMinute()) + this.arrive.getMinute();
			if(this.arrive.getDayOfMonth()==this.depart.getDayOfMonth())
			duree_heure--;
		}
		return duree_heure+":"+duree_minute;
	}

	public String get_ID(){
		return this.id;
	}

	
}