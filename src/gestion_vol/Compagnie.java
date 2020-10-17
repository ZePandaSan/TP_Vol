package gestion_vol;

import java.util.ArrayList;
import java.util.List;

public class Compagnie{
	public String nom;
	private List<Vol> vols = new ArrayList<Vol>();

	public Compagnie(String nom){
		this.nom=nom;
	}

	public void creer_vol(Vol nomVol){
		this.vols.add(nomVol);
	}

	public List<Vol> get_vols(){
		return vols;
	}
}