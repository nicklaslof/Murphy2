/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package st.rhapsody.murphy.interfaces;

import st.rhapsody.murphy.actionprovider.ActionProviderMessage;

/**
 *
 * ActionProvider classes must register trough the ServiceProvider annotation.
 * Example:
 * @ServiceProvider(service = ActionProvider.class, position = 10)
 * 
 * The position attribute is used for sorting in which order each ActionProvider is called.
 * 
 * ActionProviders returning true for consumesInput() will stop the chain and response will be sent from the connector.
 * 
 * 
 * @author nicklas
 */
public interface ActionProvider {

    public void process(ActionProviderMessage actionMessage);

    public boolean consumesInput();
}
