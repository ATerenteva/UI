package pobeda.ui;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    String title;

    private SelenideElement popUp =  $(By.className("dp-5wtb64"));

    private SelenideElement logo = $(By.xpath("//div[contains(@class, \"dp-2ri4z4\")]/a[contains(@class, \"dp-oz7gu4\")]/img[contains(@alt, \"«Авиакомпания «Победа», Группа «Аэрофлот»\")]"));

    private SelenideElement infoButton = $(By.xpath("//a[contains(@href, \"/information\")]/div[contains(text(), \"Информация\")]"));

    private SelenideElement FindTicketBlock = $(By.className("dp-72lm4u"));

    private SelenideElement bookingManagment = $(By.xpath("//a[contains(@href, \"/services/booking-management\")]/div"));

    public MainPage(){
        this.title = Selenide.title();
    }

    public SelenideElement getPopUp() {
        return popUp;
    }

    public void closePopUpWindow(){
        popUp.click();
    }

    public String getTitle() {
        return this.title;
    }

    public SelenideElement getLogo() {
        return logo;
    }

    public SelenideElement getFindTicketBlock() {
        return FindTicketBlock;
    }

    public void pointToInfo(){
        infoButton.hover();
    }

    public void scrollToFindTicket(){
        FindTicketBlock.hover();
    }

    public void scrollToBookingManagment(){
        bookingManagment.hover();
    }

    public void clickBookingManagment(){
        bookingManagment.click();
    }
}
