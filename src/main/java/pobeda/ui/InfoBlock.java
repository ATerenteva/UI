package pobeda.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InfoBlock {

    WebDriver driver;

    @FindBy(xpath = "//div[contains(@class, \"dp-1s9wcw1\")]")
    WebElement infoWindow;

    @FindBy(xpath = "//div[contains(text(), \"Подготовка к полёту\")]")
    WebElement infoTitleReadyToFly;

    @FindBy(xpath = "//div[contains(text(), \"Полезная информация\")]")
    WebElement infoUsefulInfo;

    @FindBy(xpath = "//a[contains(@href, \"/information#company\")]")
    WebElement infoAboutCompany;

    public InfoBlock(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getInfoWindow() {
        return infoWindow;
    }

    public WebElement getInfoTitleReadyToFly() {
        return infoTitleReadyToFly;
    }

    public WebElement getInfoUsefulInfo() {
        return infoUsefulInfo;
    }

    public WebElement getInfoAboutCompany() {
        return infoAboutCompany;
    }
}
