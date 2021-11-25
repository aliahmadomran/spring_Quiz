package com.example.quiz.dto.requests;

import com.example.quiz.helper.ProductQuantity;

import java.util.List;

public class SaleAddRequest {
    private Long clientId;
    private String sellerName;
    private List<ProductQuantity> productQuantity;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public List<ProductQuantity> getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(List<ProductQuantity> productQuantity) {
        this.productQuantity = productQuantity;
    }
}

