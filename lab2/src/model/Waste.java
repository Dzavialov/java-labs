package model;

public class Waste implements IWeight {
    float weight;

    public Waste(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public float weight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Waste{" + "weight = " + weight + '}';
    }
}
