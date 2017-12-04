package legendary.personnages;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Personnage implements Serializable {
    @Id
    private String id;
    private String proprietaire;
    private String pseudo;
    private Character sexe;
    private String classe;
    private Integer level;

    public Personnage(String proprietaire, String pseudo, Character sexe, String classe, Integer level) {
        this.id = new ObjectId().toString();
        this.proprietaire = proprietaire;
        this.pseudo = pseudo;
        this.sexe = sexe;
        this.classe = classe;
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
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
        if (classe == "Trooper" || classe == "Contrebandier" || classe == "Chevalier Jedi" || classe == "Jedi Consulaire" || classe == "Chasseur de Primes" || classe == "Guerrier Sith" || classe == "Agent Impérial" || classe == "Inquisiteur Sith")
            this.classe = classe;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        if (level >= 1 && level <= 50)
        this.level = level;
    }
}
