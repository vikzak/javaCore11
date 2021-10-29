package fruits;

public abstract class Fruit implements Cloneable {
    protected float weight;
    private final String name;

    public Fruit(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                '}';
    }
}
