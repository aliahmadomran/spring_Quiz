package com.example.quiz.services;

import com.example.quiz.models.Product;
import com.example.quiz.repository.ProductRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {
    Logger logger = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public void addNewProduct(Product product) {

        product.setProductCreationDate(LocalDateTime.now());

        logger.info("Product Added successfully");
    }

    public List<Product> getAllProducts(){
    logger.info("get all products");
      return  productRepo.findAll();
    }



    @Transactional
    public void updateProduct(Long productId,Product updatedProduct) {

        Product product = productRepo.findById(productId)
                .orElseThrow(()->new IllegalStateException(
                        "Product with id :"+productId+" does not exist"));

        if(updatedProduct.getProductName() != null &&
                updatedProduct.getProductName().length() > 0 &&
                !Objects.equals(product.getProductName(),updatedProduct.getProductName())){

            product.setProductName(updatedProduct.getProductName());
        }
        if(updatedProduct.getProductDescription() != null &&
                updatedProduct.getProductDescription().length() > 0 &&
                !Objects.equals(product.getProductDescription(),updatedProduct.getProductDescription())){

            product.setProductDescription(updatedProduct.getProductDescription());
        }
        if(updatedProduct.getProductCategory() != null &&
                updatedProduct.getProductCategory().length() > 0 &&
                !Objects.equals(product.getProductCategory(),updatedProduct.getProductCategory())){

            product.setProductCategory(updatedProduct.getProductCategory());
        }

        logger.info(" product with id :"+productId+" updated successfully");
    }



}
