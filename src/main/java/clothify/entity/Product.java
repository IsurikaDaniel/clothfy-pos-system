package clothify.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="Product")

public class Product {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

   private Integer id;
   private String  name;
   private Integer quantity;
   private Double price;
}
