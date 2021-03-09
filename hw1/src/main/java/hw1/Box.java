package hw1;

import hw1.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {
    private List<T> fruitBox;

    public Box() {
        this.fruitBox = new ArrayList<>();

    }

    public void transfer (Box <? super T> transferBox){
        if(transferBox == this) {return;}
        transferBox.fruitBox.addAll(this.fruitBox);
        this.fruitBox.clear();

    }

    public boolean compare (Box<?> compareBox) {
        return Math.abs(this.getWeight() - compareBox.getWeight()) < 0.0001;
    }

    public float getWeight() {
        float boxWeight = 0.0f;
        for (T fruit: fruitBox) {
            boxWeight += fruit.getWeight();
        }
        return  boxWeight;
    }

    public void add (T fruit) {
        fruitBox.add(fruit);
    }
}
