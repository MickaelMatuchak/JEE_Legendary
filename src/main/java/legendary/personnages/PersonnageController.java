package legendary.personnages;

import legendary.items.Item;
import legendary.items.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class PersonnageController {

    @Autowired
    private PersonnageRepository personnageRepository;
    @Autowired
    private ItemRepository itemRepository;

    // Liste des personnages
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        List<Personnage> personnages = this.personnageRepository.findAll();

        model.addAttribute("personnages", personnages);
        return "accueil";
    }

    @RequestMapping(value = "/personnages/{pseudo}", method = RequestMethod.GET)
    public String detailPersonnage(@PathVariable String pseudo, Model model) {
        Personnage personnage = this.personnageRepository.findByPseudo(pseudo);

        model.addAttribute("personnage", personnage);
        return "detail-personnage";
    }

    @RequestMapping(value = "/personnages/add", method = RequestMethod.GET)
    public String formAddPersonnage() {
        return "form-add-personnage";
    }

    @RequestMapping(value = "/personnages/add", method = RequestMethod.POST)
    public String addPersonnage(Model model, @RequestParam("proprietaire") String proprietaire, @RequestParam("pseudo") String pseudo, @RequestParam("sexe") Character sexe, @RequestParam("classe") String classe, @RequestParam("level") Integer level) {
        Personnage fetchPersonnage = this.personnageRepository.findByPseudo(pseudo);
        Personnage personnage = new Personnage(proprietaire, pseudo, sexe, classe, level);

        if (fetchPersonnage == personnage)
            return "erreur";

        personnageRepository.save(personnage);
        model.addAttribute("personnage", personnage);
        return "detail-personnage";
    }

    @RequestMapping(value = "/proprietaires/{proprietaire}", method = RequestMethod.GET)
    public String listPersonnagesByUser(@PathVariable String proprietaire, Model model) {
        List<Personnage> personnages = this.personnageRepository.findAllByProprietaire(proprietaire);

        model.addAttribute("personnages", personnages);
        model.addAttribute("proprietaire", proprietaire);

        return "list-personnages-user";
    }

    @RequestMapping(value = "/personnages/delete/{pseudo}", method = RequestMethod.GET)
    public String deletePersonnage(@PathVariable String pseudo) {
        Personnage personnage = this.personnageRepository.findByPseudo(pseudo);
        this.personnageRepository.delete(personnage);

        return "redirect";
    }

    @RequestMapping(value = "/personnages/modify/{pseudo}", method = RequestMethod.GET)
    public String formModifyPersonnage(@PathVariable String pseudo, Model model) {
        Personnage personnage = this.personnageRepository.findByPseudo(pseudo);

        model.addAttribute(personnage);

        return "form-modify-personnage";
    }

    @RequestMapping(value = "/personnages/modify/{pseudo}", method = RequestMethod.POST)
    public String modifyPersonnage(@PathVariable String pseudo, @RequestParam("proprietaire") String proprietaire, @RequestParam("pseudo") String newPseudo, @RequestParam("sexe") Character sexe, @RequestParam("classe") String classe, @RequestParam("level") Integer level) {
        Personnage personnage = this.personnageRepository.findByPseudo(pseudo);

        personnage.setProprietaire(proprietaire);
        personnage.setPseudo(newPseudo);
        personnage.setSexe(sexe);
        personnage.setClasse(classe);
        personnage.setLevel(level);

        this.personnageRepository.save(personnage);

        return "redirect";
    }

    @RequestMapping(value = "/personnages/{pseudo}/items/add", method = RequestMethod.GET)
    public String addItemPersonnage(Model model, @PathVariable String pseudo) {
        Personnage personnage = this.personnageRepository.findByPseudo(pseudo);

        List<Item> items = this.itemRepository.findAll();

        model.addAttribute(personnage);
        model.addAttribute(items);

        return "add-inventaire-item";
    }

    @RequestMapping(value = "/personnages/{pseudo}/items/delete/{id}", method = RequestMethod.GET)
    public String addItemPersonnage(@PathVariable String pseudo, @PathVariable String id) {
        Personnage personnage = this.personnageRepository.findByPseudo(pseudo);

        String methodToCall = "setIdInventaire" + id;

        try {
            personnage.getClass().getMethod(methodToCall, null);
            personnage.setPlaceLibre(personnage.getPlaceLibre() - 1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        personnageRepository.save(personnage);

        return "redirect";
    }
}
