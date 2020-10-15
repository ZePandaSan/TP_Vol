package gestion_vol;

import java.sql.Date;

public class Vol {
	private int numero;
	private Date depart;
	private Date arrive;
	private Date duree;

	public Vol(int n, Date d, Date a){
		this.numero=n;
		this.depart=d;
		this.arrive=a;
		//this.duree=a-d;
	}

	private void ouvrir(){

	}

	private void fermer(){

	}

	
}