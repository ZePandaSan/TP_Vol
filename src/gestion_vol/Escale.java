package gestion_vol;

import java.sql.Date;

public class Escale {
	private Date dateDepart;
	private Date dateArrivee;

	public Escale(Date dep, Date arr){
		this.dateDepart = dep;
		this.dateArrivee = arr;
	}
}
