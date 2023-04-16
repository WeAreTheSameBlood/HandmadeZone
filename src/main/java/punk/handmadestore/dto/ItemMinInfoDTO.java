package punk.handmadestore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import punk.handmadestore.models.CategoryOfItem;
import punk.handmadestore.models.ImageOfItem;

import java.util.List;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemMinInfoDTO {

    private String name;

    private Float price;

    private List<CategoryOfItem> listOfCategories;

    private List<ImageOfItem> listOfImgs;

}
