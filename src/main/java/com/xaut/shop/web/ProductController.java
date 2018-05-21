package com.xaut.shop.web;

import com.xaut.shop.domain.entity.Product;
import com.xaut.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product product, HttpServletResponse response) {
        int id = productService.createProduct(product);
        response.setHeader("location", "/products/" + id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(@RequestBody Product product, @PathVariable int id, HttpServletResponse response) {
        product.setId(id);
        productService.updateProduct(product);
        response.setHeader("location", "/products/" + id);
    }

    @GetMapping(value = "/{id}")
    public Product getProduct(@PathVariable int id) {
        return productService.getProduct(id);
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping(params = "name")
    public List<Product> getProductByName(@RequestParam String name) {
        return productService.getProductsByName(name);
    }

    @GetMapping(params = {"name", "description"})
    public List<Product> getProductLikeNameAndDescription(@RequestParam String name, @RequestParam String description) {
        return productService.getProductsLikeNameAndDescription(name, description);
    }
}
