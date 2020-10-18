package gestion_vol;

import java.util.ArrayList;
import java.util.List;

public class Aeroport {
	private String nom;
	private Ville ville;
	public List<Ville> dessert = new ArrayList<Ville>();

	public Aeroport(String nom, Ville ville){
		this.nom = nom;
		this.ville=ville;
		this.ville.add_aeroport(this);
	}

	public String get_nom(){
		return this.nom;
	}

	public String get_nom_ville(){
		return this.ville.get_ville();
	}

	public Ville get_ville(){
		return this.ville;
	}

	public void add_destination(Ville ville){
		this.dessert.add(ville);
	}

}