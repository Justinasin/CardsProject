package com.cards.cards.model;

import com.cards.cards.ContractStatus;

import java.util.List;

public class Contract {

    private String id;
    private ContractStatus status;
    private List<Customer> customerList;

    public Contract(String id, ContractStatus status, List<Customer> customerList) {
        this.id = id;
        this.status = status;
        this.customerList = customerList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ContractStatus getStatus() {
        return status;
    }

    public void setStatus(ContractStatus status) {
        this.status = status;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
