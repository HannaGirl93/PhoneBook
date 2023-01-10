package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void preCondition() {
        //if(Sign out is present){
        //logout
        if(app.getHeplerUser().isLogged()){
            app.getHeplerUser().logout();
        }
    }


    @Test
    public void registrationSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000);
        String email = "bunny" + i + "@mail.com";

        app.getHeplerUser().openLoginRegistrationForm();
        app.getHeplerUser().fillLoginRegistrationForm(email, "Bunny12345$");
        app.getHeplerUser().submitRegistration();
        //logout
        Assert.assertTrue(app.getHeplerUser().isLogged());
    }

    @Test
    public void registrationWrongEmail(){
        app.getHeplerUser().openLoginRegistrationForm();
        app.getHeplerUser().fillLoginRegistrationForm("bunnygmail.com", "Bunny12345$");
        app.getHeplerUser().submitRegistration();
        //logout
        Assert.assertFalse(app.getHeplerUser().isLogged());
        Assert.assertTrue(app.getHeplerUser().isErrorMessageDisplayed("Wrong email or password"));
    }

    @Test
    public void registrationWrongPassword(){
        app.getHeplerUser().openLoginRegistrationForm();
        app.getHeplerUser().fillLoginRegistrationForm("bunny@gmail.com", "Bunny12");
        app.getHeplerUser().submitRegistration();
        //logout
        Assert.assertFalse(app.getHeplerUser().isLogged());
        Assert.assertTrue(app.getHeplerUser().isErrorMessageDisplayed("Wrong email or password"));
    }

    @Test
    public void registrationUserAlreadyExist(){
        app.getHeplerUser().openLoginRegistrationForm();
        app.getHeplerUser().fillLoginRegistrationForm("bunny@mail.com", "Bunny12345$");
        app.getHeplerUser().submitRegistration();
        Assert.assertFalse(app.getHeplerUser().isLogged());
    }

}
