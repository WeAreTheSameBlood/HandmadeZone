package punk.handmadestore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import punk.handmadestore.models.Item;

import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {
}
