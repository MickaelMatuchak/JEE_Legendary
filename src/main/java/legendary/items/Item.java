package legendary.items;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Item implements Serializable {
    @Id
    private long id;
    private String nom;
    private String description;
    private String type;
    private String rarete;
    private Integer levelRequis;
    private Float tauxDrop;
    private String img;

    public Item(String nom, String description, String type, String rarete, Integer levelRequis, Float tauxDrop, String img) {
        this.nom = nom;
        this.description = description;
        this.type = type;
        this.rarete = rarete;
        this.levelRequis = levelRequis;
        this.tauxDrop = tauxDrop;
        this.img = img;
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

    public Float getTauxDrop() {
        return tauxDrop;
    }

    public void setTauxDrop(Float tauxDrop) {
        this.tauxDrop = tauxDrop;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}