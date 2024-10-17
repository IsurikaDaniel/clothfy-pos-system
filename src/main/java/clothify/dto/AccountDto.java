package clothify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class AccountDto {

    private Integer id;
    private String email;
    private String password;
    private String jobRole;

    public AccountDto(String email, String password, String jobRole) {
        this.email = email;
        this.password = password;
        this.jobRole = jobRole;
    }


}
