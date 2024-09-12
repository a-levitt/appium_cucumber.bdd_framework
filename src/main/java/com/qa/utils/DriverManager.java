package com.qa.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DriverManager {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    GlobalParams params = new GlobalParams();

    public AppiumDriver getDriver() {
        return driver.get();
    }

    public void setDriver(AppiumDriver driver2) {
        driver.set(driver2);
    }

    public void initializeDriver() throws Exception {
        AppiumDriver driver = null;
        PropertyManager props = new PropertyManager();
        TestUtils utils = new TestUtils();

        if (driver == null) {
            try {
                utils.log().info("initialize appium driver");

                switch (params.getPlatformName()) {
                    case "Android":
                        driver = new AndroidDriver(new ServerManager().getServer().getUrl(), new CapabilitiesManager().getAndroidOptions());
                        break;
                    case "iOS":
                        driver = new IOSDriver(new ServerManager().getServer().getUrl(), new CapabilitiesManager().getIOSOptions());
                        break;
                }
                if (driver == null) {
                    throw new Exception("driver is null. ABORT!!!");
                }
                utils.log().info("Driver is initialized");
                this.driver.set(driver);
            } catch (Exception e) {
                e.printStackTrace();
                utils.log().fatal("Driver initialization failure. ABORT!" + e.toString());
                throw e;
            }
        }
    }
}
