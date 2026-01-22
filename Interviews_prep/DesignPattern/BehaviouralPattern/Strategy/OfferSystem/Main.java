package Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.OfferSystem;

import Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.OfferSystem.ConcreateStraregy.BlackFridayDiscount;
import Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.OfferSystem.ConcreateStraregy.EmployeeDiscount;
import Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.OfferSystem.ConcreateStraregy.NewUserDiscount;
import Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.OfferSystem.ConcreateStraregy.PremiumDiscount;
import Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.OfferSystem.Cotext.OrderProcessor;

public class Main {
    public static void main(String[] args){
        OrderProcessor forNewUser = new OrderProcessor(new NewUserDiscount());
        OrderProcessor forPremiumUser = new OrderProcessor(new PremiumDiscount());
        OrderProcessor forBlackFriday = new OrderProcessor(new BlackFridayDiscount());

    OrderProcessor forEmployee = new OrderProcessor(new EmployeeDiscount());

        forNewUser.getDiscount();
        forPremiumUser.getDiscount();
        forBlackFriday.getDiscount();
        forEmployee.getDiscount();

    }
}
