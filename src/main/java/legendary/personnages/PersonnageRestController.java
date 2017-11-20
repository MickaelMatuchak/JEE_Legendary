package legendary.personnages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonnageRestController {

    @Autowired
    private PersonnageRepository personnageRepository;

    @RequestMapping(value = "/personnages", method = RequestMethod.GET)
    public List<Personnage> listPersonnages() {
        return this.personnageRepository.findAll();
    }

    @RequestMapping(value = "/personnages/{id}", method = RequestMethod.GET)
    public Personnage detailPersonnage(@PathVariable long id) {
        return this.personnageRepository.findOne(id);
    }
}
