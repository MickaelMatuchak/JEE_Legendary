package legendary.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.HashMap;


public class Equipement implements Serializable {
    public enum Type {Arme, Casque, Armure, Gant, Ceinture, Pantalon, Botte, Anneau, Collier;}
    public enum Rarete {Commun, Rare, Epique, Legendaire;}

    @Id
    private long id;
    private String nom;
    private String description;
    // private Enum<Type> type;
    private String type;
    // private Enum<Rarete> rarete;
    private String rarete;
    private Integer levelRequis;
    // private HashMap<String, Integer> caracteristiques;

    /*
    public Equipement(long id, String nom, String description, Enum<Type> type, Enum<Rarete> rarete, Integer levelRequis, HashMap<String, Integer> caracteristiques) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.type = type;
        this.rarete = rarete;
        this.levelRequis = levelRequis;
        this.caracteristiques = caracteristiques;
    }
    */

    public Equipement(long id, String nom, String description, String type, String rarete, Integer levelRequis) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.type = type;
        this.rarete = rarete;
        this.levelRequis = levelRequis;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRarete() {
        return rarete;
    }

    public void setRarete(String rarete) {
        this.rarete = rarete;
    }

    public Integer getLevelRequis() {
        return levelRequis;
    }

    public void setLevelRequis(Integer levelRequis) {
        this.levelRequis = levelRequis;
    }

    /*
    public HashMap<String, Integer> getCaracteristiques() {
        return caracteristiques;
    }

    public void setCaracteristiques(HashMap<String, Integer> caracteristiques) {
        this.caracteristiques = caracteristiques;
    }
    */
}
