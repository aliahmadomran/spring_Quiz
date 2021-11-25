package com.example.quiz.models;

import javax.persistence.*;

@Entity
@Table(name = "Clients")
public class Client {
    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName ="client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"

    )
    private Long clientId;
    private  String clientName;
    private String clientLastName;
    private Long clientMobile;

    public Client() {
    }

    public Client(String clientName, String clientLastName, Long clientMobile) {
        this.clientName = clientName;
        this.clientLastName = clientLastName;
        this.clientMobile = clientMobile;
    }

    public Client(Long clientId, String clientName, String clientLastName, Long clientMobile) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientLastName = clientLastName;
        this.clientMobile = clientMobile;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public Long getClientMobile() {
        return clientMobile;
    }

    public void setClientMobile(Long clientMobile) {
        this.clientMobile = clientMobile;
    }
}
