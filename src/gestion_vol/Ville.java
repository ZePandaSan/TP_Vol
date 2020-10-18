package gestion_vol;

import java.util.ArrayList;
import java.util.List;

public class Ville {
	private String nom;
	private List<Aeroport> aeroports = new ArrayList<Aeroport>();

	public Ville(String n){
		this.nom = n;
	}

	public String get_ville(){
		return this.nom;
	}

	public void add_aeroport(Aeroport aeroport){
		this.aeroports.add(aeroport);
	}
}