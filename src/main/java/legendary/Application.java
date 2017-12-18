package legendary;

import legendary.items.Item;
import legendary.personnages.Personnage;
import legendary.items.ItemRepository;
import legendary.personnages.PersonnageRepository;
import legendary.users.User;
import legendary.users.UserRepository;
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
    public CommandLineRunner demo(PersonnageRepository personnageRepository, ItemRepository itemRepository, UserRepository userRepository) {
        return (args) -> {

            personnageRepository.save(new Personnage("Theophile", "TheoDarky", 'M',"Contrebandier", 35));
            personnageRepository.save(new Personnage("Benjamin", "BenjiSith", 'F',"Guerrier Sith", 1));
            personnageRepository.save(new Personnage("Mickael", "MickaVador", 'M',"Chevalier Jedi", 50));


            itemRepository.save(new Item("Sabre de Jedi", "Donné par votre maitre", "Arme", "rare", 40, 70.0));
            itemRepository.save(new Item("Sabre de l'apprenti", "Sabre pour vous entrainer", "Arme", "commun", 40, 100.0));
            itemRepository.save(new Item("Sabre de l'apprenti Jedi", "Sabre laser pour vous entrainer", "Arme", "commun", 40, 100.0));
            itemRepository.save(new Item("Sabre de Maître Jedi", "Sabre laser d'un maitre Jedi", "Arme", "epique", 40, 30.0));
            itemRepository.save(new Item("Sabre de Maître Jedi puissant", "Sabre laser d'un maitre Jedi", "Arme", "epique", 40, 25.0));
            itemRepository.save(new Item("Sabre de Yoda", "Sabre laser de maitre Yoda", "Arme", "legendaire", 40, 10.0));
            itemRepository.save(new Item("Sabre de Dark Vador", "Sabre laser de Dark Vador", "Arme", "legendaire", 40, 10.0));

            userRepository.save(new User("theo", "theo"));
            userRepository.save(new User("benji", "benji"));


        };
    }
}
