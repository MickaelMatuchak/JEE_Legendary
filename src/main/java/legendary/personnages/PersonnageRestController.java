package legendary.personnages;

import legendary.items.Item;
import legendary.items.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonnageRestController {

    @Autowired
    private PersonnageRepository personnageRepository;

    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping(value = "/personnages", method = RequestMethod.GET)
    public List<Personnage> listPersonnages() {
        return this.personnageRepository.findAll();
    }

    @RequestMapping(value = "/personnages/{pseudo}", method = RequestMethod.GET)
    public Personnage detailPersonnage(@PathVariable String pseudo) {
        return this.personnageRepository.findByPseudo(pseudo);
    }

    @RequestMapping(value = "/personnages/delete/{pseudo}", method = RequestMethod.DELETE)
    public void deletePersonnage(@PathVariable String pseudo) {
        Personnage personnage = this.personnageRepository.findByPseudo(pseudo);
        this.personnageRepository.delete(personnage);
    }

    @RequestMapping(value = "/personnages/add", method = RequestMethod.POST)
    public Personnage addPersonnage(@RequestParam("proprietaire") String proprietaire, @RequestParam("pseudo") String pseudo, @RequestParam("sexe") Character sexe, @RequestParam("classe") String classe, @RequestParam("level") Integer level) {
        Personnage personnage = new Personnage(proprietaire, pseudo, sexe, classe, level);
        Item sabre = itemRepository.findByNom("Sabrolaser vert");
        personnage.setIdSabre(sabre.getId());
        personnage.setImgSabre(sabre.getImg());
        personnage.setRareteSabre(sabre.getRarete());

        Item armure = itemRepository.findByNom("Combinaison de Chewbacca");
        personnage.setIdArmure(armure.getId());
        personnage.setImgArmure(armure.getImg());
        personnage.setRareteArmure(armure.getRarete());

        Item casque = itemRepository.findByNom("Casque de Chewbacca");
        personnage.setIdCasque(casque.getId());
        personnage.setImgCasque(casque.getImg());
        personnage.setRareteCasque(casque.getRarete());

        personnage.setAtkStuff(casque.getAttaque() + armure.getAttaque() + sabre.getAttaque());
        personnage.setDefStuff(casque.getDefense() + armure.getDefense() + sabre.getDefense());

        this.personnageRepository.save(personnage);
        return personnage;
    }

    @RequestMapping(value = "/personnages/edit/{id}", method = RequestMethod.POST)
    public Personnage modifyPersonnage(@PathVariable String id, @RequestParam("proprietaire") String proprietaire, @RequestParam("pseudo") String pseudo, @RequestParam("sexe") Character sexe, @RequestParam("classe") String classe, @RequestParam("level") Integer level) {
        Personnage personnage = this.personnageRepository.findById(id);
        personnage.setProprietaire(proprietaire);
        personnage.setPseudo(pseudo);
        personnage.setSexe(sexe);
        personnage.setClasse(classe);
        personnage.setLevel(level);
        personnage.setId(id);

        this.personnageRepository.save(personnage);
        return personnage;
    }
}
