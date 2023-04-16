package punk.handmadestore.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import punk.handmadestore.dto.ItemMinInfoDTO;
import punk.handmadestore.dto.ItemPageDTO;
import punk.handmadestore.dto.MapperDTO;
import punk.handmadestore.exceptions.ItemNotFoundException;
import punk.handmadestore.repositories.ItemRepo;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepo itemRepo;
    private final MapperDTO mapper;

    public ItemService(ItemRepo itemRepo, MapperDTO mapper) {
        this.itemRepo = itemRepo;
        this.mapper = mapper;
    }

    public List<ItemMinInfoDTO> findAllItems() {
        return mapper.mappingData(
                itemRepo.findAll(), ItemMinInfoDTO.class
        );
    }

    public ItemPageDTO findItemById(Integer itemId) {
        return mapper.mappingData(
                itemRepo
                .findByItemId(itemId)
                .orElseThrow(
                        () -> new ItemNotFoundException("Item with this ITEM ID not found.")
                ), ItemPageDTO.class);
    }
}
