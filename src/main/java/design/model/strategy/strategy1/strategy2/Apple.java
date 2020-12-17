package design.model.strategy.strategy1.strategy2;

public class Apple implements Comparable {

    double volume , price;
    private Object o;

    public Apple(double volume, double price) {
        this.volume = volume;
        this.price = price;
    }

    public int compareTo(Object o) {
        Apple o1 = (Apple)o;
        if(this.volume<o1.volume){
            return -1;
        }else if(this.volume>o1.volume){
            return 1;
        }else{
            return 0;
        }

    }

}
