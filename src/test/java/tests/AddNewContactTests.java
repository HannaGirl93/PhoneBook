package tests;

import model.Contact;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContactTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(User.builder().email("noa@gmail.com").password("Nnoa12345$").build());
        }
    }

    @Test
    public void addContactSuccessAllFields(){
        Random random = new Random();
        int i= random.nextInt(1000)+1000;
        Contact contact = Contact.builder()
                .name("Lisa"+i)
                .lastName("Simpson")
                .address("NY")
                .phone("1111111"+i)
                .email("lisa"+i+"@mail.ru")
                .description("The best friend").build();
        System.out.println(contact.toString());

        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().submitContactForm();
        Assert.assertTrue(app.helperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.helperContact().isContactAddedByPhone(contact.getPhone()));
        // Assert.assertTrue(app.helperContact().isContactAddedByEmail(contact.getEmail()));


    }
    @Test
    public void addContactSuccessRequiredFields(){
        Random random = new Random();
        int i= random.nextInt(1000)+1000;
        Contact contact = Contact.builder()
                .name("Marge"+i)
                .lastName("Simpson")
                .address("NY")
                .phone("1111111"+i)
                .email("marge"+i+"@mail.ru")
                .build();
        System.out.println(contact.toString());

        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().submitContactForm();
        Assert.assertTrue(app.helperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.helperContact().isContactAddedByPhone(contact.getPhone()));
        // Home Work
        Assert.assertTrue(app.helperContact().isContactAddedByEmail(contact.getEmail()));


    }

}