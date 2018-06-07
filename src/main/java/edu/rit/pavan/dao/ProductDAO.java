package edu.rit.pavan.dao;

import edu.rit.pavan.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends MongoRepository<Product, Integer> {

    List<Product> findProductsByProductIdAndProductPrice(int productId, double productPrice);
}
