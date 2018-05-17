package com.xaut.shop.web;

import com.xaut.shop.domain.entity.Product;
import com.xaut.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public String createProduct(@RequestBody Product product) {
        int id = productService.createProduct(product);
        return "redirect:/products/" + id;
    }

}
