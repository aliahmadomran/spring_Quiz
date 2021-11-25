package com.example.quiz.controllers;


import com.example.quiz.models.Product;
import com.example.quiz.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "salesSystem/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product product){
        productService.addNewProduct(product);
    }

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }


    @PutMapping("/updateProduct/{productId}")
    public void updateProduct(@PathVariable("productId") Long productId,@RequestBody Product product){
        productService.updateProduct(productId,product);
    }

}
