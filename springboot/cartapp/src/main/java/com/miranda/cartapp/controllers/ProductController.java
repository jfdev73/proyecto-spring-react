package com.miranda.cartapp.controllers;

import com.miranda.cartapp.model.Product;
import com.miranda.cartapp.services.ProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;

    }
    @GetMapping("/products")
    public List<Product> list(){
        return productService.findAll();
    }
}
