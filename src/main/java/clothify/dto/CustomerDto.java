package clothify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data

public class CustomerDto {

    private String id;
    private String name;
    private String email;
    private Integer contact;
    private String address;
    private String description;
}
