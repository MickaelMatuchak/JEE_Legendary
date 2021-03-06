package legendary.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public String listItems(Model model) {
        List<Item> items = this.itemRepository.findAll();

        model.addAttribute("items", items);
        return "list-items";
    }

    @RequestMapping(value = "/items/{nom}", method = RequestMethod.GET)
    public String detailItem(@PathVariable String nom, Model model) {
        Item item = this.itemRepository.findByNom(nom);

        model.addAttribute("item", item);
        return "detail-item";
    }

    @RequestMapping(value = "/items/add", method = RequestMethod.GET)
    public String formAddItem() {
        return "form-add-item";
    }

    @RequestMapping(value = "/items/craft", method = RequestMethod.GET)
    public String formCraftItem(Model model) {

        List<Item> items = this.itemRepository.findAll();

        model.addAttribute("items", items);
        return "form-craft-item";
    }

    @RequestMapping(value = "/items/craft/result", method = RequestMethod.POST)
    public String formCraftItemResutl(Model model, @RequestParam String nom1, @RequestParam String nom2) {

        Item item1 = this.itemRepository.findByNom(nom1);
        Item item2 = this.itemRepository.findByNom(nom2);
        List<Item> items = this.itemRepository.findAll();

        //commun et/ou rare
        if(item1.getRarete().equals("commun") && item2.getRarete().equals("commun")) {
            int nb = (int) (Math.random() * 11);     //Pour un entier entre 0 et 10
            if (nb == 1) {
                Item item3 = this.itemRepository.findByRarete("commun");

                model.addAttribute("item3", item3);
            } else if (nb == 10) {
                Item item3 = this.itemRepository.findByRarete("epique");

                model.addAttribute("item3", item3);
            } else {
                Item item3 = this.itemRepository.findByRarete("rare");

                model.addAttribute("item3", item3);
            }
        }
        else if((item1.getRarete().equals("commun") && item2.getRarete().equals("rare")) || (item1.getRarete().equals("rare") && item2.getRarete().equals("commun"))){
            int nb = (int) (Math.random() * 11);     //Pour un entier entre 0 et 10
            if (nb > 7) {
                Item item3 = this.itemRepository.findByRarete("epique");

                model.addAttribute("item3", item3);
            }
            else {
                Item item3 = this.itemRepository.findByRarete("rare");

                model.addAttribute("item3", item3);
            }
        }
        //rare et/ou epique
        else if(item1.getRarete().equals("rare") && item2.getRarete().equals("rare")) {
            int nb = (int) (Math.random() * 11);     //Pour un entier entre 0 et 10
            if (nb == 1 || nb == 10) {
                Item item3 = this.itemRepository.findByRarete("rare");

                model.addAttribute("item3", item3);
            } else {
                Item item3 = this.itemRepository.findByRarete("epique");

                model.addAttribute("item3", item3);
            }
        }
        else if((item1.getRarete().equals("rare") && item2.getRarete().equals("epique")) || (item1.getRarete().equals("epique") && item2.getRarete().equals("rare"))) {
            int nb = (int) (Math.random() * 11);     //Pour un entier entre 0 et 10
            if (nb == 1) {
                Item item3 = this.itemRepository.findByRarete("legendaire");

                model.addAttribute("item3", item3);
            }
            else {
                Item item3 = this.itemRepository.findByRarete("epique");

                model.addAttribute("item3", item3);
            }
        }
        //commun et/ou epique
        else if((item1.getRarete().equals("epique") && item2.getRarete().equals("epique")) || (item1.getRarete().equals("commun") && item2.getRarete().equals("epique"))) {
            int nb = (int) (Math.random() * 11);     //Pour un entier entre 0 et 10
            if (nb < 3) {
                Item item3 = this.itemRepository.findByRarete("legendaire");

                model.addAttribute("item3", item3);
            }  else {
                Item item3 = this.itemRepository.findByRarete("epique");

                model.addAttribute("item3", item3);
            }
        }
        else if((item1.getRarete().equals("epique") && item2.getRarete().equals("commun")) || (item1.getRarete().equals("commun") && item2.getRarete().equals("epique"))){
            int nb = (int) (Math.random() * 11);     //Pour un entier entre 0 et 10
            if (nb > 4) {
                Item item3 = this.itemRepository.findByRarete("epique");

                model.addAttribute("item3", item3);
            }
            else {
                Item item3 = this.itemRepository.findByRarete("rare");

                model.addAttribute("item3", item3);
            }
        }
        else
        {
            String txt = "Impossible de crafter avec des objets légendaires !";
            model.addAttribute("erreur", txt);
        }

        model.addAttribute("items", items);
        model.addAttribute("item1", item1);
        model.addAttribute("item2", item2);

        return "form-craft-item";

    }

    @RequestMapping(value = "/items/add", method = RequestMethod.POST)
    public String addItem(Model model, @RequestParam("nom") String nom, @RequestParam("description") String description, @RequestParam("type") String type, @RequestParam("rarete") String rarete, @RequestParam("levelRequis") Integer levelRequis, @RequestParam("tauxDrop") Float tauxDrop, @RequestParam("durabilite") Integer durabilite, @RequestParam("img") String img, @RequestParam("attaque") Integer attaque, @RequestParam("defense") Integer defense) {
        Item item = new Item(nom, description, type, rarete, levelRequis, tauxDrop, durabilite, img, attaque, defense);
        itemRepository.save(item);
        model.addAttribute("item", item);
        return "detail-item";
    }

    @RequestMapping(value = "/items/edit/{id}", method = RequestMethod.GET)
    public String editItem(Model model, @PathVariable("id") String id) {
        Item item = this.itemRepository.findById(id);

        model.addAttribute("item", item);
        return "edit-item";
    }

    @RequestMapping(value = "/items/edit/{id}", method = RequestMethod.POST)
    public String editItem(Model model, @PathVariable("id") String id, @RequestParam("nom") String nom, @RequestParam("description") String description, @RequestParam("type") String type, @RequestParam("rarete") String rarete, @RequestParam("levelRequis") Integer levelRequis, @RequestParam("tauxDrop") Float tauxDrop, @RequestParam("durabilite") Integer durabilite, @RequestParam("img") String img, @RequestParam("attaque") Integer attaque, @RequestParam("defense") Integer defense) {
        Item item = new Item(nom, description, type, rarete, levelRequis, tauxDrop, durabilite, img, attaque, defense);
        item.setId(id);

        itemRepository.save(item);

        model.addAttribute("item", item);
        return "detail-item";
    }

    @RequestMapping(value = "/items/delete/{id}", method = RequestMethod.GET)
    public String deleteItem(@PathVariable String id, Model model) {
        Item item = this.itemRepository.findById(id);

        this.itemRepository.delete(item);

        return "redirect";
    }
}
