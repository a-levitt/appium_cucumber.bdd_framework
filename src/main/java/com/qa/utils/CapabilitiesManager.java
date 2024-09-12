package com.qa.utils;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class CapabilitiesManager {
    TestUtils utils = new TestUtils();

    public UiAutomator2Options getAndroidOptions() throws IOException {
        GlobalParams params = new GlobalParams();
        Properties props = new PropertyManager().getProps();

        utils.log().info("getting android options");

        String AndroidAppPath =
                System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                        + File.separator + "resources" + File.separator +
                        "apps" + File.separator + "Android.SauceLabs.Mobile.Sample.app.2.7.1.apk";

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName(params.getPlatformName())
                .setUdid(params.getUdid())
                .setDeviceName(params.getDeviceName());
        options.setAutomationName(props.getProperty("AndroidAutomationName"));
        options.setUnlockType(props.getProperty("deviceUnlockType"));
        options.setUnlockKey(props.getProperty("deviceUnlockKey"));
        options.setAppWaitActivity(props.getProperty("AndroidAppWaitActivity"));
        options.setAppPackage(props.getProperty("AndroidAppPackage"));
        options.setAppActivity(props.getProperty("AndroidAppActivity"));
        options.setSystemPort(10000);
        options.setChromedriverPort(10001);
        utils.log().info("appUrl is" + AndroidAppPath);
        options.setApp(AndroidAppPath);

        return options;
    }

    public XCUITestOptions getIOSOptions() throws IOException {
        GlobalParams params = new GlobalParams();
        Properties props = new PropertyManager().getProps();

        utils.log().info("getting ios options");

        String iOSAppPath =
                System.getProperty("user.dir") + File.separator + "src" + File.separator +
                        "main" + File.separator + "resources" + File.separator +
                        "app" + File.separator + "iOS.Simulator.SauceLabs.Mobile.Sample.app.2.7.1.app";

        XCUITestOptions iOSOptions = new XCUITestOptions()
                .setPlatformName(params.getPlatformName())
                .setUdid(params.getUdid())
                .setDeviceName(params.getDeviceName());
        iOSOptions.setAutomationName(props.getProperty("iOSAutomationName"));
        utils.log().info("appUrl is" + iOSAppPath);
        iOSOptions.setBundleId(props.getProperty("iOSBundleId"));
        iOSOptions.setWdaLocalPort(10002);
        iOSOptions.simpleIsVisibleCheck();
        iOSOptions.setApp(iOSAppPath);

        return iOSOptions;
    }
}