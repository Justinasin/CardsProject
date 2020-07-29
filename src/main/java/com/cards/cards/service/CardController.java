package com.cards.cards.service;

import com.cards.cards.RiskType;
import com.cards.cards.model.Card;
import com.cards.cards.model.Contract;
import com.cards.cards.model.Customer;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.DecimalFormat;
import java.util.List;

@RestController
@Validated
public class CardController {

    @GetMapping("/calculate")
    public String calculatePrice(
        @Valid @RequestBody Contract contract) {

        DecimalFormat df = new DecimalFormat("#.##");
        double premiumAmount = calculatePremium(contract);

        return df.format(premiumAmount);

    }

    private double calculatePremium(Contract contract) {

        double premiumAmount = 0;
        List<Customer> customerList = contract.getCustomerList();

        for (RiskType riskType : RiskType.values()) {
            for (Customer customer : customerList) {
                double sumInsured = customer.getCardList()
                    .stream()
                    .filter(c -> c.getRiskType().equals(riskType))
                    .mapToDouble(Card::getSumInsured)
                    .sum();

                double premiumAmountOfRiskType;
                switch (riskType.getCalculationType()) {
                    case LOWER:
                        if (sumInsured < riskType.getMaxLimit()) {
                            premiumAmountOfRiskType = sumInsured * riskType.getOtherCoefficient();
                        } else {
                            premiumAmountOfRiskType = sumInsured * riskType.getDefaultCoefficient();
                        }
                        premiumAmount += premiumAmountOfRiskType;
                        break;

                    case LOWER_EQ:
                        if (sumInsured <= riskType.getMaxLimit()) {
                            premiumAmountOfRiskType = sumInsured * riskType.getOtherCoefficient();
                        } else {
                            premiumAmountOfRiskType = sumInsured * riskType.getDefaultCoefficient();
                        }
                        premiumAmount += premiumAmountOfRiskType;
                        break;

                    case GREATER:
                        if (sumInsured > riskType.getMaxLimit()) {
                            premiumAmountOfRiskType = sumInsured * riskType.getOtherCoefficient();
                        } else {
                            premiumAmountOfRiskType = sumInsured * riskType.getDefaultCoefficient();
                        }
                        premiumAmount += premiumAmountOfRiskType;
                        break;

                    case GREATER_EQ:
                        if (sumInsured >= riskType.getMaxLimit()) {
                            premiumAmountOfRiskType = sumInsured * riskType.getOtherCoefficient();
                        } else {
                            premiumAmountOfRiskType = sumInsured * riskType.getDefaultCoefficient();
                        }
                        premiumAmount += premiumAmountOfRiskType;
                        break;
                    case DEFAULT:
                        premiumAmountOfRiskType = sumInsured * riskType.getDefaultCoefficient();
                        premiumAmount += premiumAmountOfRiskType;
                        break;
                    default:
                        break;
                }
            }
        }

        return premiumAmount;
    }
}