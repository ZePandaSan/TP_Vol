package gestion_vol;

import java.sql.Date;

public class Escale {
	private Date dateDepart;
	private Date dateArrivee;
	private long duree;

	public Escale(Date dep, Date arr){
		this.dateDepart = dep;
		this.dateArrivee = arr;
		this.duree = arr.getTime() - dep.getTime();
	}
}
