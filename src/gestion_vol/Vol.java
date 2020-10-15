package gestion_vol;

import java.sql.Date;


public class Vol {
	private int numero;
	private Date depart;
	private Date arrive;
	private long duree;

	public Vol(int n, Date dep, Date arr){
		this.numero=n;
		this.depart=dep;
		this.arrive=arr;
		this.duree=arr.getTime()-dep.getTime();
	}

	private void ouvrir(){

	}

	private void fermer(){

	}

	
}