package io.toro.testingthelambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestingthelambdaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestingthelambdaApplication.class, args);
		List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(115, "green"),
                new Apple(125, "red"),
                new Apple(155, "red"),
				new Apple(120, "yellow"));
		List<Apple> heavyApples =
				filterApples(inventory, new AppleHeavyWeightPredicate());
		List<Apple> greenApples =
				filterApples(inventory, new AppleGreenColorPredicate());
        List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
            public boolean test(Apple apple){
                return "red".equals(apple.getColor());
            }
            });
        List<Apple> yellowApples = filterApples( inventory, (Apple apple) -> "yellow".equals( apple.getColor() ) );
        prettyPrintApple(greenApples, new AppleFancyFormatter());
        prettyPrintApple(redApples, new AppleFancyFormatter());
        prettyPrintApple(yellowApples, new AppleFancyFormatter());

	}
    private static List<Apple> filterApples( List<Apple> inventory,
            ApplePredicate p ) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory){
            if (p.test(apple)){
                result.add(apple);
            } }
        return result;
    }
    public static void prettyPrintApple(List<Apple> inventory,
            AppleFormatter formatter){
        for(Apple apple: inventory){
            String output = formatter.accept(apple);
            System.out.println(output);
        } }

}

class AppleFancyFormatter implements AppleFormatter{
    public String accept(Apple apple){
        String characteristic = apple.getWeight() > 150 ? "heavy" :
                "light";
        return "A " + characteristic +
                " " + apple.getColor() +" apple";
    }
}

class AppleSimpleFormatter implements AppleFormatter{
    public String accept(Apple apple){
        return "An apple of " + apple.getWeight() + "g";
    }
}
