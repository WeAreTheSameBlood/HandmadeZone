package punk.handmadestore.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonMinInfoDTO {

    private String username;

    @Size(min = 2, max = 60, message = "Full name should be between 2 and 60 characters")
    private String fullName;

}