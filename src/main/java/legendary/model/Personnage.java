package legendary.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.HashMap;

public class Personnage implements Serializable {
    @Id
    private long id;
    private String pseudo;
    private Character sexe;
    private String classe;
    private String level;
    private HashMap<String, Integer> caracteristiques;
    private HashMap<String, Equipement> equipement;

    public Personnage(long id, String pseudo, Character sexe, String classe, String level, HashMap<String, Integer> caracteristiques, HashMap<String, Equipement> equipement) {
        this.id = id;
        this.pseudo = pseudo;
        this.sexe = sexe;
        this.classe = classe;
        this.level = level;
        this.caracteristiques = caracteristiques;
        this.equipement = equipement;
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
        this.sexe = sexe;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public HashMap<String, Integer> getCaracteristiques() {
        return caracteristiques;
    }

    public void setCaracteristiques(HashMap<String, Integer> caracteristiques) {
        this.caracteristiques = caracteristiques;
    }

    public HashMap<String, Equipement> getEquipement() {
        return equipement;
    }

    public void setEquipement(HashMap<String, Equipement> equipement) {
        this.equipement = equipement;
    }
}
