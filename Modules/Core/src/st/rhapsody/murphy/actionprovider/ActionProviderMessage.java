/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package st.rhapsody.murphy.actionprovider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Passed trough the chain of registered ActionProviders.
 * Each provider can add a response to the List.
 * 
 * @author nicklas
 */
public class ActionProviderMessage {

    private String channel = "";
    private String sender = "";
    private String message = "";
    private List<String> responses = new ArrayList<String>();

    public ActionProviderMessage(String channel, String sender, String message) {
        this.channel = channel;
        this.sender = sender;
        this.message = message;
    }

    public String getChannel() {
        return channel;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getResponses() {
        return Collections.unmodifiableList(responses);
    }

    public void addResponse(String response) {
        responses.add(response);
    }

    public String getSender() {
        return sender;
    }
}
