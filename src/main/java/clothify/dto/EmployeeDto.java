package clothify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDto {

    private Integer id;
    private String name;
    private Integer contact;
    private String email;
    private String address;
    private String company;

}
