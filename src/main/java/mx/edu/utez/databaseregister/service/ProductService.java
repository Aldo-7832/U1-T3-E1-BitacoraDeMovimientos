package mx.edu.utez.databaseregister.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.databaseregister.repository.IProductRepository;
import mx.edu.utez.databaseregister.entity.Product;

@Service
public class ProductService {
    @Autowired
    private IProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAllActives();
    }

    public Product save(Product product) {
        boolean res = false;
        Product obj = productRepository.save(product);

        if (!obj.equals(null)) {
            res = true;
        }
        return obj;
    }

    public boolean delete(Product product) {
        try {
            productRepository.delete(product);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
