# TP_Vol

## Compiler

Se placer à la racine puis faire : `./gradlew build` puis `./gradlew run` 

## A faire

- [x] Implémentation des class et constructeurs

- [ ] Gérer les exceptions de dates (en cours)

- [ ] Implémentation de la durée 

- [ ] ID de vol unique

- [ ] Relier la compagnie au vol 

- [ ] Relier l'aéroport au vol

- [ ] Relier la ville aux aéroports

- [ ] Gérer les escales

## Problème rencontré

### Manipuler des dates

- Utilisation du type `ZonedDateTime`



### Gestion des exceptions sur la date 

- [X] Date d'arrivée antérieure à celle de départ
- [X] Date d'arrivée égal à celle d'arrivée

```java
if (this.arrivee.isBefore(this.depart)){
	throw new IllegalArgumentException("Arrival cannot be prior to departure");
}
if (this.depart.equals(this.arrivee)){
	throw new IllegalArgumentException("Arrival cannot be at the same time as departure");
	}
```

### Implémentation de la durée

- [X] Durée simple (même jour, heure de départ < heure d'arrivée, minute de départ < )

```java
public String get_Duree(){
		int duree_heure=this.arrivee.getHour()-this.depart.getHour();
		int duree_minute=this.arrivee.getMinute()-this.depart.getMinute();
		return duree_heure+":"+duree_minute;
}
```


