package punk.handmadestore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import punk.handmadestore.models.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {
}
