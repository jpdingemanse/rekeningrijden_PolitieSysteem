/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.jms;

import javax.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 *
 * @author lino_
 */
public class TopicConnector {
//    public void TopicListener(){
//    try{
//            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.24.41:61616");
//            Connection connection = connectionFactory.createConnection();
//            
//            // need to setClientID value, any string value you wish
//            connection.setClientID("NED2");
//            
//            try{
//                connection.start();
//            }catch(JMSException e){
//                System.err.println("NOT CONNECTED!!!");
//            }
//            Session session = connection.createSession(false,
//                    Session.AUTO_ACKNOWLEDGE);
//            
//            Topic topic = session.createTopic("PolitieSysteem.mq");
//            
//            //need to use createDurableSubscriber() method instead of createConsumer() for topic
//            // MessageConsumer consumer = session.createConsumer(topic);
//            MessageConsumer consumer = session.createDurableSubscriber(topic,
//                    "NED2");
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

    
    public static void CArigattor(String text){
        try {
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.24.41:61616");
            
            // Create a Connection
            Connection connection = connectionFactory.createConnection();
            connection.start();
            
            // Create a Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            
            // Create the destination (Topic or Queue)
            Destination destination = session.createTopic("PolitieSysteem.mq");
            
            // Create a MessageProducer from the Session to the Topic or Queue
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            
            TextMessage message = session.createTextMessage(text);
            
            // Tell the producer to send the message
            System.out.println("Request has been spread: "+ message.hashCode() + " : " + Thread.currentThread().getName());
            producer.send(message);
            
            // Clean up
            session.close();
            connection.close();
        } catch (JMSException ex) {
            System.out.println(ex);
        }    
    }
}
