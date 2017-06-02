/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.jms;

//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.jms.*;
//import javax.xml.bind.Marshaller.Listener;
//import org.apache.activemq.ActiveMQConnectionFactory;

/**
 *
 * @author lino_
 */
public class TopicConnector {
//    public void TopicListener(){
//    try{
//            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://locahost:61616");
//            Connection connection = connectionFactory.createConnection();
//            connection.start();
//            
//            // need to setClientID value, any string value you wish
//            connection.setClientID("12345");
//            
//            try{
//                connection.start();
//            }catch(Exception e){
//                System.err.println("NOT CONNECTED!!!");
//            }
//            Session session = connection.createSession(false,
//                    Session.AUTO_ACKNOWLEDGE);
//            
//            Topic topic = session.createTopic("RequestTopic.mq");
//            
//            //need to use createDurableSubscriber() method instead of createConsumer() for topic
//            // MessageConsumer consumer = session.createConsumer(topic);
//            MessageConsumer consumer = session.createDurableSubscriber(topic,
//                    "SUB1234");
//            
//            MessageListener listner = new MessageListener() {
//                public void onMessage(Message message) {
//                    try {
//                        if (message instanceof TextMessage) {
//                            TextMessage textMessage = (TextMessage) message;
//                            System.out.println("Received message"
//                                    + textMessage.getText() + "'");
//                        }
//                    } catch (JMSException e) {
//                        System.out.println("Caught:" + e);
//                        e.printStackTrace();
//                    }
//                }
//            };
//            
//            consumer.setMessageListener(listner);
//            //connection.close();
//        }catch(JMSException ex){
//            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
