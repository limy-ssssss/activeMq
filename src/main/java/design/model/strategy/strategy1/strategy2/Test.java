package design.model.strategy.strategy1.strategy2;

import design.model.strategy.strategy1.Cat;
import design.model.strategy.strategy1.Dog;
import design.model.strategy.strategy1.DogComparator;


public class Test {

    public static void main(String[] args){

        double [] test = {11.11,112.3,12.22};
        Dog [] dogs = {new Dog(4),new Dog(3),new Dog(2)};
        Cat[] cats ={new Cat(3,2),new Cat(2,4),new Cat(1,2)};
        Sorter<Dog> sorter = new Sorter<Dog>();

 /*       sorter.sort( dogs,(o1,o2)->{
            if(o1.food<o2.food) return -1;
            else if(o1.food>o1.food) return 1;
            return 0;
        });
        Sorter<Cat> sorter2 = new Sorter<Cat>();

        sorter2.sort( cats,(o1,o2)->{
            if(o1.weight<o2.weight) return -1;
            else if(o1.weight>o1.weight) return 1;
            return 0;
        });*/
        for (Dog d:dogs) {
            System.out.println(d);

        }



    }
}
