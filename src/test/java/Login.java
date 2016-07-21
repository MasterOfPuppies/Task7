import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import static org.testng.Assert.assertTrue;

public class Login {
    WebDriver selenium;
    private LoginPage lp;
    private HomePage hp;

    @BeforeClass
    public void setUp(){
        selenium = new FirefoxDriver();
    }

    @AfterClass
    public void tearDown(){
        selenium.close();
    }

    @Test
    public void loginTest(){
        lp = new LoginPage(selenium);
        lp.get();
        hp = lp.loginOperation("eugenborisik","1");
        assertTrue(hp.isSignoutPresent());
    }

    @Test
    public void signoutTest(){
        lp = hp.toSingInPage();
        lp.isLoaded();
    }
}
