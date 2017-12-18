package legendary.items;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, Long> {
    Item findByNom(String nom);
    Item findById(String id);
}
