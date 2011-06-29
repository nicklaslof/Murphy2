/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package st.rhapsody.murphy.actionprovider.yrweather;

import org.openide.util.lookup.ServiceProvider;
import st.rhapsody.murphy.actionprovider.ActionProviderMessage;
import st.rhapsody.murphy.interfaces.ActionProvider;

/**
 *
 * @author nicklas
 */
@ServiceProvider(service = ActionProvider.class, position = 200)
public class YrWeather implements ActionProvider {

    @Override
    public void process(ActionProviderMessage actionMessage) {
        actionMessage.addResponse("response from a new module");
    }

    @Override
    public boolean consumesInput() {
        return false;
    }
}
