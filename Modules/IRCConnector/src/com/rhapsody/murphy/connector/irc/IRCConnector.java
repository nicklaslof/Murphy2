/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rhapsody.murphy.connector.irc;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openide.util.lookup.ServiceProvider;
import st.rhapsody.murphy.interfaces.Connector;

/**
 *
 * @author nicklas
 */
@ServiceProvider(service=Connector.class)
public class IRCConnector implements Connector{
    @Override
    public void initalize() {
        Logger.getLogger(IRCConnector.class.getName()).log(Level.INFO, "{0} initalized!", IRCConnector.class.getSimpleName());
    }
    
}
