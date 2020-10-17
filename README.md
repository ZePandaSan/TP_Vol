# TP_Vol

## Compiler

Se placer à la racine puis faire : `./gradlew build` puis `./gradlew run` 

## A faire

- [x] Implémentation des class et constructeurs

- [x] Gérer les exceptions de dates 

- [x] Implémentation de la durée 

- [ ] ID de vol unique

- [ ] Relier la compagnie au vol 

- [ ] Relier l'aéroport au vol

- [ ] Relier la ville aux aéroports

- [ ] Gérer les escales

## Problèmes rencontrés

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

Utilisation du type `duration` qui prend en argument les deux ZonedDateTime. 
Duration va renvoyer des caractères inutiles qui dont supprimer grâce à `replaceAll`.

```java
public String get_Duree(){ 
	String duree=Duration.between(this.depart, this.arrivee).toString();
	duree=(duree == null) ? null : duree.replaceAll("PT", "");
	duree=(duree == null) ? null : duree.replaceAll("H", ":");
	duree = (duree == null) ? null : duree.replaceAll("M", "");
	return duree;
}
```


