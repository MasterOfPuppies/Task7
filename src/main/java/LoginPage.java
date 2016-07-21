import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage{

    private WebDriver selenium;
    private String str = "RMSys - Sign In";
    private String url = "https://192.168.100.26/";

    @FindBy(css = "#SubmitButton")
    private WebElement submitButton;
    @FindBy(css = "#Username")
    private WebElement inputUsername;
    @FindBy(css = "#Password")
    private WebElement inputPassword;

    public LoginPage(WebDriver selenium){
        this.selenium = selenium;
        PageFactory.initElements(selenium, this);
    }

    public void load(){
        selenium.get(url);
    }

    public void isLoaded(){
        Assert.assertTrue(selenium.getTitle().equals(str));
    }

    private void inputData(String username, String password){
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
    }

    public HomePage login(String username, String password){
        inputData(username, password);
        clickSubmit();
        return new HomePage(selenium);
    }

    private void clickSubmit(){
        submitButton.click();
    }
}
