package punk.handmadestore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import punk.handmadestore.models.Item;

import java.util.Optional;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {

    Optional<Item> findByItemId(int id);
}
