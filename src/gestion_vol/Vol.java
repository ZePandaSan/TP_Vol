package gestion_vol;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Vol {
	private int numero;
	private String id_compagnie;
	private ZonedDateTime date_depart;
	private ZonedDateTime date_arrivee;
	private Aeroport depart;
	private Aeroport arrivee;
	public ArrayList <Escale> escales = new ArrayList<Escale>();

	public Vol(String compagnie, int id){
		this.numero=id;
		this.id_compagnie=compagnie;
	}

	private void ouvrir(){

	}

	private void fermer(){

	}

	public void de(Aeroport aeroport1, ZonedDateTime date1){
		this.depart=aeroport1;
		this.date_depart = date1;
	} 

	public void vers(Aeroport aeroport2, ZonedDateTime date2){
		this.arrivee=aeroport2;
		this.date_arrivee=date2;
	}

	public String get_Duree(){ 
		String duree=Duration.between(this.date_depart, this.date_arrivee).toString();
		duree=(duree == null) ? null : duree.replaceAll("PT", "");
		duree = (duree == null) ? null : duree.replaceAll("M", "");
		
		return duree;
	}


	public void mise_a_jour(){
		this.numero++;
	}

	public int get_id(){
		return this.numero;
	}

	public String get_compagnie(){
		return this.id_compagnie;
	}

	public void verif(){
		if (this.date_arrivee.isBefore(this.date_depart)){
			throw new IllegalArgumentException("Arrival cannot be prior to departure");
		}
		if (this.date_depart.equals(this.date_arrivee)){
			throw new IllegalArgumentException("Arrival cannot be at the same time as departure");
		}
		if (this.depart.equals(this.arrivee)){
			throw new IllegalArgumentException("The place of arrival cannot be the same as the place of departure");
		}
		if(!this.depart.dessert.contains(this.arrivee.get_ville())){
			throw new IllegalArgumentException("This airport does not serve the city entrance");
		}
	}

	public void print_all(){
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm, dd MMM yyyy");
		System.out.println("Flight id : " + this.id_compagnie +" "+ this.numero);
		//System.out.println("Time zone : " + paris);
		System.out.println("Departure : " + format.format(date_depart) + " " + date_depart.getZone()+" a "+this.depart.get_nom()+"("+this.depart.get_nom_ville()+")");
		System.out.println("Arrival : " + format.format(date_arrivee) + " " + date_arrivee.getZone() + " a "
				+ this.arrivee.get_nom() + "(" + this.arrivee.get_nom_ville()+")");
		System.out.println("Duration : " + this.get_Duree());
		for (Escale e : escales){
			e.print_all();
		}
	}

	
}