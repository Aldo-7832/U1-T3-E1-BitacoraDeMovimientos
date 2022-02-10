package mx.edu.utez.databaseregister.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.databaseregister.service.ProductService;
import mx.edu.utez.databaseregister.entity.Product;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> findAllCompany() {
        return productService.findAll();
    }

    @RequestMapping(value = "/save", method = { RequestMethod.GET, RequestMethod.POST })
    @Transactional
    public Product saveProduct(@RequestBody Product obj) {
        try {
            return productService.save(obj);
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping(value = "/delete")
    public boolean delete(@RequestBody Product obj) {
        try {
            productService.delete(obj);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
