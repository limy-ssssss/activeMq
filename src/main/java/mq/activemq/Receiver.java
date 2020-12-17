package mq.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.ArrayList;
import java.util.List;


public class Receiver {

    public static void main(String[] args) throws Exception{
        //1.获取连接工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin","admin", "tcp://127.0.0.1:61616");

        //创建信任对象
       String dogPackageName =  Dog.class.getPackage().getName();
        List param = new ArrayList<String>();
        param.add(dogPackageName);
        connectionFactory.setTrustedPackages(param);
        //创建连接
        Connection connection = connectionFactory.createConnection();
        connection.start();
        //获取session  事物、确认机制
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //获取和创建目的地 destination ,消费端也会从这里取消息
        Destination queue = session.createQueue("user");
        // 写入消息
       MessageConsumer consumer =  session.createConsumer(queue);
        //p 短链接 c 长连接
//        while(true){
//
//            //阻塞 receive(); socket.accept(); I/O 出现瓶颈
//          TextMessage textMessage =  (TextMessage) consumer.receive();
//
//            System.out.println(textMessage.getText());
//
//        }
        //通过监听的方式进行
        /*consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {

            }
        });*/
        consumer.setMessageListener(new MyListener());
    }

}
