package legendary.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping("/items")
    public String items(Model model) {
        List<Item> items = this.itemRepository.findAll();

        model.addAttribute("items", items);
        return "list-items";
    }

    @RequestMapping("/items/{id}")
    public String items(@PathVariable long id, Model model) {
        Item item = this.itemRepository.findOne(id);

        model.addAttribute("item", item);
        return "detail-item";
    }
}
