package clothify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Data

public class CustomerDto {

    private String id;
    private String name;
    private String email;
    private String contact;
    private String address;
    private String description;

    public CustomerDto(String id,String name, String email, String contact, String address, String description) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.description = description;
    }


}
