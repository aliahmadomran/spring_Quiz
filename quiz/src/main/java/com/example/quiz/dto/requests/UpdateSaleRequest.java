package com.example.quiz.dto.requests;


import com.example.quiz.helper.ProductQuantity;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UpdateSaleRequest{
    private Long sid;
    private List<ProductQuantity> productQuantity ;

    public UpdateSaleRequest(Long sid, List<ProductQuantity> productQuantity) {
        this.sid=sid;
        this.productQuantity = productQuantity;
    }

    public UpdateSaleRequest() {
    }

    public UpdateSaleRequest(List<ProductQuantity> productQuantity) {
        this.productQuantity = productQuantity;
    }

    public List<ProductQuantity> getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(List<ProductQuantity> productQuantity) {
        this.productQuantity = productQuantity;
    }
}
