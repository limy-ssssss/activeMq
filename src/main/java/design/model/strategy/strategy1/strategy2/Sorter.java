package design.model.strategy.strategy1.strategy2;


import design.model.strategy.strategy1.Comparator;

public class Sorter<T> {

    public void sort(T[] arr, Comparator<T> comparator) {

        for(int i=0;i<arr.length;i++){

                int min = i;
            for(int j=0;j<arr.length;j++){

                min = comparator.compare(arr[i],arr[j])<0 ? i : j;

            }

           swap(arr,i,min);
        }
    }

    public void swap(T[] arg ,int i, int j){
        // 升序
        T temp = arg[i]; // 当前值为临时值
        arg[i] =  arg[j]; // 最小值 为当前值
        arg[j] = temp;      // 当前值放到 另外一个位置(保证数组值不变)
    }


    public void sortInt(int[] arg){

        for(int i=0;i<arg.length;i++){

            int min = i;
            for(int j=0;j<arg.length;j++){

                min = arg[i]<arg[j] ? i : j;

            }

             swapInt(arg,i,min);
        }
    }

    public void swapInt(int [] arg ,int i, int j){
        // 升序
        int temp = arg[i]; // 当前值为临时值
        arg[i] =  arg[j]; // 最小值 为当前值
        arg[j] = temp;      // 当前值放到 另外一个位置(保证数组值不变)
    }
}
