package punk.handmadestore.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@Entity
@Table(name = "persons")
@Getter
@Setter
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int personId;

    @Column(name = "username", unique = true)
    @UniqueElements
    @NotNull
    @Size(min = 4, max = 24, message = "Username should be between 4 and 24 characters")
    private String username;

    @Column(name = "full_name")
    @Size(min = 2, max = 60, message = "Full name should be between 2 and 60 characters")
    private String fullName;

    @Column(name = "description")
    private String description;

    @Column(name = "path_to_avatar")
    private String pathToAvatar;

    @OneToMany(mappedBy = "person")
    @JsonManagedReference
    List<Item> listOfItems;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    @JsonManagedReference
    private PersonProperty property;
}
