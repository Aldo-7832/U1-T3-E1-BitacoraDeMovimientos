package mx.edu.utez.databaseregister.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.edu.utez.databaseregister.entity.Product;


public interface IProductRepository extends JpaRepository<Product, Long> {

    @Transactional
    @Modifying
    @Query(value = "delete from product where id = :id", nativeQuery = true)
    boolean deleteProduct(@Param("id") long id);

    @Query(value = "SELECT p FROM Product p WHERE p.status = 1")
    List<Product> findAllActives();
}
