/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package st.rhapsody.murphy.connector.irc;

import java.io.IOException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.PircBot;
import org.jibble.pircbot.TrustingSSLSocketFactory;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;
import st.rhapsody.murphy.actionprovider.ActionProviderMessage;
import st.rhapsody.murphy.interfaces.ActionProvider;
import st.rhapsody.murphy.interfaces.Connector;

/**
 *
 * @author nicklas
 */
@ServiceProvider(service = Connector.class)
public class IRCConnector extends PircBot implements Connector {

    @Override
    public void initalize() {
        Logger.getLogger(IRCConnector.class.getName()).log(Level.INFO, "{0} initalized!", IRCConnector.class.getSimpleName());
        try {
            setVerbose(true);
            setName("Murphy2");
            setEncoding("ISO8859-1");

            connect("lego.rhapsody.st", 9999, new TrustingSSLSocketFactory());
            joinChannel("#workaholics-r-us2");
        } catch (IOException iOException) {
            iOException.printStackTrace();
        } catch (IrcException ircException) {
            ircException.printStackTrace();
        }
    }

    @Override
    protected void onMessage(String channel, String sender, String login, String hostname, String message) {
        Collection<? extends ActionProvider> actions = Lookup.getDefault().lookupAll(ActionProvider.class);

        ActionProviderMessage actionMessage = new ActionProviderMessage(channel, sender, message);

        for (ActionProvider action : actions) {
            action.process(actionMessage);
            if (action.consumesInput()) {
                break;
            }
        }

        for (String response : actionMessage.getResponses()) {
            sendMessage(actionMessage.getChannel(), response);
        }
    }
}
