# TP_Vol

## Compiler

Se placer à la racine puis faire : `./gradlew build` puis `./gradlew run` 

## A faire
- [x] Implémentation des class et constructeurs
- [x] Implémentation de la durée
- [X] Gérer les exceptions de dates 
- [ ] Numéro de vol unique
- [ ] Relier la compagnie au vol (en cours)
- [ ] Relier l'aéroport au vol
- [ ] Relier la ville aux aéroports
- [ ] Gérer les escales


## Problème rencontré
### Manipuler des dates
- Utisisation du type `ZonedDateTime`
### Durée entre deux horaires avec des jours différent
```java
public String get_Duree(){
		int duree_heure=this.arrivee.getHour()-this.depart.getHour();
		int duree_minute=this.arrivee.getMinute()-this.depart.getMinute();
		if (duree_heure<0){
			duree_heure=(24-this.depart.getHour())+this.arrivee.getHour();
		}
		if (duree_minute < 0) {
			duree_minute = (60 - this.depart.getMinute()) + this.arrivee.getMinute();
			if(this.arrivee.getDayOfMonth()==this.depart.getDayOfMonth())
			duree_heure--;
		}
		if (this.arrivee.getDayOfMonth() != this.depart.getDayOfMonth() && this.arrivee.getHour() != this.depart
				.getHour() && this.arrivee.getMinute() != this.depart.getMinute())
				{
					duree_heure--;
				}


		return duree_heure+":"+duree_minute;
}
```
### Gestion des exceptions sur la date 
```java
if (this.arrivee.isBefore(this.depart)){
			throw new IllegalArgumentException("Arrival cannot be prior to departure");
		}
		if (this.depart.equals(this.arrivee)){
			throw new IllegalArgumentException("Arrival cannot be at the same time as departure");
		}
		if (this.depart.minus(2,ChronoUnit.DAYS).isSupported(ChronoUnit.DAYS) && this.depart.getHour()<this.arrivee.getHour()+1){
			throw new IllegalArgumentException("Flights over 23 hours are not supported");
		}
}
```
Nous n'avons pas réeussi à implémenter des durée supérieur à 22h59.

