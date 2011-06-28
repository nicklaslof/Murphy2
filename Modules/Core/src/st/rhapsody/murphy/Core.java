/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package st.rhapsody.murphy;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openide.util.Lookup;
import st.rhapsody.murphy.interfaces.Connector;

/**
 *
 * @author nicklas
 */
public class Core implements Runnable {

    @Override
    public void run() {
            Logger.getLogger(Installer.class.getName()).log(Level.INFO, "Initalizing connectors");
            Collection<? extends Connector> lookupAll = Lookup.getDefault().lookupAll(Connector.class);
            for (Connector connector : lookupAll) {
                connector.initalize();
            }
    }
}
