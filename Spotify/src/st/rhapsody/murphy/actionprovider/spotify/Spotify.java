/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package st.rhapsody.murphy.actionprovider.spotify;

import org.openide.util.lookup.ServiceProvider;
import st.rhapsody.murphy.actionprovider.ActionProviderMessage;
import st.rhapsody.murphy.interfaces.ActionProvider;

/**
 *
 * @author nicklas
 */
@ServiceProvider(service = ActionProvider.class, position = 10)
public class Spotify implements ActionProvider {

    @Override
    public void process(ActionProviderMessage actionMessage) {
        actionMessage.addResponse("Only me!!!!!!");
    }

    @Override
    public boolean consumesInput() {
        return true;
    }
}
