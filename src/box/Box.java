package box;

import fruits.Fruit;
import java.util.ArrayList;

public class Box<T extends Fruit> {
    private final String name;
    private final ArrayList<T> fruits = new ArrayList<>();
    public Box(ArrayList<T> fruits, String name) {
        this.name = name;
        this.fruits.addAll(fruits);
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public void addAllFruits(ArrayList<T> allFruits) {
        fruits.addAll(allFruits);
    }

    public float getWeight() {
        if (fruits.size() != 0) {
            return fruits.size() * fruits.get(0).getWeight();
        }
        return 0;
    }

    public boolean compare(Box<?> box) {
        return (Math.abs(this.getWeight() - box.getWeight()) < 0.0001);
    }

    public ArrayList<T> decrease(int quantity) throws CloneNotSupportedException {
        ArrayList<T> returnArray = new ArrayList<>();
        // если хотим забрать фруктов больше, чем есть в корзине, то отдаем всё, что есть
        if (fruits.size() < quantity) {
            quantity = fruits.size();
        }

        for (int i = fruits.size() - quantity; i < fruits.size(); i++) {
            returnArray.add((T) fruits.get(i).clone());
        }
        fruits.subList(fruits.size() - quantity, fruits.size()).clear();

        return returnArray;
    }

    public void addFruitsFromBox(Box<T> box, int quantity) throws CloneNotSupportedException {
        fruits.addAll(box.decrease(quantity));
    }

    public void show() {
        System.out.println(name + " : " + fruits);
    }
}

