/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.bean;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author ruthgervandeneikhof
 */
@MessageDriven(name = "testmdb", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/TESTTOPIC")
    ,
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
    ,
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "TESTTOPIC")
    ,
    @ActivationConfigProperty(propertyName = "resourceAdapter", propertyValue = "activemq-rar-5.12.0")

})
public class MessageBean implements MessageListener {

    private static final String FILENAME = "/Users/ruthgervandeneikhof/Desktop/test.txt";
    BufferedWriter bw = null;
    FileWriter fw = null;

    public MessageBean() {
    }

    @Override
    public void onMessage(Message message) {
        System.out.println("Got message " + message);
        try {
            fw = new FileWriter(FILENAME);
        
            bw = new BufferedWriter(fw);
            bw.write("Got message " + message);
        } catch (IOException ex) {
            Logger.getLogger(MessageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (bw != null) {
                bw.close();
            }
            if (fw != null) {
                fw.close();
            }
        } catch (IOException ex) {

            ex.printStackTrace();
        }
    }
}
