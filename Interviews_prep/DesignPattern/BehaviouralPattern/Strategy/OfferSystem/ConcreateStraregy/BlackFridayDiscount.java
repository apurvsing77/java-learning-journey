package Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.OfferSystem.ConcreateStraregy;

import Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.OfferSystem.DiscountStrategy;

public class BlackFridayDiscount implements DiscountStrategy {

    @Override
    public void applyDiscount() {

    System.out.println("For BlackFridayDiscount 50% discount");
  }
}
