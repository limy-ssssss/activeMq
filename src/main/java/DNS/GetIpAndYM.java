
package DNS;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.xbill.DNS.Address;

/**
 * @author  limy
 * @date  2020年12月29日 下午3:49:55
 * @version 1.0
 */
public class GetIpAndYM {
	//https://blog.csdn.net/renjianlele/article/details/79671370
	public static void main(String[] args) {
		try {
		/*	String hostName  = Address.getHo\stName(InetAddress.getByName("114.251.156.70"));
			 System.out.println(hostName);
		*/
			 String localhost = InetAddress.getLoopbackAddress().getHostAddress();
			 
			 String localhost2 = InetAddress.getLocalHost().getHostAddress();
			 System.out.println(localhost);
			 System.out.println(localhost2);
			   String name = "www.baidu.com";
			   String name1 = "sms.huhutv.com.cn";
	            InetAddress[] addresses = InetAddress.getAllByName(name1);
	            for (int i = 0; i < addresses.length; i++) {
	                System.out.println(name + "[" + i + "]: "
	                        + addresses[i].getHostAddress());
	            }
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
