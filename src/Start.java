//Wassim SAIDANE - Aurélien Authier

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import gestion_vol.Aeroport;
import gestion_vol.Compagnie;
import gestion_vol.Escale;
import gestion_vol.Ville;
import reservation.Client;
import reservation.Passager;

public class Start {
	public static void main(String[] args) {
		System.out.println("Wassim SAIDANE - Aurélien Authier");
		System.out.println("------------------------------------------------------------");
		//-----------------------------------------------------------------------------------
		Compagnie airFranceCompagnie = new Compagnie("Air France");
		Compagnie lufthansaCompagnie = new Compagnie("Luftensa");
		// ----------------------------------------------------------------------------------
		ZoneId fuseauParis = ZoneId.of("Europe/Paris");
		// ----------------------------------------------------------------------------------
		Ville parisVille = new Ville("Paris");
		Ville barceloneVille = new Ville("Barcelone");
		Ville francfortVille = new Ville("Francfort");
		// ----------------------------------------------------------------------------------
		Aeroport cdgAeroport = new Aeroport("Charles de Gaules", parisVille);
		cdgAeroport.add_destination(barceloneVille);
		cdgAeroport.add_destination(francfortVille);
		Aeroport orlyAeroport = new Aeroport("Orly", parisVille);
		orlyAeroport.add_destination(francfortVille);
		Aeroport bepAeroport = new Aeroport("Barcelone-El Prat", barceloneVille);
		bepAeroport.add_destination(parisVille);
		Aeroport francfortAeroport = new Aeroport("Francfort-Hahn", francfortVille);
		francfortAeroport.add_destination(barceloneVille);
		// ----------------------------------------------------------------------------------
		LocalDateTime dep = LocalDateTime.of(2020, Month.OCTOBER, 21, 20, 00);
		LocalDateTime arr = LocalDateTime.of(2020, Month.OCTOBER, 21, 23, 00);
		LocalDateTime escd1 = LocalDateTime.of(2020, Month.OCTOBER, 21, 21, 00);
		LocalDateTime escd2 = LocalDateTime.of(2020, Month.OCTOBER, 21, 22, 00);
		LocalDateTime dep2 = LocalDateTime.of(2020, Month.OCTOBER, 21, 23, 00);
		LocalDateTime arr2 = LocalDateTime.of(2020, Month.OCTOBER, 22, 02, 00);
		// ----------------------------------------------------------------------------------
		ZonedDateTime heure_depart = dep.atZone(fuseauParis);
		ZonedDateTime heure_arrive = arr.atZone(fuseauParis);
		ZonedDateTime depart_escale = escd1.atZone(fuseauParis);
		ZonedDateTime arrivee_escale = escd2.atZone(fuseauParis);
		ZonedDateTime heure_depart2 = dep2.atZone(fuseauParis);
		ZonedDateTime heure_arrive2 = arr2.atZone(fuseauParis);
		// -----------------------------------------------------------------------------------
		airFranceCompagnie.creer_vol(cdgAeroport, heure_depart, bepAeroport, heure_arrive);
		airFranceCompagnie.creer_vol(bepAeroport, heure_depart2, orlyAeroport, heure_arrive2);
		lufthansaCompagnie.creer_vol(francfortAeroport, heure_depart, bepAeroport, heure_arrive);
		// -----------------------------------------------------------------------------------
		Escale francfortEscale = new Escale(arrivee_escale, depart_escale, francfortAeroport, airFranceCompagnie.get_vol(1));
		airFranceCompagnie.add_escale(francfortEscale, 1);
		// -----------------------------------------------------------------------------------
		Client moi = new Client("Wassim");
		// -----------------------------------------------------------------------------------
		Passager moi_meme = new Passager ("Wassim");
		Passager lui = new Passager ("Aurélien");
		// -----------------------------------------------------------------------------------
		moi.creer_reservation(heure_depart, moi, airFranceCompagnie.get_vol(1), moi_meme);
		moi.creer_reservation(heure_depart, moi, airFranceCompagnie.get_vol(1), lui);
		// -----------------------------------------------------------------------------------
		airFranceCompagnie.print_all();
		lufthansaCompagnie.print_all();
		

	}

}