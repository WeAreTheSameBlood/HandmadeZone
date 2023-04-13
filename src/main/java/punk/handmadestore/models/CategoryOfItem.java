package punk.handmadestore.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "items_categories")
@Getter
@Setter
@NoArgsConstructor
public class CategoryOfItem {

    @Id
    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    @JsonBackReference
    private Item item;

    @Id
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @JsonManagedReference
    private Category category;
}
