package legendary.repository;

import legendary.model.Equipement;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EquipementRepository extends MongoRepository<Equipement, Long> {
    Equipement findByNom(String nom);
}
