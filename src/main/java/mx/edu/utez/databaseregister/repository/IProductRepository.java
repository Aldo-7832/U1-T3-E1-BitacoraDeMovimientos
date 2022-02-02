package mx.edu.utez.databaseregister.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import mx.edu.utez.databaseregister.entity.Product;


public interface IProductRepository extends JpaRepository<Product, Long> {
    
}
