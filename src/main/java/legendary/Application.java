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
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableMongoRepositories
@SpringBootApplication
@EnableScheduling
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(PersonnageRepository personnageRepository, ItemRepository itemRepository, UserRepository userRepository) {
        return (args) -> {

            Personnage theo = new Personnage("Theophile", "TheoDarky", 'M',"Contrebandier", 35);
        	Personnage benj = new Personnage("Benjamin", "BenjiSith", 'F',"Guerrier Sith", 1);
        	Personnage mick = new Personnage("Mickael", "MickaVador", 'M',"Chevalier Jedi", 50);

            // ARME
            itemRepository.save(new Item("Sabrolaser rouge", "Mythique sabrolaser de méchant", "arme", "epique", 20, (float) 20, 20, "sabrolaser-rouge.jpg", 70, 10));
            itemRepository.save(new Item("Sabrolaser vert", "Peu commun mais banal", "arme", "commun", 20, (float) 20, 20, "sabrolaser-vert.jpg", 65, 5));
            itemRepository.save(new Item("Sabrolaser bleu", "Il a appartenu a Obiwan Kenobi", "arme", "epique", 20, (float) 20, 20, "sabrolaser-bleu.jpg", 80, 20));
            itemRepository.save(new Item("Double sabrolaser rouge", "La légende raconte qu'il a appartenu à Dark Maul", "arme", "legendaire", 30, (float) 20, 20, "sabrolaser-rouge-double.jpg", 100, 25));
            
            // CASQUE
            itemRepository.save(new Item("Casque du StormTrooper", "Casque d'un guerrier de l'empire", "casque", "commun", 1, (float) 20, 20, "casque-stormtrooper.jpg", 0, 15));
            itemRepository.save(new Item("Casque de Dark Vador", "Peut provoquer des difficultés de respiration", "casque", "legendaire", 30, (float) 5, 20, "casque-darkvador.jpg", 0, 30));
            itemRepository.save(new Item("Casque pilote B-Wing", "C'est le must pour un pilote", "casque", "commun", 1, (float) 20, 20, "casque-bwing.jpg", 0, 40));
            itemRepository.save(new Item("Casque de Chewbacca", "Il fait fureur pour le carnaval et effraie les ennemis", "casque", "commun", 1, (float) 20, 20, "casque-chewbacca.jpg", 0, 20));
            
            // COMBINAISON
            itemRepository.save(new Item("Combinaison du StormTrooper", "Il parait que le blanc amincie", "combinaison", "commun", 1, (float) 20, 20, "combinaison-stormtrooper.jpg", 0, 15));
            itemRepository.save(new Item("Combinaison de Chewbacca", "Parfait pour l'hiver. Laver à 30 degré.", "combinaison", "commun", 1, (float) 20, 20, "combinaison-chewbacca.jpg", 0, 20));
            itemRepository.save(new Item("Combinaison de Dark Vador", "Accoutrement légendaire", "combinaison", "legendaire", 30, (float) 20, 20, "combinaison-darkvador.jpeg", 0, 30));
            itemRepository.save(new Item("Combinaison pilote B-Wing", "Coupe très aérodynamique pour un pilotage interstéllaire", "combinaison", "rare", 1, (float) 20, 20, "combinaison-bwing.png", 0, 40));

            Item sabre = itemRepository.findByNom("Sabrolaser vert");
            theo.setIdSabre(sabre.getId());
            theo.setImgSabre(sabre.getImg());
            theo.setRareteSabre(sabre.getRarete());

            Item armure = itemRepository.findByNom("Combinaison du StormTrooper");
            theo.setIdArmure(armure.getId());
            theo.setImgArmure(armure.getImg());
            theo.setRareteArmure(armure.getRarete());

            Item casque = itemRepository.findByNom("Casque de Chewbacca");
            theo.setIdCasque(casque.getId());
            theo.setImgCasque(casque.getImg());
            theo.setRareteCasque(casque.getRarete());

            theo.setAtkStuff(casque.getAttaque() + armure.getAttaque() + sabre.getAttaque());
            theo.setDefStuff(casque.getDefense() + armure.getDefense() + sabre.getDefense());

            sabre = itemRepository.findByNom("Sabrolaser rouge");
            benj.setIdSabre(sabre.getId());
            benj.setImgSabre(sabre.getImg());
            benj.setRareteSabre(sabre.getRarete());

            armure = itemRepository.findByNom("Combinaison de Chewbacca");
            benj.setIdArmure(armure.getId());
            benj.setImgArmure(armure.getImg());
            benj.setRareteArmure(armure.getRarete());

            casque = itemRepository.findByNom("Casque de Dark Vador");
            benj.setIdCasque(casque.getId());
            benj.setImgCasque(casque.getImg());
            benj.setRareteCasque(casque.getRarete());

            benj.setAtkStuff(casque.getAttaque() + armure.getAttaque() + sabre.getAttaque());
            benj.setDefStuff(casque.getDefense() + armure.getDefense() + sabre.getDefense());

            sabre = itemRepository.findByNom("Double sabrolaser rouge");
            mick.setIdSabre(sabre.getId());
            mick.setImgSabre(sabre.getImg());
            mick.setRareteSabre(sabre.getRarete());

            armure = itemRepository.findByNom("Combinaison pilote B-Wing");
            mick.setIdArmure(armure.getId());
            mick.setImgArmure(armure.getImg());
            mick.setRareteArmure(armure.getRarete());

            casque = itemRepository.findByNom("Casque pilote B-Wing");
            mick.setIdCasque(casque.getId());
            mick.setImgCasque(casque.getImg());
            mick.setRareteCasque(casque.getRarete());

            mick.setAtkStuff(casque.getAttaque() + armure.getAttaque() + sabre.getAttaque());
            mick.setDefStuff(casque.getDefense() + armure.getDefense() + sabre.getDefense());

            // PERSONNAGE
            personnageRepository.save(theo);
            personnageRepository.save(benj);
            personnageRepository.save(mick);
        };
    }
}
