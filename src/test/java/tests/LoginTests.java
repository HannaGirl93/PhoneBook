package tests;

import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginSuccess(){

        app.getHeplerUser().openLoginRegistrationForm();
        app.getHeplerUser().fillLoginRegistrationForm("bunny@mail.com", "Bunny12345$");
        app.getHeplerUser().submitLogin();

    }

    @Test
    public void loginWrongEmail(){

    }

    @Test
    public void loginWrongPassword(){

    }

    @Test
    public void loginUnregisterUser(){

    }
}
