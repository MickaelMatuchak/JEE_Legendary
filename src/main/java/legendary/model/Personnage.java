package legendary.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.HashMap;

public class Personnage implements Serializable {
    public enum Caracteristique {Vie, Mana, Defense, Attaque;}
    public enum Type {Arme, Casque, Armure, Gant, Ceinture, Pantalon, Botte, Anneau, Collier;}
    public enum Classe {Barbare, Magicien, Prêtre, Chasseur, Voleur, Druide;}

    @Id
    private long id;
    private String pseudo;
    private Character sexe;
    // private Enum<Classe> classe;
    private String classe;
    private Integer level;
    private HashMap<Enum<Caracteristique>, Integer> caracteristiques;
    private HashMap<Enum<Type>, Equipement> equipement;

    public Personnage(long id, String pseudo, Character sexe, String classe, Integer level) {
        this.id = id;
        this.pseudo = pseudo;
        this.setSexe(sexe);
        this.classe = classe;
        this.setLevel(level);
        this.caracteristiques = null;
        this.equipement = null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Character getSexe() {
        return sexe;
    }

    public void setSexe(Character sexe) {
        if (sexe == 'M' || sexe == 'F')
            this.sexe = sexe;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        if (level >= 1 && level <= 50)
            this.level = level;
    }

    public HashMap<Enum<Caracteristique>, Integer> getCaracteristiques() {
        return caracteristiques;
    }

    public void setCaracteristiques(HashMap<Enum<Caracteristique>, Integer> caracteristiques) {
        this.caracteristiques = caracteristiques;
    }

    public HashMap<Enum<Type>, Equipement> getEquipement() {
        return equipement;
    }

    public void setEquipement(HashMap<Enum<Type>, Equipement> equipement) {
        this.equipement = equipement;
    }
}
