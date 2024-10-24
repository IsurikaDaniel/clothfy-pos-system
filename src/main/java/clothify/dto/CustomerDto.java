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

    public CustomerDto(String name, String email, Integer contact, String address, String description) {

        this.name = name;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.description = description;
    }
}
