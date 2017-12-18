package legendary;

import legendary.personnages.Personnage;
import legendary.items.Item;
import legendary.items.ItemRepository;
import legendary.personnages.PersonnageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableMongoRepositories
@SpringBootApplication
@EnableScheduling
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(PersonnageRepository personnageRepository, ItemRepository itemRepository) {
        return (args) -> {

        	// PERSONNAGE
            personnageRepository.save(new Personnage("Theophile", "TheoDarky", 'M',"Contrebandier", 35));
            personnageRepository.save(new Personnage("Benjamin", "BenjiSith", 'F',"Guerrier Sith", 1));
            personnageRepository.save(new Personnage("Mickael", "MickaVador", 'M',"Chevalier Jedi", 50));

            // ARME
            itemRepository.save(new Item("Sabrolaser rouge", "Mythique sabrolaser de méchant", "arme", "epique", 20, (float) 20, 20, "sabrolaser-rouge.jpg"));
            itemRepository.save(new Item("Sabrolaser vert", "Peu commun mais banal", "Arme", "commun", 20, (float) 20, 20, "sabrolaser-vert.jpg"));            
            itemRepository.save(new Item("Sabrolaser bleu", "Il a appartenu a Obiwan Kenobi", "Arme", "epique", 20, (float) 20, 20, "sabrolaser-bleu.jpg"));
            itemRepository.save(new Item("Double sabrolaser rouge", "La légende raconte qu'il a appartenu à Dark Maul", "Arme", "legendaire", 30, (float) 20, 20, "sabrolaser-rouge-double.jpg"));
            
            // CASQUE
            itemRepository.save(new Item("Casque du StormTrooper", "Casque d'un guerrier de l'empire", "casque", "commun", 1, (float) 20, 20, "casque-stormtrooper.jpg"));
            itemRepository.save(new Item("Casque de Dark Vador", "Peut provoquer des difficultés de respiration", "casque", "legendaire", 30, (float) 5, 20, "casque-darkvador.jpg"));
            itemRepository.save(new Item("Casque pilote B-Wing", "C'est le must pour un pilote", "casque", "commun", 1, (float) 20, 20, "casque-bwing.jpg"));
            itemRepository.save(new Item("Casque de Chewbacca", "Il fait fureur pour le carnaval et effraie les ennemis", "casque", "commun", 1, (float) 20, 20, "casque-chewbacca.jpg"));
            
            // COMBINAISON
            itemRepository.save(new Item("Combinaison du StormTrooper", "Il parait que le blanc amincie", "combinaison", "commun", 1, (float) 20, 20, "combinaison-stormtrooper.jpg"));
            itemRepository.save(new Item("Combinaison de Chewbacca", "Parfait pour l'hiver. Laver à 30 degré.", "combinaison", "commun", 1, (float) 20, 20, "combinaison-chewbacca.jpg"));
            itemRepository.save(new Item("Combinaison de Dark Vador", "Accoutrement légendaire", "combinaison", "legendaire", 30, (float) 20, 20, "combinaison-darkvador.jpeg"));
            itemRepository.save(new Item("Combinaison pilote B-Wing", "Coupe très aérodynamique pour un pilotage interstéllaire", "combinaison", "rare", 1, (float) 20, 20, "combinaison-bwing.png"));
        };
    }
}
