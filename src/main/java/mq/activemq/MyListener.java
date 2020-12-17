package mq.activemq;


import javax.jms.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MyListener implements MessageListener {

   public void onMessage(Message message){

       if(message instanceof TextMessage){
           try {

               TextMessage textMessage = (TextMessage)message;
               System.out.println("======"+textMessage.getText());
               System.out.println("======"+message.getJMSType());

           }catch (JMSException e){
               e.printStackTrace();
           }
       }else if(message instanceof ObjectMessage){
            try{
                ObjectMessage objectMessage = (ObjectMessage)message;

                Dog dog = (Dog) objectMessage.getObject();

                System.out.println(dog.toString());
            }catch (JMSException e){

                e.printStackTrace();

            }
       }else if(message instanceof BytesMessage){

//           try {
//            BytesMessage bytesMessage =(BytesMessage) message;
//
//               String utf =  bytesMessage.readUTF();
//               boolean b = bytesMessage.readBoolean();
//               System.out.println(utf);
//               System.out.println(b);
//           }catch (JMSException e){
//               e.printStackTrace();
//           }
             BytesMessage bytesMessage =(BytesMessage) message;
           FileOutputStream out = null;
           try {
               out = new FileOutputStream("d:/aa.txt");
           } catch (FileNotFoundException e2) {
               e2.printStackTrace();
           }
           byte[] by = new byte[1024];
           int len = 0 ;
           try {
               while((len = bytesMessage.readBytes(by))!= -1){
                   out.write(by,0,len);
               }
           } catch (Exception e1) {
               e1.printStackTrace();
           }


       }else if (message instanceof MapMessage){
           MapMessage mapMessage = (MapMessage) message;
           try{

               mapMessage.getString("ysd");
               mapMessage.getInt("age");
               mapMessage.getDouble("price");

               System.out.println(
               mapMessage.getString("ysd")+
               mapMessage.getInt("age")+
               mapMessage.getDouble("price"));
           }catch (Exception e){
                e.printStackTrace();
           }

       }


   };

}
