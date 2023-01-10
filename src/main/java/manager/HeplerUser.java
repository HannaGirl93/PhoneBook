package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeplerUser extends HelperBase {

    public HeplerUser(WebDriver wd) {

        super(wd);
    }

    public void openLoginRegistrationForm() {

        click(By.cssSelector("a:last-child"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
        //for email
        type(By.cssSelector("input[name='email']"), email);
        //for password
        type(By.cssSelector("input[name='password']"), password);
    }

    public void submitLogin() {
        click(By.cssSelector("button[name='login']"));

    }

    public boolean isLogged() {
        return wd.findElement(By.xpath("//button[text()='Sign Out']")).isDisplayed();
    }

    public void logout() {
        click(By.xpath("//button[text()='Sign Out']"));
    }
}
