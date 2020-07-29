package com.cards.cards.model;

import com.cards.cards.CardType;
import com.cards.cards.RiskType;

public class Card {

    private CardType cardType;
    private double sumInsured;
    private RiskType riskType;

    public Card(CardType cardType, double sumInsured, RiskType riskType) {
        this.cardType = cardType;
        this.sumInsured = sumInsured;
        this.riskType = riskType;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public double getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(double sumInsured) {
        this.sumInsured = sumInsured;
    }

    public RiskType getRiskType() {
        return riskType;
    }

    public void setRiskType(RiskType riskType) {
        this.riskType = riskType;
    }
}
