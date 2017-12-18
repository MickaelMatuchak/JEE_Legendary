package legendary;

import legendary.items.Item;
import legendary.personnages.Personnage;
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

            Personnage theo = new Personnage("Theophile", "TheoDarky", 'M',"Contrebandier", 35);
        	Personnage benj = new Personnage("Benjamin", "BenjiSith", 'F',"Guerrier Sith", 1);
        	Personnage mick = new Personnage("Mickael", "MickaVador", 'M',"Chevalier Jedi", 50);

            // ARME
            itemRepository.save(new Item("Sabrolaser rouge", "Mythique sabrolaser de méchant", "arme", "epique", 20, (float) 20, 20, "sabrolaser-rouge.jpg", 60, 20));
            itemRepository.save(new Item("Sabrolaser vert", "Peu commun mais banal", "arme", "commun", 20, (float) 20, 20, "sabrolaser-vert.jpg", 60, 20));
            itemRepository.save(new Item("Sabrolaser bleu", "Il a appartenu a Obiwan Kenobi", "arme", "epique", 20, (float) 20, 20, "sabrolaser-bleu.jpg", 60, 20));
            itemRepository.save(new Item("Double sabrolaser rouge", "La légende raconte qu'il a appartenu à Dark Maul", "arme", "legendaire", 30, (float) 20, 20, "sabrolaser-rouge-double.jpg", 80, 20));
            
            // CASQUE
            itemRepository.save(new Item("Casque du StormTrooper", "Casque d'un guerrier de l'empire", "casque", "commun", 1, (float) 20, 20, "casque-stormtrooper.jpg", 0, 20));
            itemRepository.save(new Item("Casque de Dark Vador", "Peut provoquer des difficultés de respiration", "casque", "legendaire", 30, (float) 5, 20, "casque-darkvador.jpg", 0, 20));
            itemRepository.save(new Item("Casque pilote B-Wing", "C'est le must pour un pilote", "casque", "commun", 1, (float) 20, 20, "casque-bwing.jpg", 0, 20));
            itemRepository.save(new Item("Casque de Chewbacca", "Il fait fureur pour le carnaval et effraie les ennemis", "casque", "commun", 1, (float) 20, 20, "casque-chewbacca.jpg", 0, 20));
            
            // COMBINAISON
            itemRepository.save(new Item("Combinaison du StormTrooper", "Il parait que le blanc amincie", "combinaison", "commun", 1, (float) 20, 20, "combinaison-stormtrooper.jpg", 0, 30));
            itemRepository.save(new Item("Combinaison de Chewbacca", "Parfait pour l'hiver. Laver à 30 degré.", "combinaison", "commun", 1, (float) 20, 20, "combinaison-chewbacca.jpg", 0, 30));
            itemRepository.save(new Item("Combinaison de Dark Vador", "Accoutrement légendaire", "combinaison", "legendaire", 30, (float) 20, 20, "combinaison-darkvador.jpeg", 0, 30));
            itemRepository.save(new Item("Combinaison pilote B-Wing", "Coupe très aérodynamique pour un pilotage interstéllaire", "combinaison", "rare", 1, (float) 20, 20, "combinaison-bwing.png", 0, 30));

            theo.setIdSabre(itemRepository.findByNom("Sabrolaser vert").getId());
            theo.setImgSabre(itemRepository.findByNom("Sabrolaser vert").getImg());
            theo.setRareteSabre(itemRepository.findByNom("Sabrolaser vert").getRarete());
            theo.setIdArmure(itemRepository.findByNom("Combinaison du StormTrooper").getId());
            theo.setImgArmure(itemRepository.findByNom("Combinaison du StormTrooper").getImg());
            theo.setRareteArmure(itemRepository.findByNom("Combinaison du StormTrooper").getRarete());
            theo.setIdCasque(itemRepository.findByNom("Casque de Chewbacca").getId());
            theo.setImgCasque(itemRepository.findByNom("Casque de Chewbacca").getImg());
            theo.setRareteCasque(itemRepository.findByNom("Casque de Chewbacca").getRarete());

            benj.setIdSabre(itemRepository.findByNom("Sabrolaser rouge").getId());
            benj.setImgSabre(itemRepository.findByNom("Sabrolaser rouge").getImg());
            benj.setRareteSabre(itemRepository.findByNom("Sabrolaser rouge").getRarete());
            benj.setIdArmure(itemRepository.findByNom("Combinaison de Chewbacca").getId());
            benj.setImgArmure(itemRepository.findByNom("Combinaison de Chewbacca").getImg());
            benj.setRareteArmure(itemRepository.findByNom("Combinaison de Chewbacca").getRarete());
            benj.setIdCasque(itemRepository.findByNom("Casque de Dark Vador").getId());
            benj.setImgCasque(itemRepository.findByNom("Casque de Dark Vador").getImg());
            benj.setRareteCasque(itemRepository.findByNom("Casque de Dark Vador").getRarete());

            mick.setIdSabre(itemRepository.findByNom("Double sabrolaser rouge").getId());
            mick.setImgSabre(itemRepository.findByNom("Double sabrolaser rouge").getImg());
            mick.setRareteSabre(itemRepository.findByNom("Double sabrolaser rouge").getRarete());
            mick.setIdArmure(itemRepository.findByNom("Combinaison pilote B-Wing").getId());
            mick.setImgArmure(itemRepository.findByNom("Combinaison pilote B-Wing").getImg());
            mick.setRareteArmure(itemRepository.findByNom("Combinaison pilote B-Wing").getRarete());
            mick.setIdCasque(itemRepository.findByNom("Casque pilote B-Wing").getId());
            mick.setImgCasque(itemRepository.findByNom("Casque pilote B-Wing").getImg());
            mick.setRareteCasque(itemRepository.findByNom("Casque pilote B-Wing").getRarete());

            // PERSONNAGE
            personnageRepository.save(theo);
            personnageRepository.save(benj);
            personnageRepository.save(mick);
        };
    }
}
