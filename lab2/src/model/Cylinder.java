package model;

public class Cylinder extends AbstractForm{
    private float length;
    private float diameter;

    public Cylinder(Wood wood, float length, float diameter) {
        super(wood);
        this.length = length;
        this.diameter = diameter;
    }

    @Override
    public float volume() {
        return (float) (Math.PI * (diameter/2 * diameter/2) * length);
    }

    public float getLength() {
        return length;
    }

    public float getDiameter() {
        return diameter;
    }

    @Override
    public String toString() {
        return "Cylinder{" + "wood = " + wood.getName() + ", length = " + length + ", diameter = " + diameter + '}';
    }
}
