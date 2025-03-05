package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm(){
        //WebElement loginTab = wd.findElement(By.cssSelector("a[href='/login']"));
       // WebElement loginTab = wd.findElement(By.xpath("a[text()]='LOGIN"));
        //loginTab.click();
        click(By.cssSelector("a[href='/login']"));
        logger.info("Open form by click on button with locator (By.cssSelector(\"a[href='/login']\")'");
    }

    public void fillLoginRegistrationForm(String email, String password) {
        //WebElement emailInput = wd.findElement(By.name("email"));
        type(By.name("email"),email);
        logger.info("Tpe in input with  locator By.name(\"email\"),email");
        //WebElement passwordInput = wd.findElement(By.xpath("//input[last()]"));
        type(By.xpath("//input[last()]"),password);


    }

    public void submitLogin(){
        click(By.xpath("//button[text()='Login']"));
    }
    public void submitRegistration() {
        click(By.xpath("//button[text()='Registration']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[text() = 'Sign Out']"));
    }

    public void logout() {
        click(By.xpath("//button[text() = 'Sign Out']"));
    }


    public void fillLoginRegistrationForm(User user) {
        type(By.name("email"), user.getEmail());
        //type(By.xpath("//input[last()]"), user.getPassword());
        type(By.xpath("//input[la]"), user.getPassword());
    }


    public void login(User user) {
        openLoginRegistrationForm();
        fillLoginRegistrationForm(user);
        submitLogin();
    }
}
