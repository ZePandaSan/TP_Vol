package gestion_vol;

public class Aeroport {
	private String nom;
	private Ville ville;

	public Aeroport(String nom, Ville ville){
		this.nom = nom;
		this.ville=ville;
	}

	public String get_nom(){
		return this.nom;
	}

	public String get_ville(){
		return this.ville.get_ville();
	}

}