import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver selenium;

    @FindBy(css = ".sign-out-span>a")
    WebElement signOut;

    public HomePage(WebDriver selenium) {
        this.selenium = selenium;
        PageFactory.initElements(selenium, this);
    }

    public LoginPage toSingInPage(){
        signOutClick();
        return new LoginPage(selenium);
    }

    private void signOutClick(){
        signOut.click();
    }

    public boolean isSignoutPresent(){
        return signOut.isDisplayed();
    }
}
