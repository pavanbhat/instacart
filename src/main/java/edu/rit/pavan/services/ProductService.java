package edu.rit.pavan.services;

import edu.rit.pavan.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product getProductById(int productId);

    Product create(Product product);

    void delete(int productId);

    Product update(Product product);

    List<Product> findProductsByProductIdAndProductPrice(int productId, double productPrice);
}
