import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import gestion_vol.Vol;

public class Start{
	public static void main(String[] args){
		String compagnie = "Air France ";
		ZoneId paris = ZoneId.of("Europe/Paris");
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm, dd MMM yyyy");
		//----------------------------------------------------------------------------------
		LocalDateTime dep = LocalDateTime.of(2020, Month.OCTOBER, 20, 23, 00);
		ZonedDateTime depart = dep.atZone(paris);
		LocalDateTime arr = LocalDateTime.of(2020, Month.OCTOBER, 21, 00, 30);
		ZonedDateTime arrive = arr.atZone(paris);
		Vol a = new Vol(depart, arrive);
		//-----------------------------------------------------------------------------------
		LocalDateTime dep2 = LocalDateTime.of(2020, Month.OCTOBER, 21, 16, 00);
		ZonedDateTime depart2 = dep2.atZone(paris);
		LocalDateTime arr2 = LocalDateTime.of(2020, Month.OCTOBER, 21, 21, 30);
		ZonedDateTime arrive2 = arr2.atZone(paris);
		Vol b = new Vol(depart2, arrive2);
		b.mise_a_jour();
		//----------------------------------------------------------------------------------
		System.out.println("Flight id : " + compagnie + a.get_ID());
		System.out.println("Time zone : " + paris);
		System.out.println("Departure : " + format.format(dep) + " " + depart.getZone());
		System.out.println("Arrival : " + format.format(arr) + " " + arrive.getZone());
		System.out.println("Duration : " + a.get_Duree());
		System.out.println("---------------------------------------------------------------");
		System.out.println("Flight id : " + compagnie + b.get_ID());
		System.out.println("Time zone : " + paris);
		System.out.println("Departure : " + format.format(dep2) + " " + depart2.getZone());
		System.out.println("Arrival : " + format.format(arr2) + " " + arrive2.getZone());
		System.out.println("Duration : " + b.get_Duree());
	}

	
}