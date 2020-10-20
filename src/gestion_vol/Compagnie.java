package gestion_vol;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Compagnie{
	public String nom;
	public int idvol=1;
	private List<Vol> vols = new ArrayList<Vol>();

	public Compagnie(String nom){
		this.nom=nom;
	}

	public void creer_vol(Aeroport aeroport1, ZonedDateTime date1, Aeroport aeroport2, ZonedDateTime date2){
		Vol v = new Vol(this.nom,this.get_id());
		v.de(aeroport1, date1);
		v.vers(aeroport2, date2);
		this.vols.add(v);
		v.verif();
	}

	public void add_escale(Escale e, int num){
		for(Vol v : vols){
			if (v.get_id()==num){
				v.escales.add(e);
			}
		}
	}

	public int get_id(){
		return this.idvol++;
	}

	public List<Vol> get_vols(){
		return vols;
	}

	public void print_all(){
		for (Vol v : vols){
			v.print_all();
			System.out.println("-----------------------------------------------------------------");
		}
	}
}