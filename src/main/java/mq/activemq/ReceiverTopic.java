package mq.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


public class ReceiverTopic {

    public static void main(String[] args) throws Exception{
        //1.获取连接工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin","admin", "tcp://127.0.0.1:61616");
        //创建连接
        Connection connection = connectionFactory.createConnection();
        connection.start();
        //获取session  事物、确认机制
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //获取和创建目的地 destination ,消费端也会从这里取消息
        Destination queue = session.createTopic("user");
        // 写入消息
       MessageConsumer consumer =  session.createConsumer(queue);
        //p 短链接 c 长连接
        while(true){
          TextMessage textMessage =  (TextMessage) consumer.receive();

            System.out.println(textMessage.getText());

        }

    }

}
