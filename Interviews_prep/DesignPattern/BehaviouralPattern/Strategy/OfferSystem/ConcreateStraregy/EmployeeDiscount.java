package Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.OfferSystem.ConcreateStraregy;

import Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.OfferSystem.DiscountStrategy;

public class EmployeeDiscount implements DiscountStrategy {
    @Override
    public void applyDiscount() {
    System.out.println("For Employee it is 35% discount");
    }
}
