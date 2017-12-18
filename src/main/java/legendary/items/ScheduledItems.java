package legendary.items;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import legendary.personnages.Personnage;
import legendary.personnages.PersonnageRepository;

@Component
@EnableMongoRepositories
public class ScheduledItems {

    private static final Logger log = LoggerFactory.getLogger(ScheduledItems.class);
    
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