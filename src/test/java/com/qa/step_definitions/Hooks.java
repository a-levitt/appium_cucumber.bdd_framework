package com.qa.step_definitions;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.ServerManager;
import io.cucumber.java.*;
import org.apache.logging.log4j.ThreadContext;

public class Hooks {

    @Before
    public void initialize() throws Exception {
        GlobalParams params = new GlobalParams();
        params.initializeGlobalParams();

        ThreadContext.put("ROUTINGKEY", params.getPlatformName() + "_" + params.getDeviceName());

        new ServerManager().startServer();
        new DriverManager().initializeDriver();
    }

    @After
    public void quit() {
        ServerManager serverManager = new ServerManager();
        if (serverManager.getServer() != null) {
            serverManager.getServer().stop();
        }
        DriverManager driverManager = new DriverManager();
        if (driverManager != null) {
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }
        if (driverManager != null) {
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }
    }

}
