package Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.OfferSystem.Cotext;

import Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.OfferSystem.DiscountStrategy;

public class OrderProcessor {
    DiscountStrategy discount;

    public OrderProcessor(DiscountStrategy discount) {
        this.discount = discount;
    }
    public void getDiscount(){
        discount.applyDiscount();
    }
}
