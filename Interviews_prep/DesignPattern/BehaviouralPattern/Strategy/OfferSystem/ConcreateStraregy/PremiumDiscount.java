package Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.OfferSystem.ConcreateStraregy;

import Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.OfferSystem.DiscountStrategy;

public class PremiumDiscount implements DiscountStrategy {
    @Override
    public void applyDiscount() {
    System.out.println("for PREMIUM person 20% discount ");
    }
}
