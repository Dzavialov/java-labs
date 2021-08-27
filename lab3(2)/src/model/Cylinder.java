package model;

public class Cylinder extends AbstractForm{
    private float length;
    private float diameter;

    public Cylinder(Wood wood, float length, float diameter) throws Exception {
        super(wood);
        if(length <= 0 || length > 100) {
            throw new Exception(length + " is not correct!\n" + "must be from 0 to 100");
        }
        this.length = length;
        if (diameter <= 0 || diameter > 100) {
            throw new Exception(diameter + "is not correct!\n" + "must be from 0 to 100");
        }
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
