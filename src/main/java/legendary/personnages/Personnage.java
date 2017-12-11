package legendary.personnages;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;

public class Personnage implements Serializable {
    final ArrayList<Double> ratioDefByClass = new ArrayList<>(Arrays.asList(1.0, 0.9, 1.1, 1.5, 1.1, 1.25, 1.3, 1.2));
    final ArrayList<Double> ratioAttByClass = new ArrayList<>(Arrays.asList(1.0, 1.1, 0.9, 0.5, 0.9, 0.75, 0.7, 0.8));
    final ArrayList<String> allClasses = new ArrayList<>(Arrays.asList("Trooper", "Contrebandier", "Chevalier Jedi", "Jedi Consulaire", "Chasseur de Primes", "Guerrier Sith", "Agent Impérial", "Inquisiteur Sith"));

    @Id
    private String id;
    private String proprietaire;
    private String pseudo;
    private Character sexe;
    private String classe;
    private Integer level;
    private String urlImage;

    private Double maitrise = 10.0;
    private Double endurance = 12.0;
    private Double puissance = 8.0;
    private Double defense = 12.0;

    private String idCasque;
    private String idArmure;
    private String idSabre;

    public Personnage(String proprietaire, String pseudo, Character sexe, String classe, Integer level) {
        this.id = new ObjectId().toString();
        this.proprietaire = proprietaire;
        this.pseudo = pseudo;
        this.setSexe(sexe);
        this.setClasse(classe);
        this.setLevel(level);

        this.setMaitrise();
        this.setEndurance();
        this.setPuissance();
        this.setDefense();
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

        this.classe = classe;
        if (classe == "Trooper" || classe == "Contrebandier" || classe == "Chevalier Jedi" || classe == "Jedi Consulaire" || classe == "Chasseur de Primes" || classe == "Guerrier Sith" || classe == "Agent Impérial" || classe == "Inquisiteur Sith")
            this.classe = classe;

        String urlImg = classe.toLowerCase();
        urlImg = Normalizer.normalize(urlImg, Normalizer.Form.NFD);
        urlImg = urlImg.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

        urlImg = urlImg.replaceAll("\\s","-" );
        this.setUrlImage(urlImg);
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        if (level >= 1 && level <= 50)
        this.level = level;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getIdCasque() {
        return idCasque;
    }

    public void setIdCasque(String idCasque) {
        this.idCasque = idCasque;
    }

    public String getIdArmure() {
        return idArmure;
    }

    public void setIdArmure(String idArmure) {
        this.idArmure = idArmure;
    }

    public String getIdSabre() {
        return idSabre;
    }

    public void setIdSabre(String idSabre) {
        this.idSabre = idSabre;
    }

    public Double getMaitrise() {
        return maitrise;
    }

    public void setMaitrise() {
        this.maitrise = level * ratioAttByClass.get(getIndexClasses());
    }

    public Double getEndurance() {
        return endurance;
    }

    public void setEndurance() {
        this.endurance = level * ratioDefByClass.get(getIndexClasses());
    }

    public Double getPuissance() {
        return puissance;
    }

    public void setPuissance() {
        this.puissance = level * ratioAttByClass.get(getIndexClasses());
    }

    public Double getDefense() {
        return defense;
    }

    public void setDefense() {
        this.defense = level * ratioDefByClass.get(getIndexClasses());
    }

    public Integer getIndexClasses() {
        int index = 0;

        for (int i = 0; i < allClasses.size(); i++)
            if (allClasses.get(i) == this.classe)
                index = i;

        return index;
    }
}
