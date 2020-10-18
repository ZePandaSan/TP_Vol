import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import gestion_vol.Aeroport;
import gestion_vol.Compagnie;
import gestion_vol.Ville;


public class Start{
	public static void main(String[] args){
		Compagnie airFranceCompagnie = new Compagnie("Air France");
		Compagnie lufthansaCompagnie = new Compagnie("Luftensa");
		//----------------------------------------------------------------------------------
		ZoneId fuseauParis = ZoneId.of("Europe/Paris");
		//----------------------------------------------------------------------------------
		Ville parisVille = new Ville("Paris");
		Ville barceloneVille = new Ville("Barcelone");
		Ville francfortVille = new Ville("Francfort");
		//----------------------------------------------------------------------------------
		Aeroport cdgAeroport = new Aeroport("Charles de Gaules", parisVille);
		cdgAeroport.add_destination(barceloneVille);
		cdgAeroport.add_destination(francfortVille);
		Aeroport orlyAeroport = new Aeroport("Orly", parisVille);
		orlyAeroport.add_destination(francfortVille);
		Aeroport bepAeroport = new Aeroport("Barcelone-El Prat", barceloneVille);
		bepAeroport.add_destination(parisVille);
		Aeroport francfortAeroport = new Aeroport("Francfort-Hahn", francfortVille);
		francfortAeroport.add_destination(barceloneVille);
		//----------------------------------------------------------------------------------
		
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
		airFranceCompagnie.creer_vol(cdgAeroport, heure_depart, bepAeroport, heure_arrive);
		System.out.println("-----------------------------------------------------------------");
		airFranceCompagnie.creer_vol(bepAeroport, heure_depart2, orlyAeroport, heure_arrive2);
		System.out.println("-----------------------------------------------------------------");
		lufthansaCompagnie.creer_vol(francfortAeroport, heure_depart, bepAeroport, heure_arrive);
		//----------------------------------------------------------------------------------
	}

	
}