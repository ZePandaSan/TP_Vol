package gestion_vol;


public class Escale {
	private Datetime dateDepart;
	private Datetime dateArrivee;

	public Escale(Datetime dep, Datetime arr){
		this.dateDepart = dep;
		this.dateArrivee = arr;
	}
}
