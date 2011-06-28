/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package st.rhapsody.murphy;

import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openide.modules.ModuleInstall;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.RequestProcessor;
import st.rhapsody.murphy.interfaces.Connector;

/**
 * Manages a module's lifecycle. Remember that an installer is optional and
 * often not needed at all.
 */
public class Installer extends ModuleInstall {

    private ExecutorService threadExecutor;
    private Future<?> coreThread;
    private Core core;

    @Override
    public void restored() {
        Logger.getLogger(Installer.class.getName()).log(Level.INFO, "restored");

        Runnable keepThreadAlive = new Runnable() {
            @Override
            public void run() {
                Logger.getLogger(Installer.class.getName()).log(Level.INFO, "Keep alive");
                if (coreThread == null || coreThread.isCancelled()) {
                    core = new Core();
                    Logger.getLogger(Installer.class.getName()).log(Level.INFO, "Starting Core Thread");
                    threadExecutor = Executors.newSingleThreadExecutor();
                    coreThread = threadExecutor.submit(core);
                }
            }
        };
        RequestProcessor.getDefault().scheduleAtFixedRate(keepThreadAlive, 0, 5, TimeUnit.SECONDS);
    }
}
