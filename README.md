Cucumber BDD framework with Appium:

What are we automating?
=========================
Sauce Lab's demo mobile app
GitHub: https://github.com/saucelabs/sample-app-mobile
Releases (Latest APKs and IPAs): https://github.com/saucelabs/sample-app-mobile/releases

Login Feature file
Scenarios:
Login with an invalid user name
Login with an invalid password
Login with a valid user name and password

Products Feature file
Scenarios:
Validate product info on Products page
Validate product info on Product Details page

Steps:
=======

1. IntelliJ setup for Cucumber
   ===============================
   https://www.jetbrains.com/idea/download/#section=windows
   Download community edition
   Install by selecting default options
   Launch
   Select default options
   Configure -> Plugins -> Search Cucumber -> Install plugin "Cucumber for Java".
   It will ask to install Gherkin plugin as well.
   Restart IDE

2. Maven setup
   ===============
   https://maven.apache.org/download.cgi
   Download Zip
   Unzip and copy to say c:\maven

Windows:
Edit System environment variable PATH and add c:\maven\bin
Open command prompt and type mvn -v

Mac:
On macOS 10.15 Catalina and later, default shell is zsh:
--------------------------------------------------------
-> Navigate to home directory: cd ~/
-> Open zshrc file: open -e .zshrc
-> Add below entry:
export MAVEN_HOME=path_upto_maven_folder
export PATH="${MAVEN_HOME}/bin:${PATH}"
-> source .zshrc
-> echo $MAVEN_HOME
-> mvn -v

For any issue, you can always refer Maven website or search on internet. This is fairly simple setup.

3. Create new Maven project
   ============================

4. Add Cucumber JVM and Cucumber-JUnit dependencies
   ===================================================
   https://cucumber.io/docs/installation/java/
   https://cucumber.io/docs/cucumber/api/#junit

5. Add other dependencies: Appium, JSON, Log4J2
   ===============================================

6. Create Runner file: src/test/java/com/qa/runners/MyRunnerTest
   ========================
   [glue, features]

7. Create feature files:
   ===========================
   src/test/resources/Login.feature and Products.feature
   Gherkin basics - https://cucumber.io/docs/gherkin/reference/

8. Create step definition files:
   ================================
   src/test/java/com/qa/stepdef: Login and Products
   https://cucumber.io/docs/gherkin/step-organization/

9. Copy apps to src/test/resources/app
   =====================================

10. Copy config.properties and log4j2.xml
    =========================================
    log4j2 configurations: https://github.com/omprakashchavan01/log4j2_properties

11. Copy TestUtils class to src/main/java/com/qa/utils
    ======================================================

12. Create hooks under src/test/java/stepdef
    =============================================

13. Create GlobalParams under src/main/java/com/qa/utils
    ========================================================
    platformName, udid, deviceName, systemPort,chromeDriverPort, wdaLocalPort, webkitDebugProxyPort

14. Initialise global params and add Thread Context for Log4j2 in Before hook
    ========================

15: Create ServerManager
===========================
Programmatically start Appium Server (Mac and Windows):

16. Start server in Before hook and stop service in After hook
    =============================================================

17. Create PropertyManager
    ===========================

18. Create CapabilitiesManager
    =============================

19. Create DriverManager
    ===========================

20. Initialise driver in Before hook and Quit in After hook (and set to null)
    ====================================

21. Add Base Page and Page Objects
    ===================================
    Page Object Model design and Scrolling: Refer TDD framework

22. Update step definition files with actual code
    ================================================

23. Execute Runner and "mvn test" with parameters
    ================================================

24. Embed Screenshot in Before hook
    =====================================

25. Create VideoManager
    ========================
    Refer TDD framework

26. Start video in Before hook and stop in After hook
    =========================

27. Moving server and driver initialisation from Cucumber hooks to JUnit's BeforeClass and AfterClass
    ===============================

28. Execute Runner and execute "mvn test" with parameters
    =========================================================

29. Import project on Mac and execute for iOS using terminal
    ==============================================
    Revise mvn setup
    navigate to home directory cd ~/
    open -e .zshrc

30. Execute for both iOS and Android in parallel
    ================================================