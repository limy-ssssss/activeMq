package design.model.singleton;

public class Test {


    public  static  void main(String[] args){
        Mgr01 mgr01 = Mgr01.getInstance();
        Mgr01 mgr02 = Mgr01.getInstance();

        System.out.println(mgr01==mgr02);	
    	
    	Object o =new Object();
    }



}
