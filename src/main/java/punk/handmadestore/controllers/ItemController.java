package punk.handmadestore.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import punk.handmadestore.dto.ItemMinInfoDTO;
import punk.handmadestore.dto.ItemPageDTO;
import punk.handmadestore.exceptions.ErrorResponse;
import punk.handmadestore.exceptions.ItemNotFoundException;
import punk.handmadestore.services.ItemService;

import java.util.List;

@RestController
@RequestMapping("/items")
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/getAllItems")
    public List<ItemMinInfoDTO> findAllItems(){
        return itemService.findAllItems();
    }

    @GetMapping("/getItemById")
    public ItemPageDTO findItemById(
            @RequestParam (required = false) Integer itemId
    ){
        if (itemId == null ) throw new ItemNotFoundException("ITEM ID must be specified.");
        return itemService.findItemById(itemId);
    }

    @ExceptionHandler(
            {ItemNotFoundException.class}
    )
    private ResponseEntity<ErrorResponse> handleException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
