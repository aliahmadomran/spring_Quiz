package com.example.quiz.models;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Sales")
public class Sale {

    @Id
    @SequenceGenerator(
            name = "sale_sequence",
            sequenceName ="sale_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sale_sequence"

    )
    private Long saleId;
    private LocalDateTime saleCreationDate;
    private String sellerName;
    private  Double total;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(
            name = "client_id",
            referencedColumnName = "clientId"
    )
    private Client client;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "sale_id",
            referencedColumnName = "saleId")
    private List<Bill> bill;

    public Sale() {
    }

    public Sale(Long saleId, LocalDateTime saleCreationDate, String sellerName, Double total, Client client, List<Bill> bill) {
        this.saleId = saleId;
        this.saleCreationDate = saleCreationDate;
        this.sellerName = sellerName;
        this.total = total;
        this.client = client;
        this.bill = bill;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public LocalDateTime getSaleCreationDate() {
        return saleCreationDate;
    }

    public void setSaleCreationDate(LocalDateTime saleCreationDate) {
        this.saleCreationDate = saleCreationDate;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Bill> getBill() {
        return bill;
    }

    public void setBill(List<Bill> bill) {
        this.bill = bill;
    }

    public Sale(LocalDateTime saleCreationDate, String sellerName, Double total, Client client, List<Bill> bill) {
        this.saleCreationDate = saleCreationDate;
        this.sellerName = sellerName;
        this.total = total;
        this.client = client;
        this.bill = bill;


    }
}
