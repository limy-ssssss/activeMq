package design.model.strategy.strategy1.strategy2;

@FunctionalInterface
public interface Comparator<T> {
    int compare(T o1, T o2);

    /*default void m() {
        System.out.println("m");
    }*/
}
