package legendary.controller;

import java.util.List;

import legendary.model.Equipement;
import legendary.model.Personnage;
import legendary.repository.EquipementRepository;
import legendary.repository.PersonnageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LegendaryController {

    @Autowired
    private PersonnageRepository personnageRepository;
    @Autowired
    private EquipementRepository equipementRepository;

    @RequestMapping("/personnages")
    public List<Personnage> personnages() {
        return this.personnageRepository.findAll();
    }

    @RequestMapping("/equipements")
    public List<Equipement> equipements() {
        return this.equipementRepository.findAll();
    }
}
