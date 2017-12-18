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

        Item item1 = new Item("", "", "", "", 0, (float) 0, 0, "");
        Item item2 = new Item("", "", "", "", 0, (float) 0, 0, "");
        Item item3 = new Item("", "", "", "", 0, (float) 0, 0, "");
        Item item4 = new Item("", "", "", "", 0, (float) 0, 0, "");
        Item item5 = new Item("", "", "", "", 0, (float) 0, 0, "");
        Item item6 = new Item("", "", "", "", 0, (float) 0, 0, "");
        Item item7 = new Item("", "", "", "", 0, (float) 0, 0, "");
        Item item8 = new Item("", "", "", "", 0, (float) 0, 0, "");
        Item item9 = new Item("", "", "", "", 0, (float) 0, 0, "");
        Item item10 = new Item("", "", "", "", 0, (float) 0, 0, "");

        if (personnage.getIdInventaire1() != null) {
            item1 = this.itemRepository.findById(personnage.getIdInventaire1());
        }
        if (personnage.getIdInventaire2() != null) {
            item2 = this.itemRepository.findById(personnage.getIdInventaire2());
        }
        if (personnage.getIdInventaire3() != null) {
            item3 = this.itemRepository.findById(personnage.getIdInventaire3());
        }
        if (personnage.getIdInventaire4() != null) {
            item4 = this.itemRepository.findById(personnage.getIdInventaire4());
        }
        if (personnage.getIdInventaire5() != null) {
            item5 = this.itemRepository.findById(personnage.getIdInventaire5());
        }
        if (personnage.getIdInventaire6() != null) {
            item6 = this.itemRepository.findById(personnage.getIdInventaire6());
        }
        if (personnage.getIdInventaire7() != null) {
            item7 = this.itemRepository.findById(personnage.getIdInventaire7());
        }
        if (personnage.getIdInventaire8() != null) {
            item8 = this.itemRepository.findById(personnage.getIdInventaire8());
        }
        if (personnage.getIdInventaire9() != null) {
            item9 = this.itemRepository.findById(personnage.getIdInventaire9());
        }
        if (personnage.getIdInventaire10() != null) {
            item10 = this.itemRepository.findById(personnage.getIdInventaire10());
        }

        model.addAttribute("item1", item1);
        model.addAttribute("item2", item2);
        model.addAttribute("item3", item3);
        model.addAttribute("item4", item4);
        model.addAttribute("item5", item5);
        model.addAttribute("item6", item6);
        model.addAttribute("item7", item7);
        model.addAttribute("item8", item8);
        model.addAttribute("item9", item9);
        model.addAttribute("item10", item10);

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
    public String fetchAllItems(Model model, @PathVariable String pseudo) {
        Personnage personnage = this.personnageRepository.findByPseudo(pseudo);

        List<Item> items = this.itemRepository.findAll();

        model.addAttribute(personnage);
        model.addAttribute("items", items);

        return "add-inventaire-item";
    }

    @RequestMapping(value = "/personnages/{pseudo}/items/add/{id}", method = RequestMethod.GET)
    public String addItemPersonnage(Model model, @PathVariable String pseudo, @PathVariable String id) {
        Personnage personnage = this.personnageRepository.findByPseudo(pseudo);

        personnage.addInventaire(id);

        personnageRepository.save(personnage);

        return "redirect";
    }

    @RequestMapping(value = "/personnages/{pseudo}/items/delete/{id}", method = RequestMethod.GET)
    public String deleteItemPersonnage(@PathVariable String pseudo, @PathVariable String id) {
        Personnage personnage = this.personnageRepository.findByPseudo(pseudo);

        personnage.deletePlaceInventaire(Integer.parseInt(id));

        personnageRepository.save(personnage);

        return "redirect";
    }
}
