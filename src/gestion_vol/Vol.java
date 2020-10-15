package gestion_vol;

import java.time.ZoneDateTime;

public class Vol {
	private int numero;
	private ZoneDateTime depart;
	private ZoneDateTime arrive;
	private ZoneDateTime duree;

	public Vol(int n, ZoneDateTime d, ZoneDateTime a){
		this.numero=n;
		this.depart=d;
		this.arrive=a;
		this.duree=a-d;
	}

	private void ouvrir(){

	}

	private void fermer(){

	}

	
}
