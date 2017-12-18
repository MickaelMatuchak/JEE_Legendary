package legendary.items;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ItemRestController {

    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<Item> listItems() {
        return this.itemRepository.findAll();
    }

    @RequestMapping(value = "/items/{name}", method = RequestMethod.GET)
    public Item detailItem(@PathVariable String name) {
        return this.itemRepository.findByNom(name);
    }

    @RequestMapping(value = "/items/delete/{name}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable String name) {
        Item item = this.itemRepository.findByNom(name);
        this.itemRepository.delete(item);
    }

    @RequestMapping(value = "/items/add", method = RequestMethod.POST)
    public Item addItem(@RequestParam("nom") String nom, @RequestParam("description") String description, @RequestParam("type") String type, @RequestParam("rarete") String rarete, @RequestParam("levelRequis") Integer levelRequis, @RequestParam("tauxDrop") Float tauxDrop, @RequestParam("durabilite") Integer durabilite, @RequestParam("img") String img, @RequestParam("attaque") Integer attaque, @RequestParam("defense") Integer defense) {
        Item item = new Item(nom, description, type, rarete, levelRequis, tauxDrop, durabilite, img, attaque, defense);
        itemRepository.save(item);
        return item;
    }

    @RequestMapping(value = "/items/edit/{id}", method = RequestMethod.POST)
    public Item modifyItem(@PathVariable("id") String id, @RequestParam("nom") String nom, @RequestParam("description") String description, @RequestParam("type") String type, @RequestParam("rarete") String rarete, @RequestParam("levelRequis") Integer levelRequis, @RequestParam("tauxDrop") Float tauxDrop, @RequestParam("durabilite") Integer durabilite, @RequestParam("img") String img, @RequestParam("attaque") Integer attaque, @RequestParam("defense") Integer defense) {
        Item item = new Item(nom, description, type, rarete, levelRequis, tauxDrop, durabilite, img, attaque, defense);
        item.setId(id);

        itemRepository.save(item);
        return item;
    }
}
