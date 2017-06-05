/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.jms;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author lino_
 */
public class TopicConnector {
    private static final String JNDI_FACTORY = "jms/myConnectionFactory";
    private static final String JNDI_Topic = "jms/TestTopic";
    
    public static void sendMessage(String text){
        Context jndiContext;
        try {
            jndiContext = new InitialContext();
            ConnectionFactory cf = (ConnectionFactory) jndiContext.lookup(JNDI_FACTORY);
            Topic topic = (Topic) jndiContext.lookup(JNDI_Topic);
            
            JMSContext context =  cf.createContext();
            context.createProducer().send(topic, "JMS 2.0 Hallo dit is een bericht");
            context.close();
        } catch (NamingException ex) {
            Logger.getLogger(TopicConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
//    public static void CArigattor(String text){
//        try {
//            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.24.41:61616");
//            
//            // Create a Connection
//            Connection connection = connectionFactory.createConnection();
//            connection.start();
//            
//            // Create a Session
//            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//            
//            // Create the destination (Topic or Queue)
//            Destination destination = session.createTopic("TESTTOPIC");
//            
//            // Create a MessageProducer from the Session to the Topic or Queue
//            MessageProducer producer = session.createProducer(destination);
//            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
//            
//            TextMessage message = session.createTextMessage(text);
//            
//            // Tell the producer to send the message
//            System.out.println("Request has been spread: "+ message.hashCode() + " : " + Thread.currentThread().getName());
//            producer.send(message);
//            
//            // Clean up
//            session.close();
//            connection.close();
//        } catch (JMSException ex) {
//            System.out.println(ex);
//        }    
//    }
}
