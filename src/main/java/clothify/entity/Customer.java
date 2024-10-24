package clothify.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String id;
    private String name;
    private String email;
    private Integer contact;
    private String address;
    private String description;

    public Customer(String name, String email, Integer contact, String address, String description) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.description = description;
    }
}
