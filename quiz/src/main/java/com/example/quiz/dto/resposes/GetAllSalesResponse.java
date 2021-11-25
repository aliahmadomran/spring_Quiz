package com.example.quiz.dto.resposes;

import com.example.quiz.models.Client;

import java.time.LocalDateTime;

public class GetAllSalesResponse {
    private Long saleId;
    private Client client;
    private Double total;
    private String sellerName;
    private LocalDateTime saleCreationDate;

    public GetAllSalesResponse() {
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public LocalDateTime getSaleCreationDate() {
        return saleCreationDate;
    }

    public void setSaleCreationDate(LocalDateTime saleCreationDate) {
        this.saleCreationDate = saleCreationDate;
    }
}

