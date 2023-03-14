package pobeda.ui;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

public class PobedaTests {

    MainPage objMain;
    InfoBlock objInfo;
    FindTicketBlock objTicket;
    BookingPage objBooking;

    @BeforeEach
    public void before(){
        Configuration.browserSize = "1920x1080";
        System.setProperty("chromeoptions.args", "--remote-allow-origins=*");
        open("https://pobeda.aero/");

        objMain = new MainPage();

        if(objMain.getPopUp().isDisplayed()) objMain.closePopUpWindow();
        Assertions.assertEquals(objMain.getTitle(), "Авиакомпания «Победа» - купить билеты на самолёт дешево онлайн, прямые и трансферные рейсы");
        Assertions.assertTrue(objMain.getLogo().isDisplayed());
    }

    @Test
    public void viewInformation(){
        objMain.pointToInfo();

        objInfo = new InfoBlock();
        Assertions.assertTrue(objInfo.getInfoWindow().isDisplayed());
        Assertions.assertTrue(objInfo.getInfoTitleReadyToFly().isDisplayed());
        Assertions.assertTrue(objInfo.getInfoUsefulInfo().isDisplayed());
        Assertions.assertTrue(objInfo.getInfoAboutCompany().isDisplayed());

    }

    @Test
    public void checkFindTicketBlock(){
        objMain.scrollToFindTicket();
        Assertions.assertTrue(objMain.getFindTicketBlock().isDisplayed());
        objTicket = new FindTicketBlock();
        Assertions.assertTrue(objTicket.getWhereFromField().isEnabled());
        Assertions.assertTrue(objTicket.getWhereField().isEnabled());
        Assertions.assertTrue(objTicket.getDateThereField().isEnabled());
        Assertions.assertTrue(objTicket.getDateBackField().isEnabled());

        objTicket.getWhereFromField().setValue("Москва").pressEnter();
        objTicket.getWhereField().setValue("Санкт-Петербург").pressEnter();

        objTicket.clickFindButton();

        Assertions.assertEquals(objTicket.getDateThereField().getCssValue("color"), "rgba(185, 0, 85, 1)");
    }

    @Test
    public void checkBookingPage(){
        objMain.scrollToBookingManagment();
        objMain.clickBookingManagment();

        objBooking = new BookingPage();
        Assertions.assertTrue(objBooking.getOrderNumber().isEnabled());
        Assertions.assertTrue(objBooking.getClientsName().isEnabled());
        Assertions.assertTrue(objBooking.getFindButton().isDisplayed());

        objBooking.getOrderNumber().setValue("XXXXXX");
        objBooking.getClientsName().setValue("Qwerty");
        objBooking.clickFindButton();

        switchTo().window(1);
        Assertions.assertEquals(objBooking.getMessageError().getText(), "Заказ с указанными параметрами не найден");
    }

}
