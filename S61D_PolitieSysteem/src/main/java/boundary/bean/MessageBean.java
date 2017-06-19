/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.bean;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import domain.StolenVehicle;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author ruthgervandeneikhof
 */
@MessageDriven(name = "testmdb", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/StolenCarTopic")
    ,
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
    ,
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "StolenCarTopic")
    ,
    @ActivationConfigProperty(propertyName = "resourceAdapter", propertyValue = "activemq-rar-5.12.0")

})
public class MessageBean implements MessageListener {

    Gson gson = new Gson();

    public MessageBean() {
    }

    @Override
    public void onMessage(Message message) {
        System.out.println("Got message " + message);
        TextMessage msg = (TextMessage) message;
        try{
            StolenVehicle ev = gson.fromJson(msg.getText(), StolenVehicle.class);
            
        } catch(JsonSyntaxException | JMSException ex){
            System.out.println(ex.toString());
        }
    }
}
