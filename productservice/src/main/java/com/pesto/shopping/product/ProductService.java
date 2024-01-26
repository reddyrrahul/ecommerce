package com.pesto.shopping.product;

public interface ProductService {

    public Product getProduct(Long productId);

    public Product addProduct(Product product);

    public Product updateProduct(Product product);

    public void deleteProduct(Long productId);
}
