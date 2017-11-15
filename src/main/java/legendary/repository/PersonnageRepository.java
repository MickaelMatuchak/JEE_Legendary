package legendary.repository;

import legendary.model.Personnage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonnageRepository extends MongoRepository<Personnage, Long> {
}
