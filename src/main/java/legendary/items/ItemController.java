package legendary.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
    public String detailItem(@PathVariable long id, Model model) {
        Item item = this.itemRepository.findOne(id);

        model.addAttribute("item", item);
        return "detail-item";
    }
}
