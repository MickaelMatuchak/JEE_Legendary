package legendary.personnages;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Personnage implements Serializable {
    @Id
    private long id;
    private String proprietaire;
    private String pseudo;
    private Character sexe;
    private String classe;
    private Integer level;

    public Personnage(long id, String proprietaire, String pseudo, Character sexe, String classe, Integer level) {
        this.id = id;
        this.proprietaire = proprietaire;
        this.pseudo = pseudo;
        this.sexe = sexe;
        this.classe = classe;
        this.level = level;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        this.level = level;
    }
}
