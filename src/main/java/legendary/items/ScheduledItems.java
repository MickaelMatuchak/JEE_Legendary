package legendary.items;

import java.util.List;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableMongoRepositories
public class ScheduledItems {

    @Autowired
    private ItemRepository itemR;

    @Scheduled(fixedRate = 180000)
    public void countDownDurabilite() {

        List<Item> items = itemR.findAll();

        for (Item item : items) {
            item.setDurabilite(item.getDurabilite() - 1);
            itemR.save(item);
        }
    }
}