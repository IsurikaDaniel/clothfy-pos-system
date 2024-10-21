package clothify.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Data
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    private Integer id;
    private String name;
    private Integer contact;
    private String email;
    private String address;
    private String company;

    public Employee(Integer id,String name, Integer contact, String email, String address, String company) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.company = company;
    }
}
