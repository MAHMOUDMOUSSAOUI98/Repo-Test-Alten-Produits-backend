package com.alten.product.repository;

import com.alten.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Indique que c'est un composant de persistance
public interface ProductRepository extends JpaRepository<Product, Long> {
    // JpaRepository fournit déjà les méthodes CRUD de base (save, findById, findAll, deleteById, etc.)
    // Vous pouvez ajouter des méthodes personnalisées ici si besoin, ex: List<Product> findByName(String name);
}
