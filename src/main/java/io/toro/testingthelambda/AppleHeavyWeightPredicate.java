package io.toro.testingthelambda;

public class AppleHeavyWeightPredicate implements ApplePredicate {
    public boolean test(Apple apple){
        return apple.getWeight() > 150;
    }
}
