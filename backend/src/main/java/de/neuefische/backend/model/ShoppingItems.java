package de.neuefische.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document()
public class ShoppingItems {
    @Id
    String id;
    String product;

    private int key;
    private String name;
    private int count;
    private String brand;

}
