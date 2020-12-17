package design.model.strategy.strategy1;

/***
 * 函数式接口，可以实现lamd表达式 1.8之后可以写方法实现  default 原有接口不用实现该方法
 * Comparator子类实现比较大小的方式
 * @param <T>
 */
@FunctionalInterface
public interface Comparator<T> {
    int compare(T o1, T o2);

 /*   default void m() {
        System.out.println("m");
    }*/
}
