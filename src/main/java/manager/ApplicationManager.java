package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class ApplicationManager {

    WebDriver wd;
    HeplerUser heplerUser;
    public void init() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();//расскрытие на весь экран
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//проверка в теч 5 секунд на отрисовку элемента
        wd.navigate().to("https://telranedu.web.app");
        heplerUser = new HeplerUser(wd);
    }

    public void stop() {
        wd.quit();
    }

    public HeplerUser getHeplerUser() {
        return heplerUser;
    }
}
