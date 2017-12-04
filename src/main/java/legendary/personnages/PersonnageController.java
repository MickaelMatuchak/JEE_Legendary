package legendary.personnages;

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
        Personnage personnage = new Personnage(proprietaire, pseudo, sexe, classe, level);
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
}
