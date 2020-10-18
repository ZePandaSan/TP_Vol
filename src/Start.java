import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import gestion_vol.Aeroport;
import gestion_vol.Compagnie;
import gestion_vol.Ville;
import gestion_vol.Vol;

public class Start{
	public static void main(String[] args){
		Compagnie airFrance = new Compagnie("Air France");
		//----------------------------------------------------------------------------------
		ZoneId fuseauParis = ZoneId.of("Europe/Paris");
		//----------------------------------------------------------------------------------
		Ville paris = new Ville("Paris");
		Ville barcelone = new Ville("Barcelone");
		//----------------------------------------------------------------------------------
		Aeroport cdg = new Aeroport("Charles de Gaules", paris);
		Aeroport bep = new Aeroport("Barcelone-El Prat", barcelone);
		//----------------------------------------------------------------------------------
		LocalDateTime dep = LocalDateTime.of(2020, Month.OCTOBER, 21, 20, 00);
		LocalDateTime arr = LocalDateTime.of(2020, Month.OCTOBER, 21, 23, 00);
		LocalDateTime dep2 = LocalDateTime.of(2020, Month.OCTOBER, 21, 23, 00);
		LocalDateTime arr2 = LocalDateTime.of(2020, Month.OCTOBER, 22, 02, 00);
		//----------------------------------------------------------------------------------
		ZonedDateTime heure_depart = dep.atZone(fuseauParis);
		ZonedDateTime heure_arrive = arr.atZone(fuseauParis);
		ZonedDateTime heure_depart2 = dep2.atZone(fuseauParis);
		ZonedDateTime heure_arrive2 = arr2.atZone(fuseauParis);
		//-----------------------------------------------------------------------------------
		airFrance.creer_vol( cdg, heure_depart, bep, heure_arrive);
		System.out.println("-----------------------------------------------------------------");
		airFrance.creer_vol(bep, heure_depart2, cdg, heure_arrive2);
		//----------------------------------------------------------------------------------
	}

	
}