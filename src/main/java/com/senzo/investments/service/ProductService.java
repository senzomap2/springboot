package com.senzo.investments.service;

import com.senzo.investments.model.entity.Product;
import com.senzo.investments.repository.ProductRepo;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;
    public Product save(Product product){
        return productRepo.save(product);
    }

    public void deleteAll(){
        productRepo.deleteAll();
    }

    public Optional<Product> findByProductId(Integer id){
        return productRepo.findById(id);
    }
}
