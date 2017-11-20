package legendary.personnages;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonnageRepository extends MongoRepository<Personnage, Long> {
    Personnage findByPseudo(String pseudo);
}
