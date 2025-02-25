package tests;

import models.User;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactsTest extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("d@gmail.com").setPassword("DariaM1991!"));
        }
       // app.getHelperContact().provideContacts();
    }


        @Test
        public void removeFirstContact () {

        }

        @Test
        public void removeAllContact () {

        }
    }
