package com.alten.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Indique que cette classe est une entité JPA et sera mappée à une table de base de données
@Data // Génère les getters, setters, toString, equals et hashCode (Lombok)
@NoArgsConstructor // Génère un constructeur sans arguments (Lombok)
@AllArgsConstructor // Génère un constructeur avec tous les arguments (Lombok)
public class Product {

    @Id // Indique que 'id' est la clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrémentation pour la clé primaire
    private Long id;

    @NotBlank(message = "Name is mandatory") // Validation : le nom ne peut pas être vide
    private String name;

    @NotBlank(message = "Description is mandatory") // Validation : la description ne peut pas être vide
    private String description;

    @NotNull(message = "Price is mandatory") // Validation : le prix ne peut pas être nul
    @DecimalMin(value = "0.01", message = "Price must be greater than 0") // Validation : le prix doit être > 0.01
    private Double price;
}