package legendary.personnages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class PersonnageController {

    @Autowired
    private PersonnageRepository personnageRepository;

    // Liste des personnages
    @RequestMapping("/")
    public String index(Model model) {
        List<Personnage> personnages = this.personnageRepository.findAll();

        model.addAttribute("personnages", personnages);
        return "accueil";
    }

    @RequestMapping("/personnages/{id}")
    public String personnage(@PathVariable long id, Model model) {
        Personnage personnage = this.personnageRepository.findOne(id);

        model.addAttribute("personnage", personnage);
        return "detail-personnage";
    }
}
