package legendary.personnages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonnageRestController {

    @Autowired
    private PersonnageRepository personnageRepository;

    // Personnage

    @RequestMapping("/personnages")
    public List<Personnage> personnages() {
        return this.personnageRepository.findAll();
    }

    @RequestMapping("/personnages/{id}")
    public Personnage personnage(@PathVariable long id) {
        return this.personnageRepository.findOne(id);
    }
}
