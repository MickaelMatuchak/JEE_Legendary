package legendary.items;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ItemRestController {

    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<Item> listItems() {
        return this.itemRepository.findAll();
    }

    @RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
    public Item detailItem(@PathVariable long id) {
        return this.itemRepository.findOne(id);
    }
}
