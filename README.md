# TP_Vol

## A faire
- [x] Implémentation des class et constructeurs
- [x] Implémentation de la durée
- [ ] Gérer les exceptions de dates (en cours)
- [ ] Relier la compagnie au vol 
- [ ] Relier l'aéroport au vol
- [ ] Relier la ville aux aéroports
- [ ] Gérer les escales


## Problème rencontré
### Manipuler des dates
- Utisisation du type `ZonedDateTime`
### Durée entre deux horaires avec des jours différent
```java
public String get_Duree(){
		int duree_heure=this.arrive.getHour()-this.depart.getHour();
		int duree_minute=this.arrive.getMinute()-this.depart.getMinute();
		if (duree_heure<0){
			duree_heure=(24-this.depart.getHour())+this.arrive.getHour();
		}
		if (duree_minute < 0) {
			duree_minute = (60 - this.depart.getMinute()) + this.arrive.getMinute();
			if(this.arrive.getDayOfMonth()==this.depart.getDayOfMonth())
			duree_heure--;
		}
		return duree_heure+":"+duree_minute;
	}
```

## Compiler

Se placer à la racine puis faire : `./gradlew build` puis `./gradlew run` 
