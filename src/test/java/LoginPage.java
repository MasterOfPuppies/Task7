import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

public class LoginPage extends LoadableComponent<LoginPage>{

    WebDriver selenium;
    private String str = "RMSys - Sign In";
    private String url = "https://192.168.100.26/";

    @FindBy(css = "#SubmitButton")
    WebElement submitButton;
    @FindBy(css = "#Username")
    WebElement inputUsername;
    @FindBy(css = "#Password")
    WebElement inputPassword;

    public LoginPage(WebDriver selenium){
        this.selenium = selenium;
        PageFactory.initElements(selenium, this);
    }

    @Override
    protected void load(){
        selenium.get(url);
    }

    @Override
    protected void isLoaded(){
        Assert.assertTrue(selenium.getTitle().equals(str));
    }

    private void inputUserData(String username, String password){
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
    }

    public HomePage loginOperation(String username, String password){
        inputUserData(username, password);
        clickSubmit();
        return new HomePage(selenium);
    }

    private void clickSubmit(){
        submitButton.click();
    }
}
