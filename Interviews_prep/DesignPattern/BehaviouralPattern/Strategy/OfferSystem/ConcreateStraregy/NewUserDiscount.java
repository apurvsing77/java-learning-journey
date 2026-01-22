package Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.OfferSystem.ConcreateStraregy;

import Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.OfferSystem.DiscountStrategy;

public class NewUserDiscount implements DiscountStrategy {
    @Override
    public void applyDiscount() {

    System.out.println("For NEW_USER 10% discount");
    }
}

