package ma.enset.inventoryservice.models;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class ProductModel {
    private Long id;
    private String name;
    private double price;
    private int quantity;
}
