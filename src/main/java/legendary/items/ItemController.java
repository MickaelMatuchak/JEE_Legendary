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

    @RequestMapping(value = "/items/add", method = RequestMethod.POST)
    public String addItem(Model model, @RequestParam("nom") String nom, @RequestParam("description") String description, @RequestParam("type") String type, @RequestParam("rarete") String rarete, @RequestParam("levelRequis") Integer levelRequis, @RequestParam("tauxDrop") Float tauxDrop, @RequestParam("durabilite") Integer durabilite, @RequestParam("img") String img) {
        Item item = new Item(nom, description, type, rarete, levelRequis, tauxDrop, durabilite, img);
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
    public String editItem(Model model, @PathVariable("id") String id, @RequestParam("nom") String nom, @RequestParam("description") String description, @RequestParam("type") String type, @RequestParam("rarete") String rarete, @RequestParam("levelRequis") Integer levelRequis, @RequestParam("tauxDrop") Float tauxDrop, @RequestParam("durabilite") Integer durabilite, @RequestParam("img") String img) {
        Item item = new Item(nom, description, type, rarete, levelRequis, tauxDrop, durabilite, img);
        item.setId(id);

        itemRepository.save(item);

        model.addAttribute("item", item);
        return "detail-item";
    }

    @RequestMapping(value = "/items/delete/{id}", method = RequestMethod.GET)
    public String deleteItem(@PathVariable String id, Model model) {
        Item item = this.itemRepository.findById(id);
        this.itemRepository.delete(item);
        return "list-items";
    }

}
