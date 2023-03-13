package pobeda.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingPage {

    WebDriver driver;

    @FindBy(id = ":r4:")
    WebElement orderNumber;

    @FindBy(id = ":r3:")
    WebElement clientsName;

    @FindBy(xpath = "//div[contains(text(), \"Поиск\")]")
    WebElement findButton;

    @FindBy(className = "message_error")
    WebElement messageError;

    public BookingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getOrderNumber() {
        return orderNumber;
    }

    public WebElement getClientsName() {
        return clientsName;
    }

    public WebElement getFindButton() {
        return findButton;
    }

    public void clickOrderNumber(){
        orderNumber.click();
    }

    public void clickClientsName(){
        clientsName.click();
    }

    public void clickFindButton(){
        findButton.click();
    }

    public WebElement getMessageError() {
        return messageError;
    }
}
