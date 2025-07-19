package com.alten.product.controller;

import com.alten.product.model.Product;
import com.alten.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indique que c'est un contrôleur REST Spring
@RequestMapping("/api/products") // Définit le chemin de base pour toutes les requêtes de ce contrôleur
@CrossOrigin(origins = "http://localhost:5173") // Permet les requêtes CORS depuis votre frontend React (peut être retiré si CORS est configuré globalement dans application.properties)
public class ProductController {

    @Autowired // Injection de dépendance du ProductService
    private ProductService productService;

    // GET /api/products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // GET /api/products/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok) // Si trouvé, retourne 200 OK
                .orElse(ResponseEntity.notFound().build()); // Si non trouvé, retourne 404 Not Found
    }

    // POST /api/products
    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        // @Valid déclenche la validation définie dans l'entité Product
        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED); // Retourne 201 Created
    }

    // PUT /api/products/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @Valid @RequestBody Product productDetails) {
        Product updatedProduct = productService.updateProduct(id, productDetails);
        return ResponseEntity.ok(updatedProduct); // Retourne 200 OK
    }

    // DELETE /api/products/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retourne 204 No Content
    }
}