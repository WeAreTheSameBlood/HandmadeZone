package punk.handmadestore.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import punk.handmadestore.repositories.PersonRepo;

@Service
@Transactional(readOnly = true)
public class PersonService {

    private final PersonRepo personRepo;

    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }
}
