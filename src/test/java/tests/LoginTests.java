package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition() {
        //if(Sign out is present){
        //logout
        if(app.getHeplerUser().isLogged()){
            app.getHeplerUser().logout();
        }
    }


    @Test
    public void loginSuccess(){

        app.getHeplerUser().openLoginRegistrationForm();
        app.getHeplerUser().fillLoginRegistrationForm("bunny@mail.com", "Bunny12345$");
        app.getHeplerUser().submitLogin();
        //logout
    }

    @Test
    public void loginSuccessNew(){

        app.getHeplerUser().openLoginRegistrationForm();
        app.getHeplerUser().fillLoginRegistrationForm("bunny1@mail.com", "Bunny12345$");
        app.getHeplerUser().submitLogin();
        //logout

    }

    @Test
    public void loginWrongEmail(){
        app.getHeplerUser().openLoginRegistrationForm();
        app.getHeplerUser().fillLoginRegistrationForm("bunny1mail.com", "Bunny12345$");
        app.getHeplerUser().submitLogin();
    }

    @Test
    public void loginWrongPassword(){

    }

    @Test
    public void loginUnregisterUser(){

    }
}
