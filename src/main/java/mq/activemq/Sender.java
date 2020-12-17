package mq.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


public class Sender {

    public static void main(String[] args) throws Exception{
        //1.获取连接工厂
      //  ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,ActiveMQConnectionFactory.DEFAULT_PASSWORD, "tcp://127.0.0.1:61616");
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin","admin", "tcp://127.0.0.1:61616");

        //创建连接
        Connection connection = connectionFactory.createConnection();
        connection.start();
        //获取session  事物、确认机制
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //开启事物后需要提交事物才会持久化消息 ,可以逐条提交也可以批量提交
        //k开启事物后第二个参数为啥不生效了

        //获取和创建目的地 destination ,消费端也会从这里取消息
        Destination queue = session.createQueue("user");
        // 写入消息
       MessageProducer producer =  session.createProducer(queue);

        for(int num=0;num<100;num++){
            //创建消息
           if(num % 4==0){
               TextMessage textMessage = session.createTextMessage("hello"+num);

               //设置优先级 producer producer.setPriority(9)设置是全局的设置
               //producer.setPriority(9);
               //消息 持久化方式 优先级别 延时
               producer.send(textMessage, DeliveryMode.PERSISTENT, 8, 1000*100);
               System.out.println(textMessage.getText());
           }else{
               TextMessage textMessage = session.createTextMessage("dog"+num);

               producer.send(textMessage);
               System.out.println(textMessage.getText());
           }

           // session.commit();


        }

        connection.close();

    }

}
