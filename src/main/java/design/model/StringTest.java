package design.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class StringTest {

    public static void main(String[] args){
        String a ="410955socid5115010a000a00";

        String b ="88888888888";
        String c ="socid";


        a=a.replace(c,b);

        String as ="请扫描右下方二维码，获取最新节目授权！";
        int lea ="1e4dE8AFB7E689ABE68F8FE58FB3E4B88BE696B9E4BA8CE7BBB4E7A081EFBC8CE88EB7E58F96E69C80E696B0E88A82E79BAEE68E88E69D83EFBC81".length();
        System.out.println(lea+"===lea");
        try {
            String str = URLEncoder.encode(as, "utf-8").replaceAll("%", "");
            System.out.println(str +"==========");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(a);
    }
}
