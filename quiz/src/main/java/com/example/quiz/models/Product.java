package com.example.quiz.models;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;




//Lombok..
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName ="product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"

    )
    private Long productId;
    private  String productName;
    private String productDescription;
    private String productCategory;
    private LocalDateTime productCreationDate;


    public Product() {
    }

    public Product(String productName, String productDescription, String productCategory) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
        this.productCreationDate = LocalDateTime.now();
    }

    public Product(Long productId, String productName, String productDescription, String productCategory) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
        this.productCreationDate = LocalDateTime.now();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public LocalDateTime getProductCreationDate() {
        return productCreationDate;
    }

    public void setProductCreationDate(LocalDateTime productCreationDate) {
        this.productCreationDate = productCreationDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", productCreationDate=" + productCreationDate +
                '}';
    }
}
