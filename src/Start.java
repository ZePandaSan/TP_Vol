import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import gestion_vol.Vol;

public class Start{
	public static void main(String[] args){
		//----------------------------------------------------------------------------------
		String idvol="Air France 0004";                                              
		ZoneId paris = ZoneId.of("Europe/Paris");
		LocalDateTime dep = LocalDateTime.of(2020, Month.OCTOBER, 19, 20, 00);
		ZonedDateTime depart = dep.atZone(paris);
		LocalDateTime arr = LocalDateTime.of(2020, Month.OCTOBER, 20, 22, 30);
		ZonedDateTime arrive = arr.atZone(paris);
		Vol a = new Vol(idvol, depart, arrive);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm, dd MMM yyyy");
		//-----------------------------------------------------------------------------------
		System.out.println("Flight id : " + idvol);
		System.out.println("Time zone : " + paris);
		System.out.println("Departure : " + format.format(dep) + " " + depart.getZone());
		System.out.println("Arrival : " + format.format(arr) + " " + arrive.getZone());
		System.out.println("Duration : " + a.get_Duree());
	}
	
}