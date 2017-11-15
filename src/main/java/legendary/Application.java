package legendary;

import legendary.model.Equipement;
import legendary.model.Personnage;
import legendary.repository.EquipementRepository;
import legendary.repository.PersonnageRepository;
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
    public CommandLineRunner demo(PersonnageRepository personnageRepository, EquipementRepository equipementRepository) {
        return (args) -> {
            /*
            repository.save(new Personnage(1, "Bidou", 'M', Personnage.Classe.Prêtre, 50));
            repository.save(new Personnage(2, "Ptibenji", 'F', Personnage.Classe.Barbare, 30));
            repository.save(new Personnage(3, "El_Blavoute", 'M', Personnage.Classe.Chasseur, 1));
            */

            personnageRepository.save(new Personnage(1, "Bidou", 'M', "Prêtre", 50));
            personnageRepository.save(new Personnage(2, "Ptibenji", 'F', "Barbare", 30));
            personnageRepository.save(new Personnage(3, "El_Blavoute", 'M', "Chasseur", 1));

            equipementRepository.save(new Equipement(1, "Arc de chasse", "Donné par votre maitre", "Arme", "Commun", 1));
            equipementRepository.save(new Equipement(2, "String de Bambou", "Ce string a été concu avec du bambou du Japon", "Armure", "Legendaire", 4));
            equipementRepository.save(new Equipement(3, "Robe de curée", "Trouvée dans le monastaire de Lodka", "Armure", "Rare", 48));
        };
    }
}
