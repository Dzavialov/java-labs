package model;

public class Timber {
    private Wood wood;
    private float length;
    private float height;
    private float width;

    public Timber(Wood wood, float length,float height,float width){
        this.wood = wood;
        this.length = length;
        this.height = height;
        this.width = width;
    }

    public Wood getWood(){
        return wood;
    }

    public float getLength(){
        return length;
    }

    public float getHeight(){
        return height;
    }

    public float getWidth(){
        return width;
    }

    public float volume(){
        return length*height*width;
    }

    public float weight(){
        return wood.getDensity() * volume();
    }

    @Override
    public String toString() {
        return "Timber{" + "wood: " + wood.getName() + ", weight = " + weight() + '}';
    }
}
