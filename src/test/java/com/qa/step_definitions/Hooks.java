package com.qa.step_definitions;

import com.qa.utils.GlobalParams;
import com.qa.utils.ServerManager;
import io.cucumber.java.*;
import org.apache.logging.log4j.ThreadContext;

public class Hooks {

    @Before
    public void initialize() {
        GlobalParams params = new GlobalParams();
        params.initializeGlobalParams();

        ThreadContext.put("ROUTINGKEY", params.getPlatformName() + "_" + params.getDeviceName());

        new ServerManager().startServer();
    }

    @After
    public void quit() {
        ServerManager serverManager = new ServerManager();
        if (serverManager.getServer() != null) {
            serverManager.getServer().stop();
        }
    }

}
