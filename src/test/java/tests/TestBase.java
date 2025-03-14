package tests;

import manager.ApplicationManager;
import manager.TestNGListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import java.lang.reflect.Method;

@Listeners(TestNGListener.class)



public class TestBase {


    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startLogger(Method m){
        logger.info("Name of method--->"+m.getName());
    }

   static ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setApp(){

        app. init();
    }

    @AfterSuite
    public void tearDown(){

        app.stop();
    }
}
