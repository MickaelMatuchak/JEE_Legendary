package legendary.personnages;

import legendary.personnages.Personnage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonnageRepository extends MongoRepository<Personnage, Long> {
    Personnage findByPseudo(String pseudo);
}
