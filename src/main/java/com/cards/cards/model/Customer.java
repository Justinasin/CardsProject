package com.cards.cards.model;

import com.cards.cards.CustomerType;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Customer {

    @NotNull
    private String name;

    private CustomerType customerType;
    private List<Card> cardList;

    public Customer(String name, CustomerType customerType, List<Card> cardList) {
        this.name = name;
        this.customerType = customerType;
        this.cardList = cardList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }
}
