package clothify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class AdminDto {

    private String id;
    private String name;
    private String email;
    private Integer contact;
    private String password;
}
