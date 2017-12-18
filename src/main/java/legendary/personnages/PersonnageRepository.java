package legendary.personnages;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonnageRepository extends MongoRepository<Personnage, Long> {
    Personnage findByPseudo(String pseudo);
    Personnage findById(String id);
    List<Personnage> findAllByProprietaire(String proprietaire);
}
