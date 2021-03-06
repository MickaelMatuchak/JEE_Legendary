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
    private Double defense = 14.0;

    private int atkStuff = 0;
    private int defStuff = 0;

    private String idCasque;
    private String idArmure;
    private String idSabre;

    private String imgCasque = null;
    private String imgArmure = null;
    private String imgSabre = null;

    private String rareteCasque = null;
    private String rareteArmure = null;
    private String rareteSabre = null;

    private int placeLibre = 10;

    private String idInventaire1 = null;
    private String idInventaire2 = null;
    private String idInventaire3 = null;
    private String idInventaire4 = null;
    private String idInventaire5 = null;
    private String idInventaire6 = null;
    private String idInventaire7 = null;
    private String idInventaire8 = null;
    private String idInventaire9 = null;
    private String idInventaire10 = null;


    public Personnage(String proprietaire, String pseudo, Character sexe, String classe, Integer level) {
        this.id = new ObjectId().toString();
        this.proprietaire = proprietaire;
        this.pseudo = pseudo;
        this.setSexe(sexe);
        this.setClasse(classe);
        this.setLevel(level);

        this.setPuissance();
        this.setDefense();
        this.setMaitrise();
        this.setEndurance();
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

        urlImg = urlImg.replaceAll("\\s", "-");
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
        this.maitrise = Math.round(this.maitrise * (level * ratioAttByClass.get(getIndexClasses())) * 10.0) / 10.0;
    }

    public Double getEndurance() {
        return endurance;
    }

    public void setEndurance() {
        this.endurance = Math.round(this.endurance * (level * ratioDefByClass.get(getIndexClasses())) * 10.0) / 10.0;
    }

    public Double getPuissance() {
        return puissance;
    }

    public void setPuissance() {
        this.puissance = Math.round(this.puissance * (level * ratioAttByClass.get(getIndexClasses())) * 10.0) / 10.0;
    }

    public Double getDefense() {
        return defense;
    }

    public void setDefense() {
        this.defense = Math.round(this.defense * (level * ratioDefByClass.get(getIndexClasses())) * 10.0) / 10.0;
    }

    public Integer getIndexClasses() {
        int index = 0;

        for (int i = 0; i < allClasses.size(); i++)
            if (allClasses.get(i) == this.classe)
                index = i;

        return index;
    }

    public int getPlaceLibre() {
        return placeLibre;
    }

    public void setPlaceLibre(int placeLibre) {
        this.placeLibre = placeLibre;
    }

    public String getIdInventaire1() {
        return idInventaire1;
    }

    public void setIdInventaire1(String idInventaire1) {
        this.idInventaire1 = idInventaire1;
    }

    public String getIdInventaire2() {
        return idInventaire2;
    }

    public void setIdInventaire2(String idInventaire2) {
        this.idInventaire2 = idInventaire2;
    }

    public String getIdInventaire3() {
        return idInventaire3;
    }

    public void setIdInventaire3(String idInventaire3) {
        this.idInventaire3 = idInventaire3;
    }

    public String getIdInventaire4() {
        return idInventaire4;
    }

    public void setIdInventaire4(String idInventaire4) {
        this.idInventaire4 = idInventaire4;
    }

    public String getIdInventaire5() {
        return idInventaire5;
    }

    public void setIdInventaire5(String idInventaire5) {
        this.idInventaire5 = idInventaire5;
    }

    public String getIdInventaire6() {
        return idInventaire6;
    }

    public void setIdInventaire6(String idInventaire6) {
        this.idInventaire6 = idInventaire6;
    }

    public String getIdInventaire7() {
        return idInventaire7;
    }

    public void setIdInventaire7(String idInventaire7) {
        this.idInventaire7 = idInventaire7;
    }

    public String getIdInventaire8() {
        return idInventaire8;
    }

    public void setIdInventaire8(String idInventaire8) {
        this.idInventaire8 = idInventaire8;
    }

    public String getIdInventaire9() {
        return idInventaire9;
    }

    public void setIdInventaire9(String idInventaire9) {
        this.idInventaire9 = idInventaire9;
    }

    public String getIdInventaire10() {
        return idInventaire10;
    }

    public void setIdInventaire10(String idInventaire10) {
        this.idInventaire10 = idInventaire10;
    }

    public void addInventaire(String idItem) {
        if (this.idInventaire1 == null) {
            this.idInventaire1 = idItem;
        } else if (this.idInventaire2 == null) {
            this.idInventaire2 = idItem;
        } else if (this.idInventaire3 == null) {
            this.idInventaire3 = idItem;
        } else if (this.idInventaire4 == null) {
            this.idInventaire4 = idItem;
        } else if (this.idInventaire5 == null) {
            this.idInventaire5 = idItem;
        } else if (this.idInventaire6 == null) {
            this.idInventaire6 = idItem;
        } else if (this.idInventaire7 == null) {
            this.idInventaire7 = idItem;
        } else if (this.idInventaire8 == null) {
            this.idInventaire8 = idItem;
        } else if (this.idInventaire9 == null) {
            this.idInventaire9 = idItem;
        } else if (this.idInventaire10 == null) {
            this.idInventaire10 = idItem;
        } else {
            this.placeLibre++;
        }

        this.placeLibre--;
    }

    public void deletePlaceInventaire(int placeId) {
        if (placeId == 1 && idInventaire1 != null) {
            this.idInventaire1 = null;
            this.placeLibre++;
        } else if (placeId == 2 && idInventaire2 != null) {
            this.idInventaire2 = null;
            this.placeLibre++;
        } else if (placeId == 3 && idInventaire3 != null) {
            this.idInventaire3 = null;
            this.placeLibre++;
        } else if (placeId == 4 && idInventaire4 != null) {
            this.idInventaire4 = null;
            this.placeLibre++;
        } else if (placeId == 5 && idInventaire5 != null) {
            this.idInventaire5 = null;
            this.placeLibre++;
        } else if (placeId == 6 && idInventaire6 != null) {
            this.idInventaire6 = null;
            this.placeLibre++;
        } else if (placeId == 7 && idInventaire7 != null) {
            this.idInventaire7 = null;
            this.placeLibre++;
        } else if (placeId == 8 && idInventaire8 != null) {
            this.idInventaire8 = null;
            this.placeLibre++;
        } else if (placeId == 9 && idInventaire9 != null) {
            this.idInventaire9 = null;
            this.placeLibre++;
        } else if (placeId == 10 && idInventaire10 != null) {
            this.idInventaire10 = null;
            this.placeLibre++;
        }
    }

    public String getImgCasque() {
        return imgCasque;
    }

    public void setImgCasque(String imgCasque) {
        this.imgCasque = imgCasque;
    }

    public String getImgArmure() {
        return imgArmure;
    }

    public void setImgArmure(String imgArmure) {
        this.imgArmure = imgArmure;
    }

    public String getImgSabre() {
        return imgSabre;
    }

    public void setImgSabre(String imgSabre) {
        this.imgSabre = imgSabre;
    }

    public String getRareteCasque() {
        return rareteCasque;
    }

    public void setRareteCasque(String rareteCasque) {
        this.rareteCasque = rareteCasque;
    }

    public String getRareteArmure() {
        return rareteArmure;
    }

    public void setRareteArmure(String rareteArmure) {
        this.rareteArmure = rareteArmure;
    }

    public String getRareteSabre() {
        return rareteSabre;
    }

    public void setRareteSabre(String rareteSabre) {
        this.rareteSabre = rareteSabre;
    }

    public int getAtkStuff() {
        return atkStuff;
    }

    public void setAtkStuff(int atkStuff) {
        this.atkStuff = atkStuff;
    }

    public int getDefStuff() {
        return defStuff;
    }

    public void setDefStuff(int defStuff) {
        this.defStuff = defStuff;
    }
}
