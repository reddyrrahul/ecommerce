package com.pesto.shopping.product;

import com.pesto.shopping.product.exception.ProductNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    @Override
    public Product getProduct(Long productId) {
        Product Product = productRepo.findById(productId).orElse(null);
        if(null == Product){
            throw new ProductNotFoundException("Product Not Found");
        }
        return Product;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        if(null == productRepo.findById(product.getId()).orElse(null)){
            throw new EntityNotFoundException("Product Not Found");
        }
        return productRepo.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        if(null == productRepo.findById(productId).orElse(null)){
            throw new EntityNotFoundException("Product Not Found");
        }
        productRepo.deleteById(productId);
    }
}
