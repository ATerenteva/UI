package pobeda.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    WebDriver driver;

    String title;

    Actions builder;

    @FindBy(className = "dp-5wtb64")
    WebElement popUp;

    @FindBy(xpath = "//div[contains(@class, \"dp-2ri4z4\")]/a[contains(@class, \"dp-oz7gu4\")]/img[contains(@alt, \"«Авиакомпания «Победа», Группа «Аэрофлот»\")]")
    WebElement logo;

    @FindBy(xpath = "//a[contains(@href, \"/information\")]/div[contains(text(), \"Информация\")]")
    WebElement infoButton;

    @FindBy(className = "dp-72lm4u")
    WebElement FindTicketBlock;

    @FindBy(xpath = "//a[contains(@href, \"/services/booking-management\")]/div")
    WebElement bookingManagment;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.title = driver.getTitle();
        this.builder = new Actions(this.driver);
    }

    public WebElement getPopUp() {
        return popUp;
    }

    public void closePopUpWindow(){
        popUp.click();
    }

    public String getTitle() {
        return this.title;
    }

    public WebElement getLogo() {
        return logo;
    }

    public WebElement getFindTicketBlock() {
        return FindTicketBlock;
    }

    public void pointToInfo(){
        builder.moveToElement(infoButton).perform();
    }

    public void scrollToFindTicket(){
        builder.moveToElement(FindTicketBlock).perform();
    }

    public void scrollToBookingManagment(){
        builder.moveToElement(bookingManagment).perform();
    }

    public void clickBookingManagment(){
        bookingManagment.click();
    }
}
