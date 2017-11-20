package legendary.items;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ItemRestController {

    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping("/items")
    public List<Item> items() {
        return this.itemRepository.findAll();
    }

    @RequestMapping("/items/{id}")
    public Item item(@PathVariable long id) {
        return this.itemRepository.findOne(id);
    }
}
