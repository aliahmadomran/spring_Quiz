package com.example.quiz.models;

import javax.persistence.*;

@Entity
@Table(name = "bill")
public class Bill {

    @Id
    @SequenceGenerator(
            name = "bill_sequence",
            sequenceName ="bill_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bill_sequence"

    )
    private Long billId;


    private Double price;
    private Double quantity;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(
            name = "product_id",
            referencedColumnName = "productId"
    )
    private Product product;

    public Bill() {
    }

    public Bill(Long billId, Double price, Double quantity, Product product) {
        this.billId = billId;
        this.price = price;
        this.quantity = quantity;
        this.product = product;
    }

    public Bill(Double price, Double quantity, Product product) {
        this.price = price;
        this.quantity = quantity;
        this.product = product;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

