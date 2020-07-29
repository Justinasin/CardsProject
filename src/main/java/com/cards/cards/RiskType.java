package com.cards.cards;

import static com.cards.cards.CalculationType.GREATER;
import static com.cards.cards.CalculationType.GREATER_EQ;

public enum RiskType {

    FRAUD(0.014, 100, 0.024, GREATER),
    THEFT(0.11, 15, 0.05, GREATER_EQ);

    RiskType(double defaultCoefficient, double maxLimit, double otherCoefficient, CalculationType calculationType) {
        this.defaultCoefficient = defaultCoefficient;
        this.maxLimit = maxLimit;
        this.otherCoefficient = otherCoefficient;
        this.calculationType = calculationType;
    }

    private double defaultCoefficient;
    private double maxLimit;
    private double otherCoefficient;
    private CalculationType calculationType;

    public double getDefaultCoefficient() {
        return defaultCoefficient;
    }

    public double getMaxLimit() {
        return maxLimit;
    }

    public double getOtherCoefficient() {
        return otherCoefficient;
    }

    public CalculationType getCalculationType() {
        return calculationType;
    }
}
