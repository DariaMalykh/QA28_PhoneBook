package tests;

import manager.DataProviderContact;
import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddNewContactTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("d@gmail.com").setPassword("DariaM1991!"));
        }
    }

        @Test
        public void addContactSuccessAllFields(){
            int i = (int)((System.currentTimeMillis()/1000)%3600);

           Contact contact = Contact.builder()
            .name("Bobby"+i).LastName("Stark").address("NY").phone("1235781"+i).email("stark"+i+"@gmail.com").description("The best").build();
           app.getHelperContact().openContactForm();
           app.getHelperContact().fillContactForm(contact);
           app.getHelperContact().saveContact();
            app.getHelperContact().getScreen("src/test/screenshots/screen-"+i+".png");
            Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
            Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));

        }

    @Test
    public void addContactSuccessReqFields(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);

        Contact contact = Contact.builder()
                .name("Anton"+i).LastName("Maslo").address("NY").phone("1235785"+i).email("stark"+i+"@gmail.com").build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));
    }

    @Test(dataProvider = "contactSuccess",dataProviderClass = DataProviderContact.class)
    public void addContactSuccessWithDataProvider(Contact contact){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        app.getHelperContact().getScreen("src/test/screenshots/screen-"+i+".png");
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));

    }
    @Test(dataProvider = "contactCSV",dataProviderClass = DataProviderContact.class)
    public void addContactSuccessAllFieldsWithDataProviderFromFile(Contact contact){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        //app.getHelperContact().pause(15000);
        app.getHelperContact().getScreen("src/test/screenshots/screen-"+i+".png");
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));

    }

    @Test
    public void addNewContactWrongName(){

            Contact contact = Contact.builder()
                    .name("").LastName("Stark").address("NY").phone("1235781675").email("stark@gmail.com").description("The best").build();
            app.getHelperContact().openContactForm();
            app.getHelperContact().fillContactForm(contact);
            app.getHelperContact().saveContact();
            Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());

    }

    @Test
    public void addNewContactWrongLastName(){
        Contact contact = Contact.builder()
                .name("Bobby").LastName("").address("NY").phone("1235781906").email("stark@gmail.com").description("The best").build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //app.getHelperContact().pause(15000);
        app.getHelperContact().getScreen("src/test/screenshots/screen .png");
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());

    }

    @Test
    public void addNewContactWrongAddress(){
        Contact contact = Contact.builder()
                .name("Bobby").LastName("Stark").address("").phone("1235781098").email("stark@gmail.com").description("The best").build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());

    }

    @Test
    public void addNewContactWrongPhone(){
        Contact contact = Contact.builder()
                .name("Bobby").LastName("Stark").address("NY").phone("").email("stark@gmail.com").description("The best").build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent(" Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));

    }
    @Test(dataProvider = "contactWrongPhone",dataProviderClass = DataProviderContact.class)
    public void addNewContactWrongPhoneWithDataProvider(Contact contact){
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent(" Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));

    }

    @Test
    public void addNewContactWrongEmail(){
        Contact contact = Contact.builder()
                .name("Bobby").LastName("Stark").address("NY").phone("1235781054").email("starkgmail.com").description("The best").build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent("Email not valid:"));

    }


    }


