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
    private String Name;
    private Integer contact;
    private String email;
}
