package io.toro.testingthelambda;

public class Apple {

    private String color;

    private int weight;

    public Apple( int i, String green ) {
        this.weight = i;
        this.color = green;
    }

    public String getColor() {
        return color;
    }

    public void setColor( String color ) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight( int weight ) {
        this.weight = weight;
    }
}
