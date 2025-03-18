package tests;

import models.User;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactsTest extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("d@gmail.com").setPassword("DariaM1991!"));
        }
       app.getHelperContact().provideContacts();
    }


        @Test(groups = {"smoke"})
        public void removeFirstContact () {
            Assert.assertEquals(app.getHelperContact().removeOneContact(),1);

        }

        @Test
        public void removeAllContact () {
        app.getHelperContact().removeAllContacts();
        Assert.assertTrue(app.getHelperContact().isNoContactsHereDisplayed());

        }
    }
