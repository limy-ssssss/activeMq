package thread.high.Atomic;


//import sun.misc.Unsafe;

public class MyUnSafe {
    static class M {
        private M() {}

        int i =0;
    }

   public static void main(String[] args) throws InstantiationException {
      /*  Unsafe unsafe = Unsafe.getUnsafe();  // 11 版本就不能直接的引用
        M m = (M)unsafe.allocateInstance(M.class);
        m.i = 9;
        System.out.println(m.i);*/
    }
}
