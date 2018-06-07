package edu.rit.pavan.services.impl;

import edu.rit.pavan.dao.ProductDAO;
import edu.rit.pavan.exceptions.ProductNotFound;
import edu.rit.pavan.models.Product;
import edu.rit.pavan.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier(value = "ProductServiceImpl")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    public List<Product> findProductsByProductIdAndProductPrice(int productId, double productPrice) {
        return productDAO.findProductsByProductIdAndProductPrice(productId, productPrice);
    }

    @Override
    public List<Product> getAll() {
        return productDAO.findAll();
    }

    @Override
    public Product getProductById(final int productId) {
        return productDAO.findById(productId).get();
    }

    @Override
    public Product create(final Product product) {
        return productDAO.save(product);
    }

    @Override
    public void delete(final int productId) throws ProductNotFound {
        Product product = productDAO.findById(productId).get();
        if (product != null) {
            productDAO.delete(product);
        } else {
            throw new ProductNotFound();
        }

    }

    @Override
    public Product update(final Product product) {
        return productDAO.save(product);
    }
}
