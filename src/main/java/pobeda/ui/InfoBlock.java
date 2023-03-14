package pobeda.ui;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class InfoBlock {

    private SelenideElement infoWindow = $(By.xpath("//div[contains(@class, \"dp-1s9wcw1\")]"));

    private SelenideElement infoTitleReadyToFly = $(By.xpath("//div[contains(text(), \"Подготовка к полёту\")]"));

    private SelenideElement infoUsefulInfo = $(By.xpath("//div[contains(text(), \"Полезная информация\")]"));

    private SelenideElement infoAboutCompany = $(By.xpath("//a[contains(@href, \"/information#company\")]"));

    public SelenideElement getInfoWindow() {
        return infoWindow;
    }

    public SelenideElement getInfoTitleReadyToFly() {
        return infoTitleReadyToFly;
    }

    public SelenideElement getInfoUsefulInfo() {
        return infoUsefulInfo;
    }

    public SelenideElement getInfoAboutCompany() {
        return infoAboutCompany;
    }
}
