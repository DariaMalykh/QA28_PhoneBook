package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(app.getHelperUser().isLogged())
            app.getHelperUser().logout();
    }

    @Test
    public void RegistrationSuccess(){
        Random random = new Random();
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        User user = new User().setEmail("Dd"+i+"@gmail.com").setPassword("Password$123");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());
    }

    @Test
    public void RegistrationExistUser(){
        User user = new User().setEmail("d@gmail.com").setPassword("DariaM1991!");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));
    }

    @Test(description = "Bug report #12365",groups = {"smoke"})
    public void RegistrationWrongEmail(){
        Random random = new Random();
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        User user = new User().setEmail("Dd"+i+"gmail.com").setPassword("Password$123");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
    }
    @Test
    public void RegistrationWrongPassword(){
        Random random = new Random();
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        User user = new User().setEmail("Dd"+i+"gmail.com").setPassword("123");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
    }
    @Test
    public void RegistrationEmptyEmail(){
        Random random = new Random();
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        User user = new User().setEmail("").setPassword("Password$123");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
    }
    @Test
    public void RegistrationEmptyPassword(){
        Random random = new Random();
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        User user = new User().setEmail("Dd"+i+"gmail.com").setPassword("");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
    }
}
