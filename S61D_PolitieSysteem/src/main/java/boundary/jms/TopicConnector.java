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
    private static final String JNDI_Topic = "jms/StolenCarTopic";

    public static void sendMessage(String text) throws NamingException, URISyntaxException, Exception {
        TopicConnection topicConnection = null;

        try {
            // Producer
            TopicConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.24.38:61616");
            topicConnection = connectionFactory.createTopicConnection();   
            topicConnection.setClientID("JMSTOPIC");
 
            TopicSession topicConsumerSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);          
            Topic topic = topicConsumerSession.createTopic("StolenCarTopic");
 
            
             topicConnection.start();
             
            // Publish
            TopicSession topicPublisherSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            Message msg = topicPublisherSession.createTextMessage(text);
            TopicPublisher publisher = topicPublisherSession.createPublisher(topic);
            System.out.println("Sending text '" + text + "'");
            publisher.publish(msg);

            Thread.sleep(3000);
            topicPublisherSession.close();
            topicConsumerSession.close();


        } catch (Exception ex) {

        }finally {
            if (topicConnection != null) {
                topicConnection.close();
            }
        }


    }
}
