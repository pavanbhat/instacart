package edu.rit.pavan.controllers;

import edu.rit.pavan.models.Product;
import edu.rit.pavan.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "products")
public class ProductsController {

    @Autowired
    @Qualifier(value = "ProductServiceImpl")
    public ProductService productService;

    //    @RequestMapping(path = "/", method = RequestMethod.GET)
    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping(path = "/{id}")
    public Product getProductById(@PathVariable(value = "id") final int productId) {
        return productService.getProductById(productId);
    }

    @PostMapping(path = "/")
    public Product create(@RequestBody final Product product) {
        return productService.create(product);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable(value = "id") final int productId) {
        productService.delete(productId);
    }

    @PutMapping(path = "/{id}")
    public Product update(@PathVariable(value = "id") final int productId, @RequestBody final Product product) {
        if (product.getProductId() == productId) {
            return productService.update(product);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
