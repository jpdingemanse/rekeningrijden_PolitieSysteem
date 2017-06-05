/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.jms;

import java.net.URI;
import java.net.URISyntaxException;
 
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.NamingException;
 
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;



/**
 *
 * @author ruthgervandeneikhof
 */
public class TopicConnector {

    private static final String JNDI_FACTORY = "jms/myConnectionFactory";
    private static final String JNDI_Topic = "jms/TestTopic";

    public static void sendMessage() throws NamingException, URISyntaxException, Exception {
        BrokerService broker = BrokerFactory.createBroker(new URI("broker:(tcp://localhost:61616)"));
        broker.setPersistent(true);
        broker.start();
        TopicConnection topicConnection = null;

        try {
            // Producer
            TopicConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.24.41:61616");
            topicConnection = connectionFactory.createTopicConnection();   
            topicConnection.setClientID("JMSTOPIC");
 
            TopicSession topicConsumerSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);          
            Topic topic = topicConsumerSession.createTopic("TESTTOPIC");
 
            
             topicConnection.start();
             
            // Publish
            TopicSession topicPublisherSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            String payload = "Important Task";
            Message msg = topicPublisherSession.createTextMessage(payload);
            TopicPublisher publisher = topicPublisherSession.createPublisher(topic);
            System.out.println("Sending text '" + payload + "'");
            publisher.publish(msg);

            Thread.sleep(3000);
            topicPublisherSession.close();
            topicConsumerSession.close();


        } catch (Exception ex) {

        }finally {
            if (topicConnection != null) {
                topicConnection.close();
            }
            broker.stop();
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
