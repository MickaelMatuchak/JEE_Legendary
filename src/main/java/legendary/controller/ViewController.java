package legendary.controller;

import legendary.repository.EquipementRepository;
import legendary.repository.PersonnageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class ViewController {

    @Autowired
    private PersonnageRepository personnageRepository;
    @Autowired
    private EquipementRepository equipementRepository;

    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("name", "margueritte");
        return "index";
    }
}
