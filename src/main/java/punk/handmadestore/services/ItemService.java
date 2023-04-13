package punk.handmadestore.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import punk.handmadestore.models.Item;
import punk.handmadestore.repositories.ItemRepo;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepo itemRepo;

    public ItemService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public List<Item> findAllItems() {
        return itemRepo.findAll();
    }
}
