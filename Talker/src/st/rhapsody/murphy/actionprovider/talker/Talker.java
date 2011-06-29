/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package st.rhapsody.murphy.actionprovider.talker;

import org.openide.util.lookup.ServiceProvider;
import st.rhapsody.murphy.actionprovider.ActionProviderMessage;
import st.rhapsody.murphy.interfaces.ActionProvider;

/**
 *
 * @author nicklas
 */
@ServiceProvider(service = ActionProvider.class, position = 100)
public class Talker implements ActionProvider {

    @Override
    public void process(ActionProviderMessage actionMessage) {
        StringBuilder sb = new StringBuilder();
        actionMessage.addResponse(sb.append(actionMessage.getMessage()).reverse().toString());
    }

    @Override
    public boolean consumesInput() {
        return false;
    }
}
