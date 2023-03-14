package pobeda.ui;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class BookingPage {

    private SelenideElement orderNumber = $(By.id(":r4:"));

    private SelenideElement clientsName = $(By.id(":r3:"));

    private SelenideElement findButton = $(By.xpath("//div[contains(text(), \"Поиск\")]"));

    private SelenideElement messageError = $(By.className("message_error"));


    public SelenideElement getOrderNumber() {
        return orderNumber;
    }

    public SelenideElement getClientsName() {
        return clientsName;
    }

    public SelenideElement getFindButton() {
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

    public SelenideElement getMessageError() {
        return messageError;
    }
}
