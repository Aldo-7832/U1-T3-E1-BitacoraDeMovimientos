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
        return productRepository.findAll();
    }

    public Product save(Product product) {
        boolean res = false;
        Product obj = productRepository.save(product);

        if (!obj.equals(null)) {
            res = true;
        }
        return obj;
    }

}
