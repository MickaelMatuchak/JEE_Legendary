package legendary;

import legendary.personnages.Personnage;
import legendary.items.ItemRepository;
import legendary.personnages.PersonnageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(PersonnageRepository personnageRepository, ItemRepository itemRepository) {
        return (args) -> {

            personnageRepository.save(new Personnage("Theophile", "TheoDarky", 'M',"Contrebandier", 35));
            personnageRepository.save(new Personnage("Benjamin", "BenjiSith", 'F',"Guerrier Sith", 1));
            personnageRepository.save(new Personnage("Mickael", "MickaVador", 'M',"Chevalier Jedi", 50));

            /*
            itemRepository.save(new Item(1, "Arc de chasse", "Donné par votre maitre", "Arme", "Commun", 1));
            itemRepository.save(new Item(2, "String de Bambou", "Ce string a été concu avec du bambou du Japon", "Armure", "Legendaire", 4));
            itemRepository.save(new Item(3, "Robe de curée", "Trouvée dans le monastaire de Lodka", "Armure", "Rare", 48));
        */
        };
    }
}
